/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise13;

/**
 *
 * @author Nils Kimman s1007368
 * @author ole ten Hove s1007616
 */
public class MergeSortTest implements Runnable {

    private static int[] array;

    public static void main(String[] args) {
        array = new int[10000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        mergeSort();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i % 100 == 0)
                System.out.println("");
        }
    }

    public MergeSortTest(int[] array) {
        this.array = array;
    }

    public static void mergeSort() {
        MergeSort.sort(array);
    }

    @Override
    public void run() {
        mergeSort();
    }
}
