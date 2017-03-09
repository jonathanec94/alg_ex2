/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.algorithms_ex2;

import java.util.Random;

/**
 *
 * @author Jonathan
 */
public class Controller {
    private int maxInt;
    private int size;
    private int[] list;
    Random ran;
    private int[] helper;
    
    public Controller(int size){
         this.maxInt = 1000;
         this.size = size;
         this.list = new int[size];
         this.ran = new Random();
          
    }
    
    public void addRandomData() {
        for (int i = 0; i < list.length; i++) {
            list[i] = ran.nextInt(maxInt);
        }
    }
    
    void insertionSort() {
        int temp;

        for (int i = 1; i < size; i++) {
            temp = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > temp; j--)
                list[j + 1] = list[j];
            list[j + 1] = temp;
        }
    }

    void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int index = i;
            for (int j = i + 1; j < size; j++)
                if (list[j] < list[index])
                    index = j;

            int smallerNumber = list[index];
            list[index] = list[i];
            list[i] = smallerNumber;
        }
    }

    void realMergeSort() {
        this.helper = new int[size];
        mergesort(0, size - 1);
    }

    void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = list[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                list[k] = helper[i];
                i++;
            } else {
                list[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            list[k] = helper[i];
            k++;
            i++;
        }

    }
    
    
}
