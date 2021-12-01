package com.example.datastructurevisualizer;
import java.util.EmptyStackException;

public class LinkedStack<E> implements Cloneable {
    private Node top; // there is an error with type <E> arguments

    public LinkedStack(){
        top = null;
    }
    public boolean isEmpty(){
        return (top == null);
    }
    public void push(E element){
        top = new Node<E> (element, top);
    }
}
