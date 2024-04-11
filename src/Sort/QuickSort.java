package Sort;

import Structs.Generics;

public class QuickSort {

    public static void quickSort(Generics<?, ?>[] V, int left, int right){
        if(left < right){
            int p = partition(V, left, right);
        }
    }
    public static int partition(Generics<?, ?>[] V, int left, int right){
        int mid = (left + right)/2;
        Generics<?, ?> mediana;

        // achando a mediana
        if(V[left].compareTo(V[mid]) < 0){
            if( V[mid].compareTo(V[right]) < 0){
                mediana = V[mid];
            }else{
                if(V[left].compareTo(V[right]) < 0){
                    mediana = V[right];
                }else{
                    mediana = V[left];
                }
            }
        }else{
            if(V[right].compareTo(V[mid]) < 0){
                mediana = V[mid];
            }else{
                if(V[right].compareTo(V[left])< 0){
                    mediana = V[right];
                }else{
                    mediana = V[left];
                }
            }
        }
        //colocando a mediana no fim do vetor
        for(int i = V.length; i >= 0 ; i--){
            int j = i;
            if(mediana == V[i]){
                V[V.length] = mediana;
            }
            V[i] = V[j-1];
        }

    }
}
