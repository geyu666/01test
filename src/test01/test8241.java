/*有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：

输入：s = "()"

输出：true

示例 2：

输入：s = "()[]{}"

输出：true

示例 3：

输入：s = "(]"

输出：false

示例 4：

输入：s = "([])"

输出：true

示例 5：

输入：s = "([)]"

输出：false

1.输入转换 2.循环判断 3.返回结果

提示：

        1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成

来源：https://leetcode.cn/problems/valid-parentheses/
难度：简单*/
package test01;

import java.util.Scanner;

public class test8241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean result = false;

        for(int i = 0; i < s.length(); i+=2){
            if(s.charAt(i) == '('){
                for(int j = i+1; j < s.length(); j+=2){
                    if (s.charAt(j) == ')') {
                        result = true;
                        break;
                    }
                }
            }
            if(s.charAt(i) == '[')
                for(int j = i+1; j < s.length(); j+=2){
                    if (s.charAt(j) == ']') {
                        result = true;
                        break;
                    }
                }
            if(s.charAt(i) == '{')
                for(int j = i+1; j < s.length(); j+=2){
                    if (s.charAt(j) == '}') {
                        result = true;
                        break;
                    }
                }
        }
        System.out.println(result);
    }
}
