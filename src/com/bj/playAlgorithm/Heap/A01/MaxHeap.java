package com.bj.playAlgorithm.Heap.A01;

/**
 * 最大堆
 * Created by BJ on 2018/2/13.
 */
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;

    protected int count;

    protected int capacity; //保存用户创建时的数组大小

    //构造函数，构造一个空堆，可以容纳capacity个元素
    public MaxHeap(int capacity){
        data = (Item[]) new Comparable[capacity+1];
        count = 0;
    }

    //返回堆中的元素个数
    public int size(){
        return count;
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item){

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public Item extractMax(){
        assert count > 0;
        Item ret = data[1];

        //将堆底最后一个元素取出，放到堆顶
        swap(1,count);
        //因为取出了一个元素所以数量减少
        count --;
        shiftDown(1);

        return ret;
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    /**
     * shiftUp操作保证这个对仍是最大堆--完全二叉树
     * 最大堆和完全二叉树不完全相同
     * 最大堆父节点需要比子节点大
     * @param k 新插入的元素位置k
     */
    private void shiftUp(int k){

        while ( k > 1 && data[k/2].compareTo(data[k]) < 0){
            //此时子数中的元素比父节点大，需要交换下位置
            swap(k,k/2);
            k = k/2;
        }
    }


    /**
     * shiftDown操作保证这个对仍是最大堆--完全二叉树
     * @param k 更新后的堆顶元素k
     *          需要进行向下调整保证最大堆
     */
    private void shiftDown(int k) {
        //越界检测
        while (2*k <= count){
            int j = 2*k;
            //在此次循环中,data[k] data[j] 交换位置
            // j+1 <= count 检查有没有右child
            if ( j+1 <= count && data[j+1].compareTo(data[j]) > 0){
                j ++;
                //此时 data[j]是k下面两个子节点中最大值
            }

            // 如果k已经比j大或k与j相等，就说明当前的shiftDown操作已经完成
            // 当前的堆已经恢复为最大堆
            if (data[k].compareTo(data[j]) >= 0)
                break;

            //否则就说明仍需交换位置
            swap(k,j);
            //将子节点作为父节点的位置，继续进行检测与调整操作
            k = j;
        }
    }


    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
    }


}
