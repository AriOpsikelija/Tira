package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////
   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      T a;
      T b;
      boolean pass=false;

      while(!pass){
         for(int i=1; i<array.length;i++){
            a=array[i];
            if (a.compareTo(array[i-1])<0){
               b=array[i-1];
               array[i]=b;
               array[i-1]=a;
               break;
            }
            if (i==array.length-1){
               pass=true;
            }
         }
      }
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      T a;
      T b;
      boolean pass=false;

      while(!pass){
         for(int i=fromIndex+1;i<toIndex;i++){
            a=array[i];
            if (a.compareTo(array[i-1])<0){
               b=array[i-1];
               array[i]=b;
               array[i-1]=a;
               break;
            }
            if (i==toIndex-1){
               pass=true;
            }

         }

      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {      
      T a;
      T b;
      boolean pass=false;

      while(!pass){
         for(int i=1; i<array.length;i++){
            a=array[i];
            if (comparator.compare(a,array[i-1])<0){
               b=array[i-1];
               array[i]=b;
               array[i-1]=a;
               break;
            }
            if (i==array.length-1){
               pass=true;
            }
         }
      }
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      T a;
      T b;
      boolean pass=false;

      while(!pass){
         for(int i=fromIndex+1;i<toIndex;i++){
            a=array[i];
            if (comparator.compare(a,array[i-1])<0){
               b=array[i-1];
               array[i]=b;
               array[i-1]=a;
               break;
            }
            if (i==toIndex-1){
               pass=true;
            }

         }

      }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      T a;
      T b;
      int i=0;
      int ii=array.length-1;
      while(i<ii){
         a=array[i];
         b=array[ii];
         array[ii]=a;
         array[i]=b;
         i++;
         ii--;
      }

   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      T a;
      T b;
      int i=fromIndex;
      int ii=toIndex-1;
      while(i<ii){
         a=array[i];
         b=array[ii];
         array[ii]=a;
         array[i]=b;
         i++;
         ii--;
      }
      }


   ///////////////////////////////////////////
   // Recursive binary search bw indices
   ///////////////////////////////////////////

   public enum BSearchImplementation {
      RECURSIVE,
      ITERATIVE
   }

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1);
   }

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, BSearchImplementation impl) {

      if (impl == BSearchImplementation.RECURSIVE) {

         return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1);
      }
      // TODO: IF implementing iterative binary search, call that here.
      return -1;
   }

   public static <T extends Comparable<T>> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      if (fromIndex>toIndex) {
         return -1;
      }
      int mid=fromIndex+(toIndex-fromIndex)/2;
      int x=aValue.compareTo(fromArray[mid]);

      if (x==0) {
         return mid; 
      } else if (x<0) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, mid-1);
      } else {
         return binarySearchRecursive(aValue, fromArray, mid+1, toIndex);
      }
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex, comparator);
   }

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator, BSearchImplementation impl) {
      if (impl == BSearchImplementation.RECURSIVE) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, toIndex - 1, comparator);
      }
      // TODO: IF implementing iterative binary search, call that here.
      return -1;
   }

   public static <T> int binarySearchRecursive(T aValue, T[] fromArray, int fromIndex,
      int toIndex, Comparator<T> comparator) {
      if (fromIndex>toIndex) {
         return -1;
      }
      int mid=fromIndex+(toIndex-fromIndex)/2;
      int x=comparator.compare(aValue, fromArray[mid]);

      if (x==0) {
         return mid; 
      } else if (x<0) {
         return binarySearchRecursive(aValue, fromArray, fromIndex, mid-1, comparator);
      } else {
         return binarySearchRecursive(aValue, fromArray, mid+1, toIndex, comparator);
      }
   }

   public static <T> int binarySearchIterative(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      // TODO: Iterative implementation if grade interests you:
      return -1;
   }

   public enum FastSortAlgorithm {
      QUICKSORT,
      HEAPSORT,
      MERGESORT
   }

   public static <E> void fastSort(E[] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E extends Comparable<E>> void fastSort(E[] array) {
      fastSort(array, 0, array.length, Comparator.naturalOrder(), FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      fastSort(array, fromIndex, toIndex, comparator, FastSortAlgorithm.QUICKSORT);
   }

   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator, FastSortAlgorithm algorithm) {
      switch (algorithm) {
         case QUICKSORT:
            // TODO: Call your quicksort algorithm here.
            break;
         case HEAPSORT:
            // TODO: IF implementing heapsort, call your algorithm here.
            break;
         case MERGESORT:
            // TODO: IF implementing mergesort, call your algorithm here.
            break;
         default:
            break;
      }
   }

} // End of class Algorithms
