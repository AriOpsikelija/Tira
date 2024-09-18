package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {
    private Object[] itemArray;
    private static final int DEFAULT_STACK_SIZE = 20;
    private int size;
    public StackImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        size=0;
    }

    public StackImplementation(int a) {
        itemArray = new Object[a];
        size=0;
    }



    @Override
    public int capacity() {
        return itemArray.length;
    }

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        if (element==null) {
            throw new NullPointerException();
        }
        if (capacity()==size()) {
            Object[] a=new Object[capacity()*2];
            for (int i=0; i<size(); i++) {
                a[i]=itemArray[i];
            }
            itemArray=a;
        }
        itemArray[size()]=element;
        size++;
    }

    @Override
    public E pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        E element=(E) itemArray[size()-1];

        itemArray[size()-1]=null;
        size--;
        return element;
    }

    @Override
    public E peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return (E) itemArray[size()-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void clear() {
        size=0;
        itemArray=new Object[DEFAULT_STACK_SIZE];
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i=0; i<size(); i++) {
            sb.append(itemArray[i]);
            if (i<size()-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}    



