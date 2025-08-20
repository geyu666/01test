/*实现该学生管理系统
class Person:
抽象类, 具有人的基本属性和方法
属性:
成员变量: 年龄(age), 姓名(name), 性别(sex)
静态变量: count: 用于统计有多少Person对象
方法:
构造方法: 传入年龄, 性别和姓名. 将对应数据进行修改
        抽象方法show; 打印该对象的信息
class Student:
继承自Person类
属性:
成员变量: 学号(sid)
静态变量: count: 用于统计有多少Student对象
方法:
构造方法: 传入年龄, 性别和姓名, 将对应数据进行修改. 并通过hashCode()生成学号
equals方法: 传入Person类, 如果是Student类且学号相等, 判定为同一人
hashCode方法: 根据年龄, 性别和姓名, 生成尽量独一无二的学号
show方法: 打印个人信息
class Worker:
继承自Person类
属性:
成员变量: 工号(wid)
静态变量: count: 用于统计有多少Worker对象
方法:
构造方法: 传入年龄, 性别和姓名, 将对应数据进行修改. 并通过hashCode()生成工号
equals方法: 传入Person类, 如果是Worker类且学号相等, 判定为同一人
hashCode方法: 根据年龄, 性别和姓名, 生成尽量独一无二的工号
show方法: 打印个人信息
class Management:
存储Person及其子类
属性:
自定义
方法:
add方法: 传入Person类, 如果该数据重复 则返回false, 否则将数据存入系统并返回true
delStudent: 传入学生id, 删除对应数据. 如果删除失败返回false 否则返回true
delWorker: 传入工人id, 删除对应数据. 如果删除失败返回false 否则返回true
showStudent: 打印系统中所有的学生数据
showWorker: 打印系统中所有的工人数据
showStat: 打印系统中学生人数, 工人人数
调用样例:
static final boolean MAN = true;
static final boolean WOMAN = false;
public static void main(String[] args) {
    Management mana = new Management();
// add测试
    System.out.println(
            (mana.add(new Student(18, "张三", MAN)) &&
                    mana.add(new Student(19, "李四", WOMAN)) &&
                    mana.add(new Worker(20,"王五", MAN)) &&
                    mana.add(new Worker(21, "赵六", WOMAN)) &&
                    !mana.add(new Worker(21, "赵六", WOMAN))) ? "测试成功" : "测试失败"
    );
//del及hashCode测试
    int tempId = new Worker(21, "赵六", WOMAN).hashCode();
    System.out.println(
            (mana.delStudent(tempId) ||
                    !mana.delWorker(tempId)) ? "测试失败" : "测试成功"
    );
// count测试
    System.gc();
    try { Thread.sleep(1000); } catch (InterruptedException e)
    {e.printStackTrace();}
    System.out.println(
            (Student.count == 2 &&
                    Worker.count == 1 &&
                    Person.count == 3) ? "测试成功": "测试失败"
    );
// 打印
    mana.showStudent();
    mana.showWorker();
    mana.showStat();
}
样例输出:
测试成功
        测试成功
测试成功
系统学生数据:
学号: 213717737 姓名: 张三 年龄: 18 性别: 男
学号: 213650565 姓名: 李四 年龄: 19 性别: 女
系统工人数据:
工号: 1697280996 姓名: 王五 年龄: 20 性别: 男
系统统计数据:
学生人数: 2
工人人数: 1


来源：日常练习题-面向对象
难度：简单*/
package test01;

import java.util.HashMap;
import java.util.Map;

public class test7281 {
    static final boolean MAN = true;
    static final boolean WOMAN = false;
    public static void main(String[] args) {
        Management mana = new Management();
// add测试
        System.out.println(
                (mana.add(new Student(18, "张三", MAN)) &&
                        mana.add(new Student(19, "李四", WOMAN)) &&
                        mana.add(new Worker(20,"王五", MAN)) &&
                        mana.add(new Worker(21, "赵六", WOMAN)) &&
                        !mana.add(new Worker(21, "赵六", WOMAN))) ? "测试成功" : "测试失败"
        );
//del及hashCode测试
        int tempId = new Worker(21, "赵六", WOMAN).hashCode();
        System.out.println(
                (mana.delStudent(tempId) ||
                        !mana.delWorker(tempId)) ? "测试失败" : "测试成功"
        );
// count测试
        System.gc();
        try { Thread.sleep(1000); } catch (InterruptedException e)
        {e.printStackTrace();}
        System.out.println(
                (Student.count == 2 &&
                        Worker.count == 1 &&
                        Person.count == 3) ? "测试成功": "测试失败"
        );
// 打印
        mana.showStudent();
        mana.showWorker();
        mana.showStat();
    }

    /*
    class Person:
    抽象类, 具有人的基本属性和方法
    属性:
    成员变量: 年龄(age), 姓名(name), 性别(sex)
    静态变量: count: 用于统计有多少Person对象
    方法:
    构造方法: 传入年龄, 性别和姓名. 将对应数据进行修改
    抽象方法show; 打印该对象的信息
    */
    public abstract static class Person{
        private int age;
        private String name;
        private Boolean sex;
        static int count = 0;

