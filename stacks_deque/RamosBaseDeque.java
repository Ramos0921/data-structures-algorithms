/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 *
 * @author Eduardo Ramos, Acuna
 * @version 1.0, 01/19/2021
 */
import java.util.NoSuchElementException;

//TODO: implement.
public class RamosBaseDeque<Item> implements Deque<Item> {
    private int size;
    private Node<Item> head;
    private Node<Item> tail;

    public RamosBaseDeque(){
        size = 0;
        head = null;
        tail = null;
    }

    public void enqueueFront(Item element){
        Node<Item> newNode = new Node<Item>(element);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    };

    public void enqueueBack(Item element){
        Node<Item> newNode = new Node<Item>(element);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    };
    public Item dequeueFront() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("Deque is empty!");
        }else{
            Item currentHeadValue = head.getData();
            if(size == 1){
                tail = null;
                head = null;
                size--;
                return currentHeadValue;
            }
            head = head.getNext();
            head.setPrev(null);
            size--;
            return currentHeadValue;
        }
    };

    public Item dequeueBack() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("Deque is empty!");
        }else{
            Item currentTailValue = tail.getData();
            if(size == 1){
                tail = null;
                head = null;
                size--;
                return currentTailValue;
            }
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
            return currentTailValue;
        }
    };

    public Item first() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("Deque is empty!");
        }else{
            Item currentHeadValue = head.getData();
            return currentHeadValue;
        }
    };

    public Item last() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("Deque is empty!");
        }else{
            Item currentTailValue = tail.getData();
            return currentTailValue;
        }
    };

    public boolean isEmpty(){
        if(size == 0 && head == null && tail == null){
            return true;
        }
        return false;
    };

    public int size(){
        return size;
    };

    @Override
    public String toString(){
        if(isEmpty()){
            return "empty";
        }else{
            String result = "";
            Node<Item> temp = tail;
            while(temp != null){
                result += temp.getData()+" ";
                temp = temp.getPrev();
            }
            return result;
        }
    };
    /**
     * Program entry point for deque.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        RamosBaseDeque<Integer> deque = new RamosBaseDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        //deque features
        System.out.println(deque.dequeueFront());
        deque.enqueueFront(1);
        deque.enqueueFront(11);
        deque.enqueueFront(3);
        deque.enqueueFront(5);
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());
        System.out.println(deque.last());
        deque.dequeueFront();
        deque.dequeueFront();
        System.out.println(deque.first());
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        //extra tests
        RamosBaseDeque<Integer> test = new RamosBaseDeque<>();
        test.enqueueBack(10);
        //should print 10
        System.out.println(test.last());
        System.out.println(test.first());
        test.dequeueBack();
        //should print 0
        System.out.println(test.size());
        test.enqueueFront(9);
        //should print 9
        System.out.println(test.last());
        System.out.println(test.first());
        test.dequeueFront();
        //should print 0
        System.out.println(test.size());

    }
}
