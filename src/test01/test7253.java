//3. 杨辉三角
//输入n(1<n<10), 打印高度为n的杨辉三角
//样例输入: 5
//样例输出:
//        1
//        1 1
//        1 2 1
//        1 3 3 1
//        1 4 6 4 1
//
//来源：每日练习题-多维数组-第3题
//难度：简单

package test01;
import java.util.*;

public class test7253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j <= i;j++){
                nums[i][j] = 1;
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j <= i;j++){
                int[][] numsNew = new int[n][n];
                if(i > 0 && j > 0){
                    numsNew[i][j] = nums[i-1][j-1] + nums[i-1][j];
                    nums[i][j] = numsNew[i][j];
                }
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j <= i;j++){
                System.out.printf(nums[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
