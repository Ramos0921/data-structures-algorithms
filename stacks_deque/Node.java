/**
 * Node creates nodes that are used to create a doubly-linked list.
 *
 * @author Eduardo Ramos
 * @version 1.0, 01/19/2021
 */
public class Node<Type> {
  private Type element;
  private Node<Type> next;
  private Node<Type> prev;

  public Node(){
    element = null;
    next = null;
    prev = null;
  }
  public Node(Type num){
    element = num;
    next = null;
    prev = null;
  }

  public void setNext(Node<Type> node){
    next = node;
  }

  public void setPrev(Node<Type> node){
    prev = node;
  }

  public Type getData(){
    return element;
  }

  public void setData(Type num){
    element = num;
  }

  public Node<Type> getNext(){
    return next;
  }

  public Node<Type> getPrev(){
    return prev;
  }
}

