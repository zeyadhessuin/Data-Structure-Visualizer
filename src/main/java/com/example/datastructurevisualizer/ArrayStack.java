package com.example.datastructurevisualizer;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Cloneable{
    private Object[] data;
    private int manyItems;

    public ArrayStack(){
        final int INITIAL_CAPACITY = 10;
        data = new Object[INITIAL_CAPACITY];
        manyItems = 0;
    }
    public ArrayStack(int initialCapacity){
        if (initialCapacity < 0)
            throw new IllegalArgumentException("initialCapacity is too small " + initialCapacity);
        data = new Object   [initialCapacity];
        manyItems = 0;
    }
    public boolean isEmpty(){
        return (manyItems == 0);
    }
    public int getCapacity(){
        return data.length;
    }
    public int size(){
        return manyItems;
    }
    public void ensureCapacity(int minimumCapacity){
        Object[] biggerArray;
        if (data.length < minimumCapacity){
            biggerArray = new Object[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayStack<E> clone(){
        ArrayStack<E> answer;
        try{
            answer = (ArrayStack<E>) super.clone();
        } catch (CloneNotSupportedException e){
            throw new RuntimeException("This class does not implement Cloneable");
        }
        answer.data = data.clone();
        return answer;
    }

    @SuppressWarnings("unchecked")
    public E peek(){
        if (manyItems == 0)
            throw new EmptyStackException();
        return (E) data[manyItems-1];
    }
    @SuppressWarnings("unchecked")
    public E pop(){
        E answer;
        if (manyItems == 0)
            throw new EmptyStackException();
        answer = (E) data[--manyItems];
        data[manyItems] = null;
        return answer;
    }
    public void push(E element){
        if (data.length == manyItems)
            ensureCapacity(manyItems * 2+ 1);
        data[manyItems++] = element;
    }
    public void trimToSize(){
        Object[] trimArray;
        if (manyItems != data.length){
            trimArray = new Object[manyItems];
            System.arraycopy(data, 0, trimArray, 0 ,manyItems);
            data = trimArray;
        }
    }
}
