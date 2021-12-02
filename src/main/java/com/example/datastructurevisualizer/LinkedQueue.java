package com.example.datastructurevisualizer;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Cloneable {
    private int manyNodes;
    private Node<E> front, rear;

    public LinkedQueue (){
        front = null;
        rear = null;
    }

    public void add(E item)
    {
        if (isEmpty( ))
        { // Insert first item.
            front = new Node<E>(item, null);
            rear = front;
        }
        else
        { // Insert an item that is not the first.
            rear.addNodeAfter(item);
            rear = rear.getLink( );
        }
        manyNodes++;
    }
    public LinkedQueue<E> clone( ){
        LinkedQueue<E> answer;
        try {
            answer = (LinkedQueue<E>) super.clone( ); }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException ("This class does not implement Cloneable.");
        }
        Node[ ] cloneInfo;
        cloneInfo =
                Node.listCopyWithTail(front);
        answer.front = cloneInfo[0];
        answer.rear = cloneInfo[1];
        return answer;
    }
    public boolean isEmpty( )
    {
        return (manyNodes == 0);
    }
    public E remove( )
    {
        E answer;
        if (manyNodes == 0)
            throw new NoSuchElementException("Queue underflow.");
            answer = front.getData( ); front = front.getLink( ); manyNodes--;
        if (manyNodes == 0)
            rear = null;
        return answer;
    }
    public int size( )
    {
        return manyNodes;
    }
}
