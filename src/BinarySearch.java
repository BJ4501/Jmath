import java.util.Arrays;

public class BinarySearch {

    /**
     * 二分查找法
     * 基本思想：在有序表中，取中间记录作为比较对象，若给定值与中间记录的关键字相等，则查找成功；若给定值小于中间记录的关键字，
     * 则在中间记录的左半区继续查找；若给定值大于中间记录的关键字，则在中间记录的右半区继续查找。不断重复，直到查找成功。
     * @param args
     */
    public static void main(String[] args) {
        int []a = {2,3,1,12,11,17,8};
        Arrays.sort(a);
        System.out.println(rank(12,a));
    }
    public static int rank(int key, int []a){
        //数组必须是有序的
        int lo = 0;
        int hi = a.length-1;

        while (lo<hi){
            //被查找的键要么不存在，要么必然存在于a[hi ..lo]之中
            //0 1 2 3 4 5 6 7   0+ (7-0)/2   4+ (7-4)/2
            int mid = lo +(hi - lo)/2;//算中间索引号的小算法

            //补充 差值查找
            //int mid = lo + (hi - lo)*(key - a[lo])/(a[hi]-a[lo]);

            //lo的起始位置改变了，必须把lo移动的位置给加回来

            if(key < a[mid]){
                hi = mid - 1;//向中间值的左端移动
            }else if(key > a[mid]){
                lo = mid + 1;//向中间值的右端移动
            }else {
                return mid;//不进行移动 key就是中间值
            }
        }
        return -1;//没找到
    }

}
