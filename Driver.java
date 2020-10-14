package com.fresnostate;

import java.io.*;

public class Driver extends Sorts
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Sorts objectSorts = new Sorts();
        System.out.println("Size of array");
        int sizeArray = Integer.parseInt(br.readLine());
        int[] originalArray = new int[sizeArray];
        originalArray=objectSorts.inputArray(originalArray, sizeArray);
        System.out.println("\n\n**Original Array**");
        objectSorts.printArray(originalArray);

        //bubble sort call
        int[] bubbleArray = new int[sizeArray];
        bubbleArray = objectSorts.bubbleSort(originalArray);
        System.out.println("\n\n**Bubble Sort**");
        objectSorts.printArray(bubbleArray);

        //selection sort call
        int[] selectionArray = new int[sizeArray];
        selectionArray = objectSorts.selectionSort(originalArray);
        System.out.println("\n\n**Selection Sort**");
        objectSorts.printArray(selectionArray);

        //insertion sort call
        int[] insertionArray = new int[sizeArray];
        insertionArray = objectSorts.insertionSort(originalArray);
        System.out.println("\n\n**Insertion Sort**");
        objectSorts.printArray(insertionArray);


        //merge sort call
        int[] mergeArray = new int[sizeArray];
        mergeArray = objectSorts.mergeSort(originalArray, (sizeArray-1), 0);
        System.out.println("\n\n**Merge Sort**");
        objectSorts.printArray(mergeArray);

        //Quick sort Call
        int[] QuickArray = new int[sizeArray];
        QuickArray = objectSorts.quickSort(originalArray, 0, (sizeArray-1));
        System.out.println("\n\n**Quick Sort**");
        objectSorts.printArray(QuickArray);
    }

}
