/**
 * This program implments mergeQueues method which
 * merges two listQues together, sorted in accending order.
 * Also this program implmenets a fundamental mergerSort
 * algorithm.
 *
 * Completion time: 4hrs
 *
 * @author Eduardo Ramos, Acuna, Sedgewick and Wayne
 * @verison 1.0, 02/02/2021
 */
import java.util.Random;
public class RamosMerging {

    /**
     * Entry point for sample output.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue q1 = new ListQueue(); q1.enqueue("T"); q1.enqueue("R"); q1.enqueue("O"); q1.enqueue("L"); q1.enqueue("E");
        Queue q2 = new ListQueue(); q2.enqueue("X"); q2.enqueue("S"); q2.enqueue("P"); q2.enqueue("M"); q2.enqueue("E"); q2.enqueue("A");
        Queue q3 = new ListQueue(); q3.enqueue(20); q3.enqueue(17); q3.enqueue(15); q3.enqueue(12); q3.enqueue(5);
        Queue q4 = new ListQueue(); q4.enqueue(18); q4.enqueue(16); q4.enqueue(13); q4.enqueue(12); q4.enqueue(4); q4.enqueue(1);

        //Q1 - sample test cases
        Queue merged1 = mergeQueues(q1, q2);
        System.out.println(merged1.toString());
        Queue merged2 = mergeQueues(q3, q4);
        System.out.println(merged2.toString());

        //Q2 - sample test cases
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
        show(a);

        //Q3 - sample test cases
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        shuffle(b);
        show(b);

        shuffle(b);
        show(b);

        //tests
        System.out.println("****** Test ***********\n");
        int merged1Length = 11;
        System.out.println(merged1.size() == merged1Length);
    }

    public static Queue mergeQueues(Queue<Comparable> q1, Queue<Comparable> q2) {
        //TODO: implement this.
        if(q1.isEmpty() && !q2.isEmpty()) return q2;
        if(q2.isEmpty() && !q1.isEmpty()) return q1;

        Queue temp = new ListQueue();

        while(!q1.isEmpty() || !q2.isEmpty()){

            if(q1.isEmpty() && !q2.isEmpty()){
                temp.enqueue(q2.dequeue());
            }
            if(q2.isEmpty() && !q1.isEmpty()){
                temp.enqueue(q1.dequeue());
            }
            if(!q1.isEmpty() && !q2.isEmpty()){
                if(!less(q1.front(), q2.front())){
                    temp.enqueue(q1.dequeue());
                }else{
                    temp.enqueue(q2.dequeue());
                }
            }
        }
        return temp;
    }

    public static void sort(Comparable[] a) {
        //TODO: implement this.
        Comparable[] temp = mergeSort(a);

        for(int i = 0; i < temp.length; i++){
            a[i] = temp[i];
        }
    }

    public static Comparable[] mergeSort(Comparable[] a){
        if(a.length == 1){
            return a;
        }

        int middle = a.length/2;

        Comparable[] leftArr = new Comparable[middle];
        Comparable[] rightArr = new Comparable[a.length - middle];

        for(int i = 0; i < middle; i++){
            leftArr[i] = a[i];
        }

        for(int j = 0, k = middle; k < a.length; j++, k++){
            rightArr[j] =  a[k];
        }

        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);

        return merge(leftArr,rightArr);
    }

    public static Comparable[] merge(Comparable[] a, Comparable[] b){
        Comparable [] temp = new Comparable[a.length + b.length];

        int tempCount = 0, aCount = 0, bCount = 0;

        while(aCount < a.length || bCount < b.length){
            if(aCount < a.length && bCount < b.length){
                if(((Comparable) a[aCount]).compareTo(b[bCount]) < 0){
                    temp[tempCount] = a[aCount];
                    tempCount++;
                    aCount++;
                }else if(((Comparable) a[aCount]).compareTo(b[bCount]) > 0){
                    temp[tempCount] = b[bCount];
                    tempCount++;
                    bCount++;
                }else{
                    temp[tempCount] = a[aCount];
                    tempCount++;
                    aCount++;

                    temp[tempCount] = b[bCount];
                    tempCount++;
                    bCount++;
                }
            }else if(aCount < a.length && bCount >= b.length){
                temp[tempCount] = a[aCount];
                tempCount++;
                aCount++;
            }else if(aCount>= a.length && bCount < b.length){
                temp[tempCount] = b[bCount];
                tempCount++;
                bCount++;
            }
        }
        return temp;
    }

    public static void shuffle(Object[] a) {
        //TODO: implement this.

        shuffler(a, 0, a.length-1);
    }

    public static void shuffler(Object[] a, int start, int end){
        if(start > end){
            return;
        }

        int middle = (start+end) /2;
        int random = new Random().nextInt(a.length);

        Object temp = a[middle];
        a[middle] = a[random];
        a[random] = temp;

        shuffler(a, start, middle-1);
        shuffler(a, middle+1, end);
    }
    //shuffler runs at nlogn time because I implemented a divide and conquer with a recursive call technique. Very similar to mergeSort
    //my algorithm breaks down the input array to small components. The larger the input the curve will begin to plato.

    //sorting helper from text
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //sorting helper from text
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }

    //sorting helper from text
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;

        return true;
    }
}