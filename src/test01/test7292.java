package test01;

public class test7292 {
    public static void main(String[] args) {
        MyNode head = new MyNode();
        head.add(head, 5);
        head.add(head,1);
        head.add(head,3);
        head.add(head,2);
        head.add(head,4);
        MyNode temp = head.next;
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }
    }
}

class MyNode{
    MyNode next;
    int data;
    void add(MyNode head, int val){
        // 创建新节点
        MyNode newNode = new MyNode();
        newNode.data = val; //新节点数据域

        // 找到插入位置的前一个节点
        MyNode current = head;//创建一个临时引用变量，指向头节点
        while (current.next != null && current.next.data < val) {
            current = current.next;
        }//遍历

        // 插入新节点
        newNode.next = current.next;
        current.next = newNode;
    }
}
