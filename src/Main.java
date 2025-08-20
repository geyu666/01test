import java.util.ArrayList;
import java.util.Objects;

public class Main {
    static final boolean MAN = true;
    static final boolean WOMAN = false;

    public static void main(String[] args) {
        Management mana = new Management();
        // add测试
        System.out.println(
                (mana.add(new Student(18, "张三", MAN)) &&
                        mana.add(new Student(19, "李四", WOMAN)) &&
                        mana.add(new Worker(20, "王五", MAN)) &&
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                (Student.count == 2 &&
                        Worker.count == 1 &&
                        Person.count == 3) ? "测试成功" : "测试失败"
        );
        // 打印
        mana.showStudent();
        mana.showWorker();
        mana.showStat();
    }
}

//class Person:
//抽象类, 具有人的基本属性和方法
//属性:
//成员变量: 年龄(age), 姓名(name), 性别(sex)
//静态变量: count: 用于统计有多少Person对象
//方法:
//构造方法: 传入年龄, 性别和姓名. 将对应数据进行修改
//        抽象方法show; 打印该对象的信息
abstract class Person {
    private int age;
    private String name;
    private boolean sex;
    public static int count;

    public Person() {
    }

    public Person(int age, String name, boolean sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public abstract void show();
}

//class Student:
//继承自Person类
//属性:
//成员变量: 学号(sid)
//静态变量: count: 用于统计有多少Student对象
//方法:
//构造方法: 传入年龄, 性别和姓名, 将对应数据进行修改. 并通过hashCode()生成学号
//equals方法: 传入Person类, 如果是Student类且学号相等, 判定为同一人
//hashCode方法: 根据年龄, 性别和姓名, 生成尽量独一无二的学号
//show方法: 打印个人信息
class Student extends Person {
    private int sid;
    public static int count;

    public Student() {
    }

    public Student(int age, String name, boolean sex) {
        super(age, name, sex);
        this.sid = hashCode();
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public boolean equals(Person p) {
        if (p instanceof Student) {
            return ((Student) p).getSid() == this.sid;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAge(), this.getSex(), this.getName());
    }

    @Override
    public void show() {
        System.out.println("学号: " + this.getSid() + " 姓名: " + this.getName() + " 年龄: " + this.getAge() + " 性别: " + (this.getSex() ? "男" : "女"));
    }
}

//class Worker:
//继承自Person类
//属性:
//成员变量: 工号(wid)
//静态变量: count: 用于统计有多少Worker对象
//方法:
//构造方法: 传入年龄, 性别和姓名, 将对应数据进行修改. 并通过hashCode()生成工号
//equals方法: 传入Person类, 如果是Worker类且学号相等, 判定为同一人
//hashCode方法: 根据年龄, 性别和姓名, 生成尽量独一无二的工号
//show方法: 打印个人信息
class Worker extends Person {
    private int wid;
    public static int count;

    public Worker() {
    }

    public Worker(int age, String name, boolean sex) {
        super(age, name, sex);
        this.wid = this.hashCode();
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public boolean equals(Person p) {
        if (p instanceof Worker) {
            return ((Worker) p).getWid() == this.wid;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAge(), this.getSex(), this.getName());
    }

    @Override
    public void show() {
        System.out.println("工号: " + this.getWid() + " 姓名: " + this.getName() + " 年龄: " + this.getAge() + " 性别: " + (this.getSex() ? "男" : "女"));
    }
}

//class Management:
//存储Person及其子类
//属性:
//自定义
//方法:
//add方法: 传入Person类, 如果该数据重复 则返回false, 否则将数据存入系统并返回true
//delStudent: 传入学生id, 删除对应数据. 如果删除失败返回false 否则返回true
//delWorker: 传入工人id, 删除对应数据. 如果删除失败返回false 否则返回true
//showStudent: 打印系统中所有的学生数据
//showWorker: 打印系统中所有的工人数据
//showStat: 打印系统中学生人数, 工人人数
class Management {
    private final ArrayList<Student> studentList = new ArrayList<>();
    private final ArrayList<Worker> workerList = new ArrayList<>();

    public boolean add(Person p) {
        if (p instanceof Student) {
            Student s = (Student) p;
            for (Student student : studentList) {
                if (s.getSid() == student.getSid()) return false;
            }
            studentList.add(s);
            ++Student.count;
        } else if (p instanceof Worker) {
            Worker w = (Worker) p;
            for (Worker worker : workerList) {
                if (w.getWid() == worker.getWid()) return false;
            }
            workerList.add(w);
            ++Worker.count;
        } else {
            return false;
        }
        ++Person.count;
        return true;
    }

    public boolean delStudent(int sid) {
        for (int i = 0; i < Student.count; ++i) {
            if (studentList.get(i).getSid() == sid) {
                studentList.remove(i);
                --Student.count;
                --Person.count;
                return true;
            }
        }
        return false;
    }

    public boolean delWorker(int wid) {
        for (int i = 0; i < Worker.count; ++i) {
            if (workerList.get(i).getWid() == wid) {
                workerList.remove(i);
                --Worker.count;
                --Person.count;
                return true;
            }
        }
        return false;
    }

    public void showStudent() {
        System.out.println("系统学生数据:");
        for (Student student : studentList) {
            student.show();
        }
    }

    public void showWorker() {
        System.out.println("系统工人数据:");
        for (Worker worker : workerList) {
            worker.show();
        }
    }

    public void showStat() {
        System.out.println("系统统计数据:");
        System.out.println("学生人数: " + Student.count);
        System.out.println("工人人数: " + Worker.count);
    }
}