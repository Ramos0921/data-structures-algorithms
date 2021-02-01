/**
 * This program is used to benchmark insertion sort and shell sort with
 * binary, half-data, and random int array at different sizes.
 *
 * Completion time: 3hr
 *
 * @author Eduardo Ramos, Acuna, Sedgewick
 * @version 1.0, 02/01/2021
 */

import java.util.Random;

public class RamosNonUniform implements SER222_02_01_HW02_Submission {
    /***************************************************************************
     * START - SORTING UTILITIES, DO NOT MODIFY (FROM SEDGEWICK)               *
     **************************************************************************/

    public static void insertionSort(Comparable[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++)
        {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }


    public static void shellsort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...

        while (h >= 1) {
            // h-sort the array.
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                exch(a, j, j-h);
            }
            h = h/3;
        }
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    /***************************************************************************
     * END - SORTING UTILITIES, DO NOT MODIFY                                  *
     **************************************************************************/

    //TODO: implement interface methods.

    public Integer[] generateTestDataBinary(int size){
        Integer [] temp = new Integer[size];
        int half = size/2;
        for(int i = 0; i < temp.length; i++){
            if(i < half){
                temp[i] = 0;
            }else{
                temp[i] = 1;
            }
        }
        return temp;
    };
    public Integer[] generateTestDataHalfs(int size){
        Integer [] temp = new Integer[size];
        int count = 0;
        int half = size/2;
        for(int i =0; i < temp.length; i++){
            if(i < half){
                temp[i] = count;
            }else{
                half = half + (temp.length - i) /2;
                count++;
                temp[i]=count;
            }
        }
        return temp;
    };
    public Integer[] generateTestDataHalfRandom(int size){
        Integer [] temp = new Integer[size];
        Random random = new Random();
        int half = size/2;
        for(int i = 0; i < temp.length; i++){
            if(i < half){
                temp[i] = 0;
            }else{
                temp[i] = random.nextInt();
            }
        }
        return temp;
    };

    public double computeDoublingFormula(double t1, double t2){
        double calc = t2/t1;
        double b = Math.log(calc);

        return b;
    };
    public double benchmarkInsertionSort(Integer[] small, Integer[] large){
        Stopwatch smallTime = new Stopwatch();
        insertionSort(small);
        double smallTotal = smallTime.elapsedTime();

        Stopwatch largeTime = new Stopwatch();
        insertionSort(large);
        double largeTotal = largeTime.elapsedTime();

        double b = computeDoublingFormula(smallTotal, largeTotal);
        return b;
    };
    public double benchmarkShellsort(Integer[] small, Integer[] large){
        Stopwatch smallTime = new Stopwatch();
        shellsort(small);
        double smallTotal = smallTime.elapsedTime();

        Stopwatch largeTime = new Stopwatch();
        shellsort(large);
        double largeTotal = largeTime.elapsedTime();

        double b = computeDoublingFormula(smallTotal, largeTotal);

        return b;
    };
    public void runBenchmarks(int size){
        int newSize = size * 4;

        //binary benchmarks
        double binaryInsertion = benchmarkInsertionSort(generateTestDataBinary(size), generateTestDataBinary(newSize));
        double binaryShell = benchmarkShellsort(generateTestDataBinary(size), generateTestDataBinary(newSize));

        //Data-half benchmarks
        double halfsInsertion = benchmarkInsertionSort(generateTestDataHalfs(size), generateTestDataHalfs(newSize));
        double halfsShell = benchmarkInsertionSort(generateTestDataHalfs(size), generateTestDataHalfs(newSize));

        //Data-randoms benchmarks
        double randomsInsertion = benchmarkInsertionSort(generateTestDataHalfRandom(size), generateTestDataHalfRandom(newSize));
        double randomsShell = benchmarkInsertionSort(generateTestDataHalfRandom(size), generateTestDataHalfRandom(newSize));

        System.out.println("          Insertion         Shellsort");
        System.out.println("Bin:       "+String.format("%.2f",binaryInsertion)+"            "+String.format("%.2f",binaryShell));
        System.out.println("Half:      "+String.format("%.2f",halfsInsertion)+"         "+String.format("%.2f",halfsShell));
        System.out.println("RanInt:    "+String.format("%.2f",randomsInsertion)+"             "+String.format("%.2f",randomsShell));

    };

    public static void main(String args[]) {

        SER222_02_01_HW02_Submission me = new RamosNonUniform();
        int size = 8000;

        //int test = 8;
        // me.generateTestDataBinary(test);
        // me.generateTestDataHalfs(test);
        // me.generateTestDataHalfRandom(test);


        //NOTE: feel free to change size here. all other code must go in the
        //      methods.

        me.runBenchmarks(size);
    }
}