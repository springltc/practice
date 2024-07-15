package com.example.coding.lec经典150.双指针.中等;

/**
 * @author liutc
 * @date 2024/2/7 09:43
 */

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        method1(height);
    }

    public static int method1(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static int method2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] > height[j] ?
                    Math.max(res, (j - i) * height[j--]) :
                    Math.max(res, (j - i) * height[i++]);
        }
        return res;
    }
}
/**
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 题解:
 * 设两指针 iii , jjj ，指向的水槽板高度分别为 h[i]h[i]h[i] , h[j]h[j]h[j] ，此状态下水槽面积为 S(i,j)S(i, j)S(i,j) 。由于可容纳水的高度由两板中的 短板 决定，因此可得如下 面积公式 ：
 * <p>
 * S(i,j)=min(h[i],h[j])×(j−i)S(i, j) = min(h[i], h[j]) × (j - i)
 * S(i,j)=min(h[i],h[j])×(j−i)
 */
