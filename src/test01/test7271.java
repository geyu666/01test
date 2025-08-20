package test01;

import java.util.*;

public class test7271 {
    public static void main(String[] args) {
        User.showLoginPage();
    }
    public static class Message
    {
        Map<Integer, String> idmap = new HashMap<Integer, String>();
        static int[] ids = {10001,10002,10003,10004};
        static String[] names = {"张三", "李四", "王五", "赵六"};
        static String[] passwords = {"aaaaa","bbbbb","ccccc","ddddd"};
        int uNum = 4;
    }

    public static class User{
        static String selectUserById(int uid) {
            for (int i = 0; i < Message.ids.length; i++) {
                if (uid == Message.ids[i]) {
                    return Message.names[i];
                }
            }
            return null;
        }

        static String selectPassById(int uid){
            for (int i = 0; i < Message.ids.length; i++) {
                if (uid == Message.ids[i]) {
                    return Message.passwords[i];
                }
            }
            return null;
        }

        static int login(int uid, String password){
            if(selectUserById(uid) == null){
                return 1;
            }
            if (selectPassById(uid) != null) {
                return 0;
            }
            else {
                return 2;
            }
        }

        static void showLoginPage(){
            Scanner sc = new Scanner(System.in);
            int uid = sc.nextInt();
            sc.nextLine();
            String password = sc.nextLine();
            if(login(uid,password) == 0){
                String str = "成功登录！";
            }
            else if (login(uid,password) == 2) {
                String str = "密码错误，请重新登录！";
            }
            else {
                String str = "账号不存在！正在进入注册界面";
            }
        }
    }
}

