package Sort;

public class DoubleHeapSort<T extends Comparable<T>> {
    // Declaração de variáveis globais para utilizar em qualquer função e não precisar ficar passando vetores e tamanhos como parâmetro
    private T[] max_heap;
    private T[] min_heap;
    private int max_tam;
    private int min_tam;

    // Função do DoubleHeapsort
    // Utiliza dois Heaps, um min e um max heap
    // Pega o maior valor, que está no topo do max heap, e coloca ao final do vetor.
    // E o menor valor, que está no topo do min heap, é colocado no primeiro índice do vetor. Da mesma forma com os indíces seguintes
    // Após a troca, diminui o valor de 'tam' para que a referência do último elemento do heap seja trocada para o novo elemento que é o "verdadeiro" ultimo
    // Então é chamada a função maxHeapifica e minHeapifica para o novo valor que está no topo dos dois heaps.
    public void heapsort(T[] A) { //n consegui fazer ser static usando o generics :(
        max_heap = A.clone();
        min_heap = A.clone();
        // vetor global max e min heap recebe copia do vetor passado como parâmetro

        max_tam = max_heap.length - 1;
        min_tam = min_heap.length - 1;
        //ajustando a variável que guarda o tamanho atual dos heaps

        // Chama a função para construir um Max-Heap e um Min-Heap
        constroiHeap();

        // Assim que os heaps foram criados, o processo de ordenação pode começar.
        // Através desse ‘loop’ que a inserção do valor do topo dos heaps no vetor original é feita
        for (int i = max_tam, j = 0; j < A.length; i--, j++) {
            //laço só precisa executar até a quantidade de elementos no array
            A[j] = min_heap[0];
            A[i] = max_heap[0];

            troca(0, max_tam, max_heap);
            troca(0, min_tam, min_heap);
            //ajusta os heaps descartando o valor do topo

            max_tam -= 1;
            min_tam -= 1;
            //ajustando o tamanho para o "novo" último elemento

            maxHeapifica(0);
            minHeapifica(0);
            // é necessário dar um heapify novamente nos heaps já que o topo foi trocado.
        }
    }

    // Função que constrói o Max-Heap e o Min-Heap
    private void constroiHeap() {
        //construção é iniciada no meio do vetor, que é exatamente o último nó que possui pelo menos um filho
        int meio = (min_heap.length - 1) / 2;

        // Para cada elemento que possui pelo menos um filho, chama o maxHeapifica que encontra
        // o maior elemento, se houver, e coloca como pai
        for (int i = meio; i >= 0; i--) {
            maxHeapifica(i);
        }

        // Para cada elemento que possui pelo menos um filho, chama o minHeapifica que encontra
        // o menor elemento, se houver, e coloca como pai
        for (int i = meio; i >= 0; i--) {
            minHeapifica(i);
        }
    }

    // Função para troca
    private void troca(int i, int j, T[] vetor) {
        T aux;

        aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

    // Função maxHeapifica
    // Verifica se há um valor maior que o pai, dentre o filho esquerdo e o filho direito, e troca de lugar se houver
    // Num laço for, transforma qualquer vetor em um max-Heap
    private void maxHeapifica(int pai) {
        int esquerda = 2 * pai + 1; // Pega a posição do filho da esquerda e da direita
        int direita = 2 * pai + 2;
        int maior = pai; // Começa considerando que o maior valor é o pai

        // Se o filho da esquerda está dentro do intervalo verificável do array E
        // Se este filho é maior que o pai, atualiza a variável maior
        if (esquerda <= max_tam && max_heap[esquerda].compareTo(max_heap[maior]) > 0)
            maior = esquerda;

        // Se o filho da direita está dentro do intervalo verificável do array E
        // Se este filho é maior que o pai, atualiza a variável maior
        if (direita <= max_tam && max_heap[direita].compareTo(max_heap[maior]) > 0)
            maior = direita;

        // Se houver um valor maior que pai, faz a troca
        if (maior != pai) {
            troca(pai, maior, max_heap); // Faz a troca de posições
            maxHeapifica(maior); // Chama a função novamente para ajustar o valor recém trocado caso seja necessário
        }
    }


    // Função minHeapifica
    // Mesma coisa da outra só que constrói um min-heap ao invés disso
    private void minHeapifica(int pai) {
        int menor = pai, esquerda = 2 * pai + 1, direita = 2 * pai + 2; // e a do filho da direita.

        if (esquerda <= min_tam && min_heap[esquerda].compareTo(min_heap[menor]) < 0)
            menor = esquerda;

        if (direita <= min_tam && min_heap[direita].compareTo(min_heap[menor]) < 0)
            menor = direita;

        if (menor != pai) {
            troca(pai, menor, min_heap);
            minHeapifica(menor);
        }
    }
}
