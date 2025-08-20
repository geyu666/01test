//使用程序打印九九乘法表
//样例输出:
//        1 * 1 = 1
//        1 * 2 = 2 2 * 2 = 4
//        1 * 3 = 3 2 * 3 = 6 3 * 3 = 9
//        ….
//
//来源：日常练习题-嵌套循环-第1题
//难度：简单

package test01;

public class test7231 {
    public static void main(String[] args) {
        for(int i = 1;i <= 9;i++){
            for (int j = 1;j <= i;j++){
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
