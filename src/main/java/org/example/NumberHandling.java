package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class NumberHandling {

    public static ArrayList<Integer> getUniqueNumbers(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> uniqueNumbers=new ArrayList<>();
        Set<Integer> duplicateNumbers= new HashSet<>();
        for(Integer number:numbers)
        {
            if(uniqueNumbers.contains(number))
            {
                duplicateNumbers.add(number);
            }
            else {
                uniqueNumbers.add(number);
            }
        }
        for(Integer number:duplicateNumbers)
        {
            uniqueNumbers.remove(number);
        }
        return uniqueNumbers;
    }
    public static ArrayList<Integer> getDuplicateNumbers(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> uniqueNumbers=new ArrayList<>();
        Set<Integer> duplicateNumbers= new HashSet<>();
        for(Integer number:numbers)
        {
            if(uniqueNumbers.contains(number))
            {
                duplicateNumbers.add(number);
            }
            else {
                uniqueNumbers.add(number);
            }
        }
        for(Integer number:duplicateNumbers)
        {
            uniqueNumbers.remove(number);
        }
        return new ArrayList<>(duplicateNumbers);
    }
    public static ArrayList<Integer> getTotalNumbers(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> totalNumbers=new ArrayList<>();
        for(Integer number:numbers)
        {
            if(totalNumbers.contains(number))
                continue;
            totalNumbers.add(number);
        }
        return totalNumbers;
    }
    public static void main(String[] args) {
        ArrayList<Integer> numbers=new ArrayList<>();
        Collections.addAll(numbers,12,4,12,5,6,7,3,4,1,2,1);
        ArrayList<Integer> uniqueNumbers=getUniqueNumbers(numbers);
        System.out.println(uniqueNumbers);
        ArrayList<Integer> duplicateNumbers=getDuplicateNumbers(numbers);
        System.out.println(duplicateNumbers);
        ArrayList<Integer> totalNumbers=getTotalNumbers(numbers);
        System.out.println(totalNumbers);

    }
}
