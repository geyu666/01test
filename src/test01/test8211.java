/*给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。



示例 1：

输入:a = "11", b = "1"
输出："100"
示例 2：

输入：a = "1010", b = "1011"
输出："10101"

1. 转换输入
2. 计算和
3. 转换输出

提示：

        1 <= a.length, b.length <= 104
a 和 b 仅由字符 '0' 或 '1' 组成
字符串如果不是 "0" ，就不含前导零

来源：https://leetcode.cn/problems/add-binary/description/
难度：简单*/
package test01;

import java.util.Scanner;

public class test8211 {
    public static String addBinary(String a, String b) {
        // 将二进制字符串转换为十进制数
        int numA = Integer.parseInt(a, 2);
        int numB = Integer.parseInt(b, 2);

        // 计算十进制数的和
        int sum = numA + numB;

        // 将十进制和转换回二进制字符串
        return Integer.toBinaryString(sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(addBinary(a, b));
    }
}
