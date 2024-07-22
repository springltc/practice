package com.example.coding.lec经典150.二分查找.中等.demo;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
//https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150
public class 搜索二维矩阵 {

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        int target = 0;

        boolean searchMatrix = searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }

    /**
     * 没有处理第一行数据 判断条件需要优化
     *
     * @param matrix
     * @param target
     * @return
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        int index = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]) {
                index = i;
                break;
            }
            if (matrix[i][0] > target) {
                return false;
            }
        }
        if (index == -1) {
            return false;
        }

        int l = 0, r = matrix[index].length, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (matrix[index][m] == target) {
                return true;
            } else if (matrix[index][m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }

}
