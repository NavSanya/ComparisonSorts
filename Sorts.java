package com.fresnostate;
import java.io.*;
public class Sorts {

    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

    /*****Utility Functions*****/

    //Function used to input an array
    public int[] inputArray(int[] arr, int size) throws IOException
    {
        for(int index=0; index<size; ++index)
        {
            System.out.print("Value on position " + index + ": ");
            arr[index] = Integer.parseInt(br.readLine());
        }//for i loop
        return arr;
    }//inputArray()


    //Function used to display the array provided as argument when called
    public void printArray(int[] arr)
    {
        for(int index=0; index < arr.length; ++index)
        {
            System.out.print(arr[index] + " ");
        }
    }//printArray()


    //Swaps the values at position1 and position2 in the array parameter and returns the edited array
    public int[] swap (int[] arr, int position1, int position2)
    {
        int temporary = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temporary;
        return arr;
    }//swap()











    //Definition of Sorting functions

    /***** ITERATIVE METHODS *****/

    /* Bubble Sort*/
    protected int[] bubbleSort(int[] arr)
    {
        for (int i = 0; i<arr.length; ++i) //length times
        {
            for(int j= arr.length-1; j>=i+1; --j )//length * length times
            {
                if (arr[j]<arr[j-1])
               arr = swap(arr, j, j-1);
            }//for j loop (inner)
        }//for i loop (outer)
        return arr;
    }//bubbleSort()

    /* Another way of doing bubble sort
    for (int i=0; i<arr.length; ++i)
    {
        for(int j=0; j<arr.length; ++j)
        {
            if(a[j] >a[j+1]
            arr = swap (arr, j, j+1)
        }
     }





    /* Selection Sort */





    /* Selection Sort */
    protected int[] selectionSort(int[] arr)
    {
        int smallest,i,j, SmallestPosition;
        // One by one move boundary of unsorted subarray
        for(i=1; i<((arr.length)-1); ++i)
        {
            smallest = arr[i];
            SmallestPosition = i;
            // Find the minimum element in unsorted array
            for (j=i+1; j < arr.length; ++j)
            {
                if (arr[j] < smallest)
                {
                    smallest = arr[j];
                    SmallestPosition = j;
                }//if block
            }//for j loop (inner)
            // Swap the found minimum element with the first element
            arr = swap (arr, i, SmallestPosition);
        }//for i loop (outer)
        return arr;
    }//selectionSort()





    /* Insertion Sort */
    protected int[] insertionSort (int[] arr)
    {
        int j, i, key;
        for (i = 1; i < arr.length; ++i)//length times
        {
            key = arr[i];
            j = i - 1;
            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while(j >= 0 && arr[j] > key) //length - 1 times
            {
                arr[j+1] = arr[j];
                j = j - 1;
            }//while loop (inner)
            arr[j+1] = key;
        }//for loop (outer)
        return arr;
    }//insertionSort()










    /***** DIVIDE AND CONQUER *****/

    /* Merge Sort */

    /*Merges the two subarrays
    - First is from low to mid
    - The second is from mid to high*/
    protected int[] merge (int[] arr, int low, int high, int mid)
    {
        int i,j,k;
        int lengthLeft, lengthRight;
        lengthLeft = mid - low + 1;
        lengthRight = high - mid;

        int[] leftArray = new int[lengthLeft]; //creating 2 arrays to merge
        int[] rightArray = new int[lengthRight];

        //giving the left array its values
        for(i=0; i<lengthLeft;++i)
        {
            leftArray[i] = arr[low+i];
        }//for loop

        //giving the right array its values
        for(i=0; i<lengthRight;++i)
        {
            rightArray[i] = arr[mid+1+i];
        }//for loop

        i = 0;
        j = 0;
        k = low;
        while (i < lengthLeft && j < lengthRight)
        {
            if(leftArray[i] <= rightArray[j])
            {
                arr[k] = leftArray[i];
                i++;
                k++;
            }//if block
            else
            {
                arr[k]=rightArray[j];
                j++;
                k++;
            }//else block
        }//while loop

        while (i<lengthLeft) //for the remaining elements in the left array
        {
            arr[k] = leftArray[i];
            ++i;
            ++k;
        }//while i loop

        while (j<lengthRight)//for the remaining elements in the right array
        {
            arr[k]=rightArray[j];
            ++j;
            ++k;
        }//while j loop

        return arr;
    }//merge()


    //the function that sorts the array from mid to low using the merge function
    protected int[] mergeSort (int[]arr, int high, int low)
    {
        int mid;
        if(low < high)
        {
            mid = (int) (Math.floor((high + low) / 2.0));
            arr= mergeSort(arr, high, (mid+1));//redivide the right half
            arr = mergeSort(arr, mid, low );//redivide the left half
            arr = merge(arr, low, high, mid);//merge the sorted halves
        }//if block
        return arr;
    }//mergeSort()





    /* Quick Sort */

    /* This function takes middle element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    protected int partitionMiddle (int[] arr, int left, int right)
    {
        int x = arr[left];
        int y=arr[(left+right)/2];
        int z = arr[right];
        int pivot = (x < y ? (y < z ? y : x < z ? z : x) : (x > z ? y : x > z ? z : x));

        int i = left - 1;
        int j = right + 1;

        while (true)
        {
            while (arr[++i] < pivot)
            {
                if (i == right)
                    break;
            }// while i loop (inner)
            while (arr[--j] > pivot)
            {
                if (j == left)
                    break;
            }//while j loop (inner)
            if (i >= j) break;
            arr = swap(arr, i, j);
        }// while true loop (outer)
        return j;
    }//partitionMiddle()


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    protected int[] quickSort (int[] arr, int left,int right)
    {
        int mid;
        if (left<right)
        {
            mid = partitionMiddle(arr, left, right);
            arr = quickSort(arr, left, mid); //sorting the left half
            arr = quickSort(arr, (mid+1), right); //sorting the right half
        }//if

        return arr;
    }//quickSort()
}

