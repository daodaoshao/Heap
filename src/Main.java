public class Main {

    public static void main(String[] args) {

        Heap heap = new Heap(7);
        heap.insert(1);
        heap.insert(5);
        heap.insert(67);
        heap.insert(32);
        heap.insert(5);
        heap.insert(41);
        heap.insert(18);
        System.out.println(heap.toString());
        heap.removeMax();
        System.out.println(heap.toString());
    }
}
