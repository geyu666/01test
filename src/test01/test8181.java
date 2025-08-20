/*杨辉三角 II
给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。

示例 1:

输入: rowIndex = 3
输出: [1,3,3,1]
示例 2:

输入: rowIndex = 0
输出: [1]
示例 3:

输入: rowIndex = 1
输出: [1,1]


提示:

        0 <= rowIndex <= 33


进阶：

你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
1.定义数组与rowIndex
2.相加
(1)相邻相加
(2)赋值给i+1,j+1
3.打印所需的那一行
来源：https://leetcode.cn/problems/pascals-triangle-ii/description/?envType=problem-list-v2&envId=array
难度：简单*/
package test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test8181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowIndex = sc.nextInt();
        int[][] array = new int[34][34];
        if(rowIndex == 0){
            array[0][0] = 1;
        }
        else if(rowIndex == 1){
            array[0][0] = 1;
            array[1][0] = 1;
            array[1][1] = 1;
        }
        else{
            array[0][0] = 1;
            array[1][0] = 1;
            array[1][1] = 1;
            for(int i = 2;i <= rowIndex;i++){
                array[i][0] = array[i][i] = 1;
                for(int j = 1;j <= i;j++){
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                }
            }
        }
        //todo 用list打印
        List<Integer> row = new ArrayList<>(rowIndex);
        for(int i = 0;i <= rowIndex;i++){
            row.add(array[rowIndex][i]);
        }
        System.out.println(row);
    }
}
