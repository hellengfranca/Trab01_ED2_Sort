package Sort;
import Structs.Generics;

public class InsertSort extends Sort{

    public InsertSort(){
        super();
        this.name= "Insert Sort";
    }

    public static void insertSort(Generics<?, ?>[] vector){

        int i, j;
        Generics<?, ?> aux;

        for(i = 1; i < vector.length; i++){
            aux = vector[i];
            j = i-1;
            while(j >= 0 && vector[j].compareTo(aux) > 0){
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j+1] = aux;
        }
    }


}
