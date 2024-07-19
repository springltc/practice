package com.example.coding.lec经典150.二分查找.中等;

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
public class 搜索二维矩阵 {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] matrix = {{1}, {3}};
        int target = 3;
//        System.out.println(matrix.length);
//        System.out.println(matrix[0][0]);

        boolean searchMatrix = searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int n = matrix[i].length;
            //最后一个元素都 < target ,则一定在下一个
            if (matrix[i][n - 1] < target) {
                continue;
            }
            //第一个元素都大于target ,则后面都不存在了
            if (matrix[i][0] > target) {
                break;
            }

            int l = 0, r = n - 1, m = 0;
            while (l <= r) {
                m = (l + r) / 2;
                if (matrix[i][m] == target) {
                    return true;
                } else if (matrix[i][m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return false;
    }

}
