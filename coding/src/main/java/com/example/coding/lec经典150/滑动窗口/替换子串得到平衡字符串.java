package com.example.coding.lec经典150.滑动窗口;

/**
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * 示例 1：
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * <p>
 * 示例 2：
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * <p>
 * 示例 3：
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * <p>
 * 示例 4：
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 */
//https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
public class 替换子串得到平衡字符串 {

    public int balancedString(String s) {
        int n = s.length();
        int[] arr = new int[n];
        int[] ints = new int[4];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int index = c == 'Q' ? 1 : c == 'W' ? 2 : c == 'E' ? 3 : 0;
            arr[i] = index;
            ints[index]++;
        }

        int require = n / 4;
        int aws = n;
        for (int l = 0, r = 0; l < n; l++) {
            while (!ok(ints, r - l, require) && r < n) {
                ints[arr[r++]]--;
            }

            if (ok(ints, r - l, require)) {
                aws = Math.min(aws, r - l);
            }

            ints[arr[l]]++;
        }

        return aws;
    }

    private boolean ok(int[] ints, int len, int require) {
        for (int i = 0; i < 4; i++) {
            if (ints[i] > require) {
                return false;
            }
            len -= require - ints[i];
        }
        return len == 0;
    }
}
