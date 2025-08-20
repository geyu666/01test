//7.30.3
//最长公共前缀
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//
//
//示例 1：
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//示例 2：
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//提示：
//
//        1 <= strs.length <= 200
//        0 <= strs[i].length <= 200
//strs[i] 如果非空，则仅由小写英文字母组成
//
//来源：https://leetcode.cn/problems/longest-common-prefix/description/?envType=problem-list-v2&envId=array
//难度：简单
package test01;
import java.util.*;
public class test7303 {
    public static void main(String[] args) {
        //输入转换成String数组
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.replaceAll("[\\[\\]\"]","").split(",");
        Set<Character> common = new HashSet<>();
        int num = 0;
        Set<Character> toRemove = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        //不能在遍历的同时修改set元素，先用另一个set:toRemove收集要删掉的元素，再common.removeAll(toRemove);
        for(String s: strArr){
            if(common.isEmpty() && num == 0){
                for(char c: s.toCharArray()){
                    common.add(c);
                }
                num++;
            }
            for(char c: common){
                if(!s.contains(String.valueOf(c))){
                    toRemove.add(c);
                }
            }
            common.removeAll(toRemove);
        }
        //char数组转变成字符串的办法
        for(char c: common){
            sb.append(c);
        }
        System.out.println(sb);
    }
}
