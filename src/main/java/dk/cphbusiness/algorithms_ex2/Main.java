/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithms_ex2;

/**
 *
 * @author Jonathan
 */
public class Main {

   static long start, end, finalTime;
   static double result;
    static Controller c;

    private static void insertionSort(int size, int runTimes) {
        c = new Controller(size);
      
        for (int i = 0; i < runTimes; i++) {
            c.addRandomData();
            start = System.currentTimeMillis();
            c.insertionSort();
            end = System.currentTimeMillis();
            finalTime += (end - start);
        }
        
        result = finalTime/runTimes;
        System.out.println("Insertion Sort: "+size+" // result : "+result +" ms");

    }
        private static void selectionSort(int size, int runTimes) {
        c = new Controller(size);
      finalTime = 0;
        for (int i = 0; i < runTimes; i++) {
            c.addRandomData();
            start = System.currentTimeMillis();
            c.selectionSort();
            end = System.currentTimeMillis();
            finalTime += (end - start);
        }
        
        result = finalTime/runTimes;
        System.out.println("Selection Sort: "+size+" // result : "+result +" ms");

    }
           private static void mergeSort(int size, int runTimes) {
        c = new Controller(size);
      finalTime = 0;
        for (int i = 0; i < runTimes; i++) {
            c.addRandomData();
            start = System.currentTimeMillis();
            c.realMergeSort();
            end = System.currentTimeMillis();
            finalTime += (end - start);
        }
        
        result = finalTime/runTimes;
        System.out.println("Merge Sort: "+size+" // result : "+result +" ms");

    }

    public static void main(String[] args) {
       insertionSort(1000,200);
       insertionSort(2000,200);
       insertionSort(4000,200);
       insertionSort(8000,200);

       selectionSort(1000,200);
       selectionSort(2000,200);
       selectionSort(4000,200);
       selectionSort(8000,200);
       
       mergeSort(1000,200);
       mergeSort(2000,200);
       mergeSort(4000,200);
       mergeSort(8000,200);
    }
}
