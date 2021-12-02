package com.example.datastructurevisualizer;
import java.util.EmptyStackException;

public class LinkedStack<E> implements Cloneable {
    private Node top; // there is an error with type <E> arguments

    public LinkedStack(){
        top = null;
    }
    public LinkedStack<E> clone(){
        LinkedStack<E> answer;
        try{
            answer = (LinkedStack<E>) super.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException("This class does not implement Cloneable.");
        }
        answer.top = Node.listCopy(top);
        return answer;

    }
    public boolean isEmpty(){
        return (top == null);
    }
    public void push(E element){
        top = new Node<E> (element, top);
    }

    public E peek(){
        if(top == null)
            throw new EmptyStackException();
        return (E) top.getData();
    }

    public E pop(){
        E answer;
        if (top == null)
            throw new EmptyStackException();
        answer = (E) top.getData();
        top = top.getLink();
        return answer;
    }
    public int size(){
        return Node.listLength(top);
    }
}
