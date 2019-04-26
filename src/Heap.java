import java.util.Arrays;

public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) { //假设堆为大顶堆

        if (count >= n) return;
        ++count;
        a[count] = data; //插入到最后一个位置
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { //堆化，采用从下往上的方法。对于堆来说，i 节点的父节点一定是i/2
            swap(a, i, i / 2);
            i = i/2;
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void removeMax() { //删除一个结点，如果采用从下往上的方法，容易产生数组空洞。可以采用从上往下的方法。
        if (count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a,n,1);
    }

    private void heapify(int[] a, int n, int i) {//从上往下的堆化
        while (true) {
            int maxPOS = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPOS = i*2; //如果父节点小于叶子节点，交换位置
            if (i*2 + 1 <= n && a[maxPOS] < a[i*2 +1]) maxPOS = i*2 + 1; //如果父节点小于叶子节点，交换位置
            if (maxPOS == i) break;
            swap(a,i,maxPOS);
            i = maxPOS;
        }
    }

    private  void buildHeapFromTopTobottom(int[] a, int n) {//从顶向下堆化
        for (int i = 1; i <= n ; i++) {
            insert(a[i]);
        }
    }

    private  void buildHeapFromBottomTobottom(int[] a, int n) {
        for (int i = n/2; i >= 1 ; --i) {
            heapify(a,n,i);
        }
    }

    @Override
    public String toString() {
       int[] temp = Arrays.copyOfRange(a,1,a.length );
        return Arrays.toString(temp);
    }

    public int ElementOfHeap() {
        return a[1];
    }
}
