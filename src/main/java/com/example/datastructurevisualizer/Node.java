package com.example.datastructurevisualizer;

public class Node<E> {
    private E data;
    private Node link;
    public Node(E initialData,Node initialLink){
        data = initialData;
        link = initialLink;
    }
    public void addNodeAfter(E element){
        link = new Node(element, link);
    }

    public E getData() {return data;}

    public void setData(E newData){data = newData;}

    public Node getLink(){return link;}

    public void setLink(Node newLink){link = newLink;}

    public static Node listCopy(Node source){
        Node copyHead;
        Node copyTail;
        if(source == null)
            return null;
        copyHead = new Node(source.data, null);
        copyTail = copyHead;
        while(source.link != null){
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
        return copyHead;
    }

    public static Node[] listCopyWithTail(Node source){
        Node copyHead, copyTail;
        Node[] answer = new Node[2];
        if (source.link == null)
            return answer;
        copyHead = new Node(source.data, null);
        copyTail = copyHead;
        while(source.link != null){
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
        answer[0]  = copyHead;
        answer[1]= copyTail;
        return answer;
    }

    public static Node[] listPart(Node start, Node end){
        Node copyHead, copyTail;
        Node[] answer = new Node[2];
        if (start == null )
            throw new IllegalArgumentException("Start is null");
        if (end == null)
            throw new IllegalArgumentException("End is null");
        copyHead = new Node(start.data, null);
        copyTail = copyHead;
        while (start != end){
            start = start.link;
            if (start == null)
                throw new IllegalArgumentException("End node was not found in the list");
            copyTail.addNodeAfter(start.data);
            copyTail = copyTail.link;
        }
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }

    public static int listLength(Node head){
        Node cursor;
        int answer = 0;
        for(cursor = head; cursor != null; cursor = cursor.link)
            answer++;
        return answer;
    }

    public static Node listPosition(Node head, int position){
        Node cursor;
        if (position <= 0)
            throw new IllegalArgumentException("Position is not positive");
        cursor =head;
        for(int i = 1; (i < position) && (cursor != null); i++)
            cursor =cursor.link;
        return cursor;
    }

    /*public static Node listSearch(Node head, int target){
        for(Node cursor = head; cursor != null; cursor = cursor.link){
            if (cursor.data == target)
                return cursor;
        }
        return null;
    }*/

    public void removeNodeAfter(){
        link = link.link;
    }
}