        public Person(int age, String name, Boolean sex) {
            this.age = age;
            this.name = name;
            this.sex = sex;
        }

        public abstract void show();
    }
/*
    class Worker:
    继承自Person类
    属性:
    成员变量: 工号(wid)
    静态变量: count: 用于统计有多少Worker对象
    方法:
    构造方法: 传入年龄, 性别和姓名, 将对应数据进行修改. 并通过hashCode()生成工号
    equals方法: 传入Person类, 如果是Worker类且学号相等, 判定为同一人
    hashCode方法: 根据年龄, 性别和姓名, 生成尽量独一无二的工号
    show方法: 打印个人信息
*/

    public static class Worker extends Person{
        private int wid;
        static int count = 0;

        public Worker(int age, String name, Boolean sex) {
            super(age, name, sex);
            super.age = age;
            super.name = name;
            super.sex = sex;
            wid = hashCode();
        }

        public boolean equals(Person person){
            if(person instanceof Worker){
                return ((Worker) person).wid == wid;
            }
            return false;
        }

        public int hashCode(){
            wid = super.age + super.name.hashCode() + super.sex.hashCode();
            return wid;
        }

        @Override
        public void show() {
            System.out.println("工号：" + wid +" 姓名: " + super.name + " 年龄: " + super.age + " 性别: " + (super.sex?"男":"女"));
        }
    }
/*
    class Student:
    继承自Person类
    属性:
    成员变量: 学号(sid)
    静态变量: count: 用于统计有多少Student对象
    方法:
    构造方法: 传入年龄, 性别和姓名, 将对应数据进行修改. 并通过hashCode()生成学号
    equals方法: 传入Person类, 如果是Student类且学号相等, 判定为同一人
    hashCode方法: 根据年龄, 性别和姓名, 生成尽量独一无二的学号
    show方法: 打印个人信息
*/

    public static class Student extends Person{
        private int sid;
        static int count = 0;

        public Student(int age, String name, Boolean sex) {
            super(age, name, sex);
            super.age = age;
            super.name = name;
            super.sex = sex;
            sid = hashCode();
        }

        public boolean equals(Person person){
            if(person instanceof Student){
                return ((Student) person).sid == sid;
            }
            return false;
        }

        public int hashCode(){
            sid = super.age + super.name.hashCode() + super.sex.hashCode();
            return sid;
        }

        @Override
        public void show() {
            System.out.println("学号：" + sid +" 姓名: " + super.name + " 年龄: " + super.age + " 性别: " + (super.sex?"男":"女"));
        }
    }

    /*
    class Management:
    存储Person及其子类
    属性:
    自定义
    方法:
    add方法: 传入Person类, 如果该数据重复 则返回false, 否则将数据存入系统并返回true
    delStudent: 传入学生id, 删除对应数据. 如果删除失败返回false 否则返回true
    delWorker: 传入工人id, 删除对应数据. 如果删除失败返回false 否则返回true
    showStudent: 打印系统中所有的学生数据
    showWorker: 打印系统中所有的工人数据
    showStat: 打印系统中学生人数, 工人人数
    */
    public static class Management{
        private final Map<Integer, Student> students = new HashMap<>();
        private final Map<Integer, Worker> workers = new HashMap<>();
        public boolean add(Person person) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (students.containsKey(student.sid)) {
                    return false;
                }
                students.put(student.sid, student);
                Student.count++;
                Person.count++;
                return true;
            } else if (person instanceof Worker) {
                Worker worker = (Worker) person;
                if (workers.containsKey(worker.wid)) {
                    return false;
                }
                workers.put(worker.wid, worker);
                Worker.count++;
                Person.count++;
                return true;
            }
            return false;
        }

        //delStudent: 传入学生id, 删除对应数据. 如果删除失败返回false 否则返回true
        public boolean delStudent(int sid){
            if(students.containsKey(sid)){
                students.remove(sid);
                Student.count--;
                Person.count--;
                return true;
            }
            return false;
        }
        //delWorker: 传入工人id, 删除对应数据. 如果删除失败返回false 否则返回true
        public boolean delWorker(int wid){
            if(workers.containsKey(wid)){
                workers.remove(wid);
                Worker.count--;
                Person.count--;
                return true;
            }
            return false;
        }
        //showStudent: 打印系统中所有的学生数据
        public void showStudent(){
            System.out.println("系统学生数据:");
            for(Student student: students.values()){
                student.show();
            }
        }
        //showWorker: 打印系统中所有的工人数据
        public void showWorker(){
            System.out.println("系统工人数据:");
            for(Worker worker: workers.values()){
                worker.show();
            }
        }
        //showStat: 打印系统中学生人数, 工人人数
        public void showStat(){
            System.out.println("系统统计数据:");
            System.out.println("学生人数: " + Student.count);
            System.out.println("工人人数: " + Worker.count);
        }
    }
}

