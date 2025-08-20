package test01;

public class MyArrayList<E> implements MyList<E>{
    private Object[] Array = new Object[1];
    private int size;
    /**
     * 获取元素数量
     * @return: 集合中存储的元素数量
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * 判断集合中是否有存储元素
     * @return: 如果有存储元素 返回true 否则返回false
     */
    @Override
    public boolean isEmpty() {
        return size != 0;
    }
    /**
     * 设置指定下标的元素值
     * @param index: 指定下标
     * @param e: 修改后的元素
     * @return: 修改前的元素, 如果下标越界 返回null
     */
    @Override
    public E set(int index, E e) {
        if(index < 0 || index > Array.length){
            return null;
        }
        Object olddata = Array[index];
        Array[index] = e;
        return (E)olddata;
    }
    /**
     * 移除指定元素
     * @param index: 被移除的元素下标
     * @return: 被移除的元素, 如果下标越界 返回null
     */
    @Override
    public E remove(int index) {
        if(index < 0 || index > size){
            return null;
        }
        Object olddata = Array[index];
        for(int i = index; i < size-1; i++){
            Array[i] = Array[i+1];  //所有数值向前移动一位
        }
        Array[--size] = null; //最后空出来的引用应归null回收
        return (E)olddata;
    }
    /**
     * 添加一个元素
     * @param e: 被添加的元素
     * @return: 如果添加成功, 返回true 否则返回false
     */
    @Override
    public boolean add(E e) {
        if(size == Array.length){
            Object[] newArray = new Object[Array.length * 2];
            System.arraycopy(Array, 0, newArray, 0, Array.length);
            Array = newArray;
        }
        int index = size;
        set(index, e);
        size++;
        return set(index, e) != null;
    }
    /**
     * 获取指定下标的元素
     * @param index: 指定元素的下标
     * @return: 指定的元素, 如果index越界 返回null
     */
    @Override
    public E get(int index) {
        if(index < 0 || index > Array.length){
            return null;
        }
        return (E)Array[index];
    }
}
