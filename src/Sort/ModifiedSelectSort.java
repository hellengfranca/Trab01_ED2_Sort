package Sort;

public class ModifiedSelectSort {
    public static <T extends Comparable<T>> void selectionSort(T[] A) {
        //laço que vai percorrer o vetor pelo início e pelo fim.
        for(int i = 0, k = A.length-1; i < A.length/2; i++, k--) {
            int min = i;
            int max = k; //variaveis min e max assumem que o maior e o menor são os dois itens que estão sendo percorridos atualmente.
            for(int j = i + 1, l = k - 1; j < A.length; j++, l--) {
                //Segundo laço que vai encontrar o maior e o menor. É importante que uma variável comece do inicio e a outra
                // do final, pois caso as duas comecem do início, a variável que guarda o maior elemento vai pegar elementos
                // que ja foram ordenados
                if(A[j].compareTo(A[min]) < 0) {
                    min = j;
                }
                if(A[l].compareTo(A[max]) > 0) {
                    max = l;
                }
            }
            //Realiza as devidas trocas salvando primeiro o maior e o menor.
            T temp1 = A[min];
            T temp2 = A[max];
            //em seguida move o item que ta sendo percorrido atualmente para a posição do maior e do menor
            A[min] = A[i];
            A[max] = A[k];
            //Coloca o maior e o menor no devido lugar
            A[i] = temp1;
            A[k] = temp2;
        }
    }
}
