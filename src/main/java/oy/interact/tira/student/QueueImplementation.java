package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class QueueImplementation<E> implements QueueInterface<E>{
    private Object[] itemArray;
    private static final int DEFAULT_QUEUE_SIZE = 20;
    private int size;
    private int head;
    private int tail;
    
    public QueueImplementation() {
        itemArray = new Object[DEFAULT_QUEUE_SIZE];
        size=0;
        head=0;
        tail=-1;

    }
    public QueueImplementation(int a) {
        itemArray = new Object[a];
        size=0;
        head=0;
        tail=-1;
    }

    @Override
    public int capacity(){
        return itemArray.length;
    }
    


    @Override
    public void enqueue(E element){
        if (element==null){
            throw new NullPointerException();
        }

        if (size==capacity()) {
            Object[] a=new Object[capacity()*2];
            
            for (int i=0; i<capacity(); i++) {
                a[i]=itemArray[(i+head)%capacity()];
            }
            itemArray=a;
            head=0;
            tail=size-1;
        }
        tail=(tail+1)%capacity();
        itemArray[tail]=element;
        size++;
        


    }


    @Override
    public E dequeue(){
        if (size==0) {
            throw new IllegalStateException("asd");
        }
        E element = (E) itemArray[head];
        head=(head+1)%capacity();
        size--;
        return element;
    }

    @Override
    public E element(){
        if (size==0) {
            throw new IllegalStateException("asd");
        }
        return (E) itemArray[head];
    };


    @Override
    public int size(){

        return size;
    }


    @Override
    public boolean isEmpty(){

        return size==0;
    }


    @Override
    public void clear(){
        head=0;
        tail=-1;
        size=0;

        itemArray=new Object[DEFAULT_QUEUE_SIZE];
    }

    public String toString() {
        if (size==0) {
            return "[]";
            //throw new IllegalStateException();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<size; i++) {
            sb.append(itemArray[(head+i)%capacity()]);
            if (i<size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
