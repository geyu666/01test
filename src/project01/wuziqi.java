package project01;
import java.util.*;

import static java.lang.System.exit;

public class wuziqi {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        menuView();
    }


    // -------------------- 数据设计 --------------------
/*
    棋盘:
        board[i][j]表示坐标(i,j)的值
        0表示空地
        1表示黑子
        2表示白子
    如: board[3][6] = 1  表示(3,6)的位置是黑子
*/
    public static int[][] board = new int[19][19];

    // 表示当前回合数  偶数表示黑棋落子  奇数表示白棋落子
// 如: flag = 20 表示当前是第[20]次落子  由黑方落子
    public static int flag;
// -------------------- 数据设计 --------------------


    // -------------------- service --------------------
/*
    负责人: 张三
    功能: 初始化游戏数据
        将棋盘的值初始化为0
        当前回合设为黑棋(flag设为0)
    参数: void
    返回值: void
*/
    public static void init(){
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                board[i][j] = 0;
            }
        }

        flag = 0;
    }

    /*
        *难点1
        负责人: 张三
        功能: 根据传入的坐标(board对应位置)和flag值 判断落点后是否获胜
        参数:
            x: 当前回合落子的x坐标
            y: 当前回合落子的y坐标
        返回值:
            0表示没有获胜
            1表示黑子胜利
            2表示白子胜利
    */
    //（1）判断Player是哪一方
    //（2）检查四个方向
    //（3）有一个方向满足即可结束游戏
    public static int isWin(int x, int y){
        int player = (flag % 2 == 0) ? 1 : 2;
        if(check(x, y, 1, 0, player)
                || check(x, y, 0, 1, player)
                || check(x, y, 1, 1, player)
                || check(x, y, 1, -1, player))
        {
            return player;
        }
        return 0;
    }

    public static boolean check(int x, int y, int dx, int dy, int player){
        int count = 1;
        int nx = x;
        int ny = y;
        for(int i = 1; i < 5; i++){    //正向检查
            nx = nx + dx;
            ny = ny + dy;
            if(nx < 0 || nx > 19 || ny < 0 || ny > 19 || board[ny][nx] != player){
                break;
            }
            count++;
        }
        nx = x;
        ny = y;
        for(int i = 1; i < 5; i++){    //反向检查
            nx = nx - dx;
            ny = ny - dy;
            if(nx < 0 || nx > 19 || ny < 0 || ny > 19 || board[ny][nx] != player){
                break;
            }
            count++;
        }
        return count>=5;        //当count>=5时才返回true
    }
    /*
        负责人: 张三
        功能: 在指定位置落子
            如果board[x][y]是空地 则修改board[x][y]的值:改为相应颜色(flag对应颜色)        否则不操作
        参数:
            x: 当前回合落子的x坐标
            y: 当前回合落子的y坐标
        返回值:
            0表示落子失败 (棋盘已经有子)
            1表示落子成功

    */
    public static int playerMove(int x, int y){
        if(board[y][x] == 0 && flag%2 == 0){
            board[y][x] = 1;
            return 1;
        }
        else if(board[y][x] == 0 && flag%2 == 1){
            board[y][x] = 2;
            return 1;
        }
        else{
            return 0;
        }
    }
// -------------------- service --------------------



    // -------------------- view --------------------
/*
    功能: 展示选项, 玩家可以在这里选择进入游戏, 进入设置或退出游戏
        while(1){
            1. 展示选项
            2. 用户输入
            3. 根据输入进行对应处理
                进入游戏: 调用游戏界面函数gameView();
                进入设置: 打印敬请期待... 重新循环
                退出游戏: 调用exit(0);
        }
*/
    public static void menuView(){
        while(true){
            System.out.println("1.进入游戏");
            System.out.println("2.进入设置");
            System.out.println("3.退出游戏");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    gameView();
                    break;
                case 2:
                    System.out.println("敬请期待...");
                    menuView();
                case 3:
                    exit(0);
            }
        }
    }

    /*
        负责人: 张三
        功能: 根据board数组 打印游戏棋盘
        参数: void
        返回值: void
    */
    public static void gameView_ShowBoard(){
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
        负责人: 张三
        功能: 根据flag的值  打印游戏胜利界面  用户可以按回车键回到主菜单
        参数: void
        返回值: void
    */
    public static void winView(){
        if(flag%2 == 0){
            System.out.println("黑子获胜！");
        }
        else{
            System.out.println("白字获胜！");
        }
    }

    /*
        *难点2
        负责人: 张三
        功能: 游戏界面整合
            初始化游戏数据(调用函数init())
            while(1){
                打印游戏界面(调用函数gameView_ShowBoard())
                接收玩家坐标输入

                落子(调用落子函数playerMove())
                    (如果落子失败 重新开始循环)

                判断游戏是否胜利(调用胜利判断函数isWin())
                    (如果游戏胜利 调用胜利界面函数 然后结束当前界面)
                切换玩家(修改flag值)
            }
        参数: void
        返回值: void
    */
    public static void gameView(){
        init();
        while(true){
            gameView_ShowBoard();
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(playerMove(x,y) == 0){
                System.out.println("落子失败！该点已有棋子");
            }
            else{
                playerMove(x,y);
            }
            if(isWin(x,y) != 0){
                winView();
                break;
            }
            else{
                flag++;
            }
        }
    }
}
