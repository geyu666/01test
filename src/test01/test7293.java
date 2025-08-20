package test01;

public class test7293 {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        for(int i = 0; i < 11; i++){
            list.add(i+"");
        }
        System.out.println(list.remove(5));
        System.out.println(list.set(5,"6"));
        System.out.println(list.add("11"));
        for(int i = 0; i < 15; i++){
            System.out.print(list.get(i) + "\t");
        }
    }
}

interface MyList<E>{

    int size();

    boolean isEmpty();

    E set(int index, E e);

    E remove(int index);

    boolean add(E e);

    E get(int index);
}

