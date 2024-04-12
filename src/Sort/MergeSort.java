package Sort;

import Structs.Generics;

public class MergeSort extends InsertSort {

    public static void main(String[] args) {
        Generics<Integer, Integer>[] vetor = new Generics[] {
                new Generics<>(1, 1),
                new Generics<>(2, 2),
                new Generics<>(3, 3),
                new Generics<>(4, 4),
                new Generics<>(5, 5),
                new Generics<>(6, 6),
                new Generics<>(7, 7),
                new Generics<>(8, 8),
                new Generics<>(9, 9),
                new Generics<>(10, 10),
                new Generics<>(11, 11),
                new Generics<>(12, 12),
                new Generics<>(13, 13),
                new Generics<>(14, 14),
                new Generics<>(15, 15),
                new Generics<>(16, 16),
                new Generics<>(17, 17),
                new Generics<>(18, 18),
                new Generics<>(19, 19),
                new Generics<>(20, 20)
        };
        for (Generics<Integer, Integer> gen : vetor) {
            System.out.println(gen);
        }
        mergeSort(vetor);
        System.out.println(" ");
        for (Generics<Integer, Integer> gen : vetor) {
            System.out.println(gen);
        }
    }

    public MergeSort(){
        super();
        this.name = "Merge Sort";
    }

    public static Generics<?, ?>[] mergeSort(Generics<?, ?>[] V){
        Generics<?, ?>[] T = new Generics<?, ?>[V.length];

        return MergeMain(V, T,0,V.length-1);
    }

    public static Generics<?, ?>[] MergeMain(Generics<?, ?>[] V, Generics<?, ?>[] T, int left, int right){

        int mid;

        if(left < right){
            mid = (left + right)/2;
            if(mid <= 5){
                insertSort(V);
                return V;
            }
            else {
                MergeMain(V, T, left, mid);
                MergeMain(V, T, mid + 1, right);
                if(V[mid].compareTo(V[mid+1]) > 0) {
                    Merge(V, T, left, mid + 1, right);
                }
            }
        }
        return V;
    }

    public static void Merge(Generics<?, ?>[] V, Generics<?, ?>[] T, int left, int right, int right_end){
        int left_end = right_end - 1;
        int T_pos = left;
        int numElem = right_end - left + 1; // pos do fim - pos comeco + 1

        while(left <= left_end && right <= right_end){
            //if(V[left] <= V[right])
            if(V[left].compareTo(V[right]) <= 0){ // <= significa q Vleft eh menor
                T[T_pos++] = V[left++]; // se o elemento da esq for menor do q o da direita, o da esquerda "desce"
            } else {
                T[T_pos++] = V[right++];
            }
        }
        // pra quando um dos subvetores chegar no "fim" assume-se logo que os restantes ja estao
        // ordenados, logo adicionamos eles
        while(left <= left_end){
            T[T_pos++] = V[left++];
        }
        while (right <= right_end){
            T[T_pos++] = V[right++];
        }

        for(int i = 0; i<numElem; i++, right_end--){
            V[right_end] = T[right_end];
        }
    }
}
