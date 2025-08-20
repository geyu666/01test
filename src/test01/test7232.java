//求素数
//设计一个程序, 输入N, 输出0~N之间的所有素数
//        (0<N<MAX_INT)
//样例输入:
//        100
//样例输出:
//        2
//        3
//        5
//        7
//        11
//        13
//        17
//        19
//        23
//        29
//        31
//        37
//        41
//        43
//        47
//        53
//        59
//        61
//        67
//        71
//        73
//        79
//        83
//        89
//        97
//
//来源：日常练习题-嵌套循环-第2题
//难度：简单

package test01;
import java.util.Scanner;

public class test7232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N >= 2){
            for(int i = 2;i <= N;i++){
                boolean bool = true;
                for(int j = 2;j < i;j++){ //当i==2时，由于j<i不成立，因此循环体不会执行，bool保持true
                    if(i % j == 0){
                        bool = false;
                        break;
                    }
                }
                if(bool){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
