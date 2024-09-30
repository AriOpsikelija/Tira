package oy.interact.tira.student;

import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import java.util.function.Predicate;
import oy.interact.tira.util.Pair;
import java.util.Comparator;
import oy.interact.tira.model.Coder;

public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {    
    private class TreeNode {
        K key;
        V value;
        TreeNode left, right;

        TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public V getValue() {
            return value;
        }

    }

    private TreeNode root;
    
	private Comparator<K> comparator;  // The comparator used to determine if new node will go to left or right subtree.

	public BinarySearchTreeContainer(Comparator<K> comparator) {
		this.comparator = comparator;
        root=null;
	}

    @Override
    public void add(K key, V value) {
        root = addRecursive(root, key, value);      
    }
    private TreeNode addRecursive(TreeNode node, K key, V value) {
        if (node == null) {
            return new TreeNode(key, value);
        }
        int cmp = comparator.compare(key,node.key);
        
        if (value==node.value){
            return new TreeNode(key, value);
        }

            
        
        if (cmp < 0) {
            node.left = addRecursive(node.left, key, value);
        } else if (cmp > 0) {
            node.right = addRecursive(node.right, key, value);
        } else {
            int cmp2=((Coder) value).compareTo((Coder) node.value);
            if (cmp2==0){
                node.value = value; 
            }
            if (cmp2<0){
                node.left = addRecursive(node.left, key, value);
            }
            if (cmp2>0){
                node.right = addRecursive(node.right, key, value);
            }
        }
    
        return node;
    }
    

    @Override
    public V get(K key) {
        return getRecursive(root, key);
    }
    
    private V getRecursive(TreeNode node, K key) {
        if (node == null) {
            return null;
        }
    
        int cmp = comparator.compare(key,node.key);
        if (cmp < 0) {
            return getRecursive(node.left, key);
        } else if (cmp > 0) {
            return getRecursive(node.right, key);
        } else {
            return node.value;
        }
    }
    

    @Override
    public void accept(oy.interact.tira.util.Visitor<K,V> visitor) {
        // Empty
    }
    @Override
    public int findIndex(Predicate<V> searcher) {
        return findIndexRec(root,searcher,0);
    }
    private int findIndexRec(TreeNode node, Predicate<V> searcher, int index) {
        if (node == null) {
            return -1; 
        }
    
        if (searcher.test(node.value)) {
            return index+size(node.left);
        }
    
        int leftResult = findIndexRec(node.left, searcher, index);
        if (leftResult != -1) {
            return leftResult;
        }
    
        return findIndexRec(node.right, searcher, size(node.left)+ index + 1);
    }

    @Override
    public Pair<K,V> getIndex(int index){
        return getIndexRec(root,index,new int[]{0});
    }

    private Pair<K, V> getIndexRec(TreeNode node, int index, int[] currentIndex) {
        if (node == null) {
            return null;
        }
    
        Pair<K, V> leftResult = getIndexRec(node.left, index, currentIndex);
        if (leftResult != null) {
            return leftResult;
        }
    
        if (currentIndex[0] == index) {
            return new Pair<>(node.key, node.value);
        }
        currentIndex[0]++;
    
        return getIndexRec(node.right, index, currentIndex);
    }
    @Override
    public int indexOf(K key) {
        return indexOfRec(root, key, 0);
    }

    private int indexOfRec(TreeNode node, K key, int index) {
        if (node == null){
            return -1;
        }

        int left = indexOfRec(node.left, key, index);
        if (left != -1){
            return left;
        }
        if (comparator.compare(node.key,key)==0){
            return index+size(node.left);
        }
        
        return indexOfRec(node.right, key, size(node.left)+index+1);
    }
    

    @Override
    public Pair<K, V>[] toArray() {

        int size = size(); 
        Pair<K, V>[] a = new Pair[size];
        TreeNode node = root;
        StackImplementation stack= new StackImplementation(size);
        int index=0;
  
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            
            node = (TreeNode) stack.pop();
            a[index++] = new Pair<>(node.key, node.value);
            
            node = node.right;
        }
    
    
    
    return a;
    }
    
    @Override 
    public void clear(){
        root = null;
    }
    @Override
    public void ensureCapacity(int a){

    }


    
    @Override
    public int capacity(){



        return 0;
    }
    @Override
    public int size() {
        return size(root);
    }
    
    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    @Override
    public V find(Predicate<V> searcher) {
        return findRec(root,searcher);
    }
    
    private V findRec(TreeNode node, Predicate<V> searcher) {
        if (node == null) {
            return null;
        }
        if (searcher.test(node.value)) {
            return node.value;
        }
        V leftResult = findRec(node.left, searcher);
        if (leftResult != null) {
            return leftResult;
        }
        return findRec(node.right, searcher);
    }

    @Override
    public V remove(K key){
        return null;
    }

}
