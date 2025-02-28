package com.example.coding;

import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author liutc
 * @date 2024/1/9 18:33
 */
public class NoGenerator {
    /**
     * 机器位值
     */
    private final long machineValue;
    /**
     * 最大序列号值(决定了一分钟最大并发量)
     */
    private final long maxSequence;
    /**
     * 最大尾号(机器码+序列值)
     */
    private final int maxMantissaLength;

    /**
     * 序列号
     */
    private long lastSequence = 0L;
    /**
     * 上一次时间戳
     */
    private long lastStamp = -1L;

    /**
     * @param machineBit  机器位数
     * @param sequenceBit 序列位数(最优值19)
     * @param machineId   机器标识
     */
    public NoGenerator(long machineBit, long sequenceBit, long machineId) {
        if ((machineBit + sequenceBit) >= 64) {
            throw new IllegalArgumentException("整个尾号超过64位");
        }

        if (machineId <= 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }

        if (machineId > ~(-1L << machineBit)) {
            machineId = machineId % ~(-1L << machineBit);
        }

        this.machineValue = machineId << sequenceBit;

        this.maxSequence = ~(-1L << sequenceBit);

        this.maxMantissaLength = String.valueOf(~(-1L << (machineBit + sequenceBit))).length();
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized String nextNo() {
        long currentStamp = getCurrentSecond();

        // 防止倒钟和超跑情况
        if (currentStamp < lastStamp) {
            currentStamp = lastStamp;
        }

        if (currentStamp == lastStamp) {
            // 相同秒内
            // 序列号自增
            lastSequence = (lastSequence + 1) & maxSequence;
            if (lastSequence == 0L) {
                // 序列号归零，锁下一秒
                currentStamp = getNextSecond();
            }
        } else {
            // 不同秒内，序列号置为0
            lastSequence = 0L;
        }

        lastStamp = currentStamp;

        // 机器号+序列号
        long mantissa = this.machineValue | lastSequence;

        String mantissaStr = StringUtils.leftPad(String.valueOf(mantissa), this.maxMantissaLength, '0');

        return DateUtil.format(new Date(lastStamp * 1000), "yyyyMMddHHmmss") + mantissaStr;
    }

    private long getNextSecond() {
        long mill = getCurrentSecond();
        while (mill <= lastStamp) {
            mill = getCurrentSecond();
        }
        return mill;
    }

    private static long getCurrentSecond() {
        return System.currentTimeMillis() / 1000;
    }

    public static void main(String[] args) {
        NoGenerator generator = new NoGenerator(5, 12, 5);
        for (int i = 0; i < 10; i++) {
            System.err.println(generator.nextNo());
        }
    }
}
