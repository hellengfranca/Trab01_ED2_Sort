package Sort;

import Structs.Generics;

import java.util.Random;

public class QuickSort extends BubbleSort{
    public static Generics<?, ?>[] vectorGenerator( int size ){
        Generics<?, ?>[] vector = new Generics<?, ?>[size];

        Random random = new Random();

        for ( int i = 0; i < vector.length; i++ ){
            vector[i] = new Generics<Integer, Integer>( random.nextInt(), random.nextInt());
        }

        return vector;
    }
    public static void main(String[] args) {
//        Generics<Integer, Integer>[] vetor = new Generics[] {
//                new Generics<>(0, 21),
//        new Generics<>(1, 12),
//        new Generics<>(2, 5),
//        new Generics<>(3, 19),
//        new Generics<>(4, 15),
//        new Generics<>(5, 6),
//        new Generics<>(6, 11),
//        new Generics<>(7, 7),
//        new Generics<>(8, 13),
//        new Generics<>(9, 1),
//        new Generics<>(10, 16),
//        new Generics<>(11, 24),
//        new Generics<>(12, 3),
//        new Generics<>(13, 8),
//        new Generics<>(14, 22),
//        new Generics<>(15, 4),
//        new Generics<>(16, 17),
//        new Generics<>(17, 10),
//        new Generics<>(18, 2),
//        new Generics<>(19, 20),
//        new Generics<>(20, 9),
//        new Generics<>(21, 23),
//        new Generics<>(22, 18),
//        new Generics<>(23, 14),
//        new Generics<>(24, 25),
//        new Generics<>(25, 26),
//        new Generics<>(26, 27),
//        new Generics<>(27, 28),
//        new Generics<>(28, 29),
//        new Generics<>(29, 30),
//        new Generics<>(30, 31),
//        new Generics<>(31, 32),
//        new Generics<>(32, 33),
//        new Generics<>(33, 34),
//        new Generics<>(34, 35),
//        new Generics<>(35, 36),
//        new Generics<>(36, 37),
//        new Generics<>(37, 38),
//        new Generics<>(38, 39),
//        new Generics<>(39, 40),
//        new Generics<>(40, 41),
//        new Generics<>(41, 42),
//        new Generics<>(42, 43),
//        new Generics<>(43, 44),
//        new Generics<>(44, 45),
//        new Generics<>(45, 46),
//        new Generics<>(46, 47),
//        new Generics<>(47, 48),
//        new Generics<>(48, 49),
//        new Generics<>(49, 50)
//        };
        Generics<?, ?>[] vetor = vectorGenerator(10);

        for (Generics<?, ?> gen : vetor) {
            System.out.println(gen);
        }

        quickSort(vetor, 0, vetor.length-1,5);

        System.out.println(" ");

        for (Generics<?, ?> gen : vetor) {
            System.out.println(gen);
        }

        System.out.println("nanotime: ");
        System.out.println(System.nanoTime());
        System.out.println("miliseconds: ");
        System.out.println(System.currentTimeMillis());
    }
    public QuickSort(){
        super();
        this.name = "Quick Sort";
    }

    public static void quickSort(Generics<?, ?>[] V, int left, int right, int L){
        if(left < right){
            if(right - left <= L){ // verificar se o tamanho do vetor é igual ou menor que o limite
                bubbleSort(V, left, right + 1);
            } else {
                int posPivo = partition(V, left, right);
                quickSort(V, left, posPivo - 1, L);
                quickSort(V, posPivo + 1, right, L);
            }
        }
    }
    public static int partition(Generics<?, ?>[] V, int left, int right){
        int mid = (left + right)/ 2;

        Generics<?, ?> mediana = medianaDeTres(V, left, mid, right);

        // Colocando a mediana no começo do vetor
        for (int i = left; i < right; i++) {
            if (V[i].compareTo(mediana) == 0) {
                Generics<?, ?> temp = V[left];
                V[left] = V[i];
                V[i] = temp;
                break; // Apenas a primeira ocorrência
            }
        }

        // Iniciando o quickSort
        Generics<?, ?> pivo = V[left];
        int i = left+1, j = right;
        while(i <= j){
            if(V[i].compareTo(pivo)<=0){
                i++;
            } else if(pivo.compareTo(V[j]) < 0){
                j--;
            } else {
                swap(V, i, j);
                i++;
                j--;
            }
        }
        V[left] = V[j];
        V[j] = pivo;
        return j;

    }
    protected static void swap(Generics<?, ?>[] V,int i, int j){
        Generics<?, ?> swap = V[i];
        V[i] = V[j];
        V[j] = swap;
    }
    protected static Generics<?, ?> medianaDeTres(Generics<?, ?>[] V, int left, int mid, int right){
        // Verificando se há menos de três elementos
        if (left == right) {  // Apenas um elemento
            return V[left];
        } else if (mid == right) {  // Dois elementos
            if (V[left].compareTo(V[right]) > 0) {
                return V[right];
            } else {
                return V[left];
            }
        }
        // Três elementos
        if (V[left].compareTo(V[mid]) > 0) {
            if (V[mid].compareTo(V[right]) > 0) {
                return V[mid];
            } else if (V[left].compareTo(V[right]) > 0) {
                return V[right];
            } else {
                return V[left];
            }
        } else {
            if (V[left].compareTo(V[right]) > 0) {
                return V[left];
            } else if (V[mid].compareTo(V[right]) > 0) {
                return V[right];
            } else {
                return V[mid];
            }
        }
    }
}
