package Sort;

import Structs.Generics;

public class BubbleSort extends Sort{

    public BubbleSort(){
        super();
        this.name = "Bubble Sort";
    }
    public static void bubbleSort(Generics<?, ?>[] V, int left, int right){
        int i = left;
        int j = right;
        if(left < right){
            for(i = left; i < right; i++){
                for(j = 0; j < right - 1 - (i - left); j++){ // i foi subtraido para ignorar a parte ja ordeanda
                    if(V[j].compareTo(V[j+1]) > 0){
                        Generics<?, ?> aux = V[j];
                        V[j] = V[j+1];
                        V[j+1] = aux;
                    }
                }
            }
        }
    }
}
