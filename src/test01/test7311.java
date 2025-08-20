/*
7.31
制作一个排行榜, 每次修改其数据时, 都会在文件中进行对应操作.
        该排行榜可以展示名次, 昵称, 积分三个属性
每次用户可以输入昵称和积分, 来向排行榜中加入数据.
        (昵称长度<10, 积分<10000)
加入数据时, 如果排行榜中存储数量超过10个, 则删除最后一名的数据.
        样例输入:
张三 100
样例输出:
名次| 昵称| 积分
1   测试1  1001
2   测试2  100
3   张三   100
4   测试3  10
1.创建输入文件流
2.向文件添加数据
(1)添加 名次| 昵称| 积分
(2)添加 测试，用for循环加入文件
3.输出文件内容
来源：日常练习题-文件流
难度：简单*/
package test01;

import java.io.*;
import java.util.*;

public class test7311 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("测试1", 1001);
        map.put("测试2", 100);
        map.put("测试3", 10);

        //todo 解析输入字符
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] parts = str.split(" ");
        if(parts.length == 2){
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);
            map.put(name,score);
        }

        //todo 排序
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(int i = 0; i < 10; i++) {
            if(map.isEmpty()){
                break;
            }
            String name = "";
            int max = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) { //entry表示map里的一个基本元素
                String name1 = entry.getKey();
                int score = entry.getValue();
                if (entry.getValue() >= max) {
                    name = name1;
                    max = score;
                }
            }
            sortedMap.put(name, max);
            map.remove(name);
        }
        System.out.println(sortedMap);
        //todo 写入文件
        File dest = new File("D:\\jdk1.8.0_281\\code\\01jdk1.8.0\\src\\test01\\test.txt");
        try(
            FileOutputStream out = new FileOutputStream(dest);
            BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
            OutputStreamWriter writer = new OutputStreamWriter(bufferedOut);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);){
            bufferedWriter.write("名次| 昵称| 积分");
            bufferedWriter.newLine();
            int i = 1;
            for(Map.Entry<String, Integer> entry : sortedMap.entrySet()){
                bufferedWriter.write(String.format("%d %s %s",i,entry.getKey(),entry.getValue()));
                bufferedWriter.newLine();
                i++;
            }

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
