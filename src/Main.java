import Sort.ModifiedSelectSort;

public class Main {
    public static void main(String[] args) {
        Integer[] V = {3, 2, 5, 7, 3, 2, 1, 8, 7, 6, 4, 3, 3};
        ModifiedSelectSort selectSort = new ModifiedSelectSort();

        selectSort.selectionSort(V);
        for (Integer integer : V) {
            System.out.println(integer);
        }
    }
}