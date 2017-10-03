package com.bj.stack;

public class B implements MyStack<Integer>{
    //自己写个栈
    private Integer [] os= new Integer[3];
    private int size = 0;//判断是否进行扩容的标记


    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        for(int i = 0;i < size;i++){
            os[i] = null;//将每个元素写null 可以让GC快速回收
        }
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean push(Integer data) {
        //判断是否进行扩容
        if(size >= os.length){
            resize();//扩容
        }
        //不扩容
        os[size++] = data;
        return true;
    }

    //扩容
    private void resize(){
        Integer [] os1 = new Integer[os.length*3];
        for(int i=0; i<os.length ;i++){
            os1[i] = os[i];
            os[i] = null;//清空原数组
        }
        os = os1;
    }

    @Override
    public Integer pop() {
        Integer temp = os[size-1];
        //释放栈顶元素
        os[--size] = null;
        return temp;
    }

    @Override
    public Integer peek() {
        Integer temp = os[size-1];
        return temp;
    }

    public static void main(String[] args) {
        B b = new B();
        b.push(100);
        b.push(200);
        b.push(300);
        b.push(400);

        System.out.println(b.pop());
        System.out.println(b.pop());
        System.out.println(b.pop());
        System.out.println(b.pop());
    }



}

interface MyStack<T> {
    //判断栈是否为空
    boolean isEmpty();
    //清空栈
    void clear();
    //栈的长度
    int length();
    //数据入栈
    boolean push (T data);
    //数据出栈
    T pop();
    //查看栈顶
    T peek();

}
