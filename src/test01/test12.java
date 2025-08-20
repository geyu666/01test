//杨辉三角
//链接：https://leetcode.cn/problems/pascals-triangle/description/?envType=problem-list-v2&envId=array
//        1.输入numRows
//        2.判断
//        （1）numRows <= 2
//        直接生成前两个数组
//        （2）numRows > 2
//        第一位+第二位 = newNum
//        中间位 = num
//        （3）结果放入大数组
//        （4）输出数组
package test01;
import java.util.*;
public class test12 {
    public static void main(String[] args) {
        ArrayList<String> listShow = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();
        int[] listOld = new int[numRows];//上一行数字
        for (int i = 0; i < numRows; i++) {
            int[] listNew = new int[i+1];//下一行数字
            for (int j = 0; j < i+1; j++) {
                listNew[j] = 1;
            }
            if(i > 1){
                for (int j = 1; j < i; j++) {
                    int newNum = listOld[j-1] + listOld[j];
                    listNew[j] = newNum;//赋值
                }
            }
            listOld = listNew.clone();
            listShow.add(Arrays.toString(listOld));
        }
        System.out.print(listShow);
    }
}
