package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Sorting {
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> numbers) {
        ArrayList<Integer> sorted = new ArrayList<>(numbers);

        for(int i = 0; i < sorted.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(j) < sorted.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Collections.swap(sorted, i, minIndex);
            }
            System.out.println("Selection Sort Step " + (i+1) + ": " + sorted);
        }
        return sorted;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> numbers) {
        ArrayList<Integer> sorted = new ArrayList<>(numbers);

        for(int i = 0; i < sorted.size()-1; i++) {
            for(int j = 0; j < sorted.size()-i-1; j++) {
                if(sorted.get(j) > sorted.get(j+1)) {
                    Collections.swap(sorted, j, j+1);
                    System.out.println("Bubble Sort Swap: " + sorted);
                }
            }
        }
        return sorted;
    }

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> sorted = new ArrayList<>(numbers);
        for(int i=1;i<sorted.size();i++)
        {
            Integer current=sorted.get(i);
            int j=i-1;
            while(j>=0 && sorted.get(j)>current)
            {
                sorted.set(j+1,sorted.get(j));
                j--;
            }
            sorted.set(j+1,current);
            System.out.println("Pass " + i + ": " + sorted);
        }
        return sorted;
    }
    public static int partition(ArrayList<Integer> sorted,int low,int high)
    {
        Integer pivot=sorted.get(high);
        int i=low-1;
        for(int j=low;j<high;j++)
        {
            if(sorted.get(j)<pivot)
            {
                i++;
                Collections.swap(sorted,i,j);
            }
        }
        Collections.swap(sorted,i+1,high);
        return i+1;
    }
    public static ArrayList<Integer> quickSort(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> sorted=new ArrayList<>(numbers);
        quickSort(sorted,0,sorted.size()-1);
        return sorted;

    }
    public static void quickSort(ArrayList<Integer> sorted,int low,int high)
    {

    if(low<high) {
        int pivot = partition(sorted, low, high);
        System.out.println("Pivot: " + sorted.get(pivot) + " | Array: " + sorted);
        quickSort(sorted, low, pivot - 1);
        quickSort(sorted, pivot + 1, high);
    }
    }


    public static ArrayList<Integer> mergeSort(ArrayList<Integer> numbers)
    {

        ArrayList<Integer> sorted=new ArrayList<>(numbers);
        sorted=mergedSort(sorted,0,sorted.size()-1);
        return sorted;
    }

    public static ArrayList<Integer> mergedSort(ArrayList<Integer> sorted, int low, int high) {
        if (low >= high) {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(sorted.get(low));
            return base;
        }

        int mid = (low + high) / 2;
        ArrayList<Integer> left = mergedSort(sorted, low, mid);
        ArrayList<Integer> right = mergedSort(sorted, mid + 1, high);
        return merge(left, right);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> sorted=new ArrayList<>();
        int i=0,j=0;
        while(i<left.size() && j<right.size()) {
            if (left.get(i) < right.get(j)) {
                sorted.add(left.get(i));
                i++;
            } else {
                sorted.add(right.get(j));
                j++;
            }
        }
            while(i<left.size())
            {
                sorted.add(left.get(i));
                i++;
            }
            while (j<right.size())
            {
                sorted.add(right.get(j));
                j++;
            }

        System.out.println(sorted);
        return sorted;
    }

    public static ArrayList<Integer> heapSort(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> sorted=new ArrayList<>(numbers);
        heapSort(sorted,sorted.size());
        return sorted;

    }

    public static void heapSort(ArrayList<Integer> arr,int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            Collections.swap(arr, 0, i);

            heapify(arr, i, 0);
        }
    }

    static void heapify(ArrayList<Integer> arr, int heapSize, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < heapSize && arr.get(left) > arr.get(largest))
            largest = left;
        if (right < heapSize && arr.get(right) > arr.get(largest))
            largest = right;

        if (largest != root) {
            Collections.swap(arr, root, largest);
            heapify(arr, heapSize, largest);
        }
    }

    public static ArrayList<Integer> radixSort(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> sorted=new ArrayList<>(numbers);
        HashMap<Integer,ArrayList<Integer>> radix=new HashMap<>();
        for(int i=0;i<10;i++)
        {
            radix.put(i,new ArrayList<>());
        }
        Integer maximum=Collections.max(sorted);
        int maxRadix=0;
        while(maximum!=0)
        {
            maximum=maximum/10;
            maxRadix+=1;
        }
        int modular=0;
        while(modular<maxRadix) {
            Integer divisor= (int) Math.pow(10,modular);
            modular+=1;
            for (Integer number : sorted) {
                int tempNumber=number/divisor;
                tempNumber=tempNumber%10;
                radix.get(tempNumber).add(number);
            }
            System.out.println(radix);
            sorted.clear();
            for(int i=0;i<10;i++)
            {
                sorted.addAll(radix.get(i));
                radix.get(i).clear();
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 7, 4, 12, 6, 1, 9, 18, 25);

        System.out.println("\nOriginal list: " + numbers);

        System.out.println("\n=== Selection Sort ===");
        ArrayList<Integer> selectionNumbers = selectionSort(numbers);
        System.out.println("Selection Sort Result: " + selectionNumbers);

        System.out.println("\n=== Bubble Sort ===");
        ArrayList<Integer> bubbleNumbers = bubbleSort(numbers);
        System.out.println("Bubble Sort Result: " + bubbleNumbers);

        System.out.println("\n=== Insertion Sort ===");
        ArrayList<Integer> insertionNumbers = insertionSort(numbers);
        System.out.println("Insertion Sort Result: " + insertionNumbers);

        System.out.println("\n=== Quick Sort ===");
        ArrayList<Integer> quickNumbers = quickSort(numbers);
        System.out.println("Quick Sort Result: " + quickNumbers);

        System.out.println("\n=== Merge Sort ===");
        ArrayList<Integer> mergeNumbers=mergeSort(numbers);
        System.out.println("Merge Sort Result: " +mergeNumbers);

        System.out.println("\n=== Heap Sort ===");
        ArrayList<Integer> heapNumbers=heapSort(numbers);
        System.out.println("Heap Sort Result: " +heapNumbers);

        ArrayList<Integer> newNumbers=new ArrayList<>();
        Collections.addAll(newNumbers,51,896,47,52,1,960,751,45,62);
        System.out.println("\n=== Radix Sort ===");
        ArrayList<Integer> radixNumbers=radixSort(newNumbers);
        System.out.println(radixNumbers);

    }
}