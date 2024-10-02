
package oy.interact.tira.student;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;
import java.util.function.Predicate;

public class HashTableContainer<K extends Comparable<K>, V> implements TIRAKeyedContainer<K, V> {
    private static final int DEFAULT_STACK_SIZE = 2000000;

    private Pair<K, V>[] table;
    private int size;

    public HashTableContainer(){
        table=new Pair[DEFAULT_STACK_SIZE];
        size=0;
    }

    @Override
    public void add(K key, V value){
        if (key==null||value==null){
            return;
        }

        int index=hash(key);
        while (table[index]!=null&&!table[index].getKey().equals(key)&&!table[index].isRemoved()){
            index=(index+1)%table.length;
        }

        if (table[index]==null||table[index].isRemoved()){
            size++;
        }

        table[index]=new Pair<>(key, value);
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % table.length;
    }

    @Override
    public V get(K key) {
        if (key==null) {
            return null;
        }
    
        int index = hash(key);
        while (table[index]!=null){
            if (table[index].getKey().equals(key)&&!table[index].isRemoved()){
                return table[index].getValue();
            }
            index=(index+1)%table.length; 
        }
    
        return null; 
    }

    @Override
    public int size(){
        return size;
    }
    
    @Override
    public int capacity(){
        return table.length;
    }

    @Override
    public Pair<K, V>[] toArray(){
        Pair<K, V>[] result=new Pair[size];
        int index=0;
    
        for (int i=0; i<table.length; i++){
            if (table[i]!=null&&!table[i].isRemoved()) {
                result[index++]=table[i];
            }
        }
        return result;
    }

    @Override
    public void clear(){
        table=new Pair[DEFAULT_STACK_SIZE];
        size=0;
    }

    @Override
	public V find(Predicate<V> searcher){
        return null;
    }

    @Override
    public V remove(K key){
        return null;
    }

    @Override
    public void ensureCapacity(int capacity){

    }

}