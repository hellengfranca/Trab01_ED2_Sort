package Sort;

public class ModifiedSelectSort {
    public <T extends Comparable<T>> void selectionSort(T[] A) {
        for(int i = 0, k = A.length-1; i < A.length/2; i++, k--) {
            int min = i;
            int max = k;
            for(int j = i + 1, l = k - 1; j < A.length; j++, l--) {
                if(A[j].compareTo(A[min]) < 0) {
                    min = j;
                }
                if(A[l].compareTo(A[max]) > 0) {
                    max = l;
                }
            }
            T temp1 = A[min];
            T temp2 = A[max];
            A[min] = A[i];
            A[max] = A[k];
            A[i] = temp1;
            A[k] = temp2;
        }
    }
}
