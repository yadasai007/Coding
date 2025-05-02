package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class StringHandling {
    public static ArrayList<String> getUnique(String[] words)
    {
        ArrayList<String> unique=new ArrayList<>();
        HashMap<String,Integer> wordCount=new HashMap<>();
        for(String word:words)
        {
            if(wordCount.containsKey(word))
                wordCount.put(word,wordCount.get(word)+1);
            else
                wordCount.put(word,1);
        }
        for(String word:wordCount.keySet())
        {
            if(wordCount.get(word)==1)
                unique.add(word);
        }
        return unique;
    }
    public static ArrayList<String> getDuplicate(String[] words)
    {
        ArrayList<String> duplicates=new ArrayList<>();
        HashMap<String,Integer> wordCount=new HashMap<>();
        for(String word:words)
        {
            if(wordCount.containsKey(word))
                wordCount.put(word,wordCount.get(word)+1);
            else
                wordCount.put(word,1);
        }
        for(String word:wordCount.keySet())
        {
            if(wordCount.get(word)>1)
                duplicates.add(word);
        }
        return duplicates;
    }

    public static ArrayList<String> getWords(String[] splitWords)
    {
        ArrayList<String> words=new ArrayList<>();
        for(String word:splitWords)
        {
            if(words.contains(word))
                continue;
            words.add(word);
        }

        return words;
    }
    public static HashMap<String,Integer> getWordsCount(String[] words)
    {
        HashMap<String,Integer> wordCount=new HashMap<>();
        for(String word:words)
        {
            if(wordCount.containsKey(word))
                wordCount.put(word,wordCount.get(word)+1);
            else
                wordCount.put(word,1);
        }
        return wordCount;
    }

    public static String getLongWord(String[] words)
    {
        String maxLengthWord="";
        int maxLength=0;
        for(String word:words)
        {
            if(word.length()>maxLength)
            {
                maxLengthWord=word;
                maxLength=word.length();
            }
            else if(word.length()==maxLength)
            {
                if(word.compareTo(maxLengthWord)<0)
                {
                    maxLengthWord=word;
                }
            }
        }
        return maxLengthWord;
    }

    public static void main(String[] args) {
        String string="Hello world hello world java world";

        String[] words=string.split(" ");
        ArrayList<String> uniqueWords=StringHandling.getUnique(words);
        ArrayList<String> duplicateWords =StringHandling.getDuplicate(words);
        ArrayList<String> totalWords =StringHandling.getWords(words);
        HashMap<String,Integer> wordCount=StringHandling.getWordsCount(words);
        System.out.println(uniqueWords);
        System.out.println(duplicateWords);
        System.out.println(totalWords);
        System.out.println(wordCount);
        String string2="Hello World My Name is Sai Kumar and I am a Student at University of Missouri Kansas City";

        String[] words2=string2.split(" ");
        System.out.println(getLongWord(words2));//gets longest word if multiple words get the word which is lexographically small
    }
}
