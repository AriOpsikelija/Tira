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
      for (int i=1; i<array.length; i++){
         T a=array[i];
         int j=i-1;
         while (j>=0&&array[j].compareTo(a)>0) {
             array[j+1]=array[j];
             j--;
         }
         array[j+1]=a;
     }
   }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      for (int i = fromIndex; i < toIndex; i++) {
         T a=array[i];
         int j=i;
         while (j>fromIndex&&array[j-1].compareTo(a)>0) {
             array[j]=array[j-1];
             j--;
         }
         array[j]=a;
     }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {      
      for (int i=1; i<array.length; i++) {
         T a=array[i];
         int j=i;
         while(j>0&&comparator.compare(array[j-1],a)>0) {
             array[j]=array[j-1];
             j--;
         }
         array[j]=a;
     }
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for (int i=fromIndex; i<toIndex; i++) {
         T a=array[i];
         int j=i;
         while(j>fromIndex&&comparator.compare(array[j-1],a)>0) {
             array[j]=array[j-1];
             j--;
         }
         array[j]=a;
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

   public static <E> void swap(E[] arr, int i, int j){
      E temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }
   public static <E> int partition(E[] arr, int low, int high, Comparator<E> comparator){
       E pivot = arr[high];
       int i = (low - 1);
       for (int j=low; j<=high-1; j++) {
           if (comparator.compare(arr[j], pivot)<=0){
               i++;
               swap(arr, i, j);
           }
       }
       swap(arr, i+1, high);
       return (i+1);
   }
   public static <E> void quicksort(E[] arr, int low, int high, Comparator<E> comparator){
      if (low<high) {
         int pi = partition(arr, low, high, comparator);
         quicksort(arr, low, pi-1, comparator);
         quicksort(arr, pi+1, high, comparator);
      }
   }
   public static <E> void fastSort(E[] array, int fromIndex, int toIndex, Comparator<E> comparator, FastSortAlgorithm algorithm) {
      switch (algorithm) {
         case QUICKSORT:
            quicksort(array, fromIndex, toIndex-1, comparator);
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
