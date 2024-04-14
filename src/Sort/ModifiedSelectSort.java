package Sort;

public class ModifiedSelectSort {
    public static <T extends Comparable<T>> void selectionSort(T[] A) {
        //laço que vai percorrer o vetor pelo início e pelo fim.
        for(int i = 0, k = A.length-1; i < (A.length/2); i++, k--) {
            int min = i;
            int max = k; //variaveis min e max assumem que o maior e o menor são os dois itens percorridos atualmente.
            for(int j = i + 1, l = k - 1; l >= i && j <= k ; j++, l--) {
                //Segundo laço que vai encontrar o maior e o menor. Observe que o laço só percorre a parte do vetor que ainda não está ordenada.
                //O laço quebra assim que as variáveis já percorreram toda a parte do vetor que não está ordenada e começa a entrar na parte ordenada.
                if(A[j].compareTo(A[min]) < 0) {
                    min = j;
                }
                if(A[l].compareTo(A[max]) > 0) {
                    max = l;
                }
            }
            //Realiza as devidas trocas salvando os valores.
            T firstValue = A[i];
            T lastValue = A[k];
            T smaller = A[min];
            T larger = A[max];

            A[i] = smaller;
            A[k] = larger;

            if(max == i && i!= (A.length/2)-1){// condicionais para tentar evitar problemas quando min == k ou max == i
                A[min] = lastValue;
            } else if (min == k && i!= (A.length/2)-1) {
                A[max] = firstValue;
            } else{
                A[min] = firstValue;
                A[max] = lastValue;
            }






        }
    }
}
