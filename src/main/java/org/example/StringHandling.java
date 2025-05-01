package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class StringHandling {
    public static ArrayList<String> getUnique(String string)
    {
        ArrayList<String> unique=new ArrayList<>();
        HashMap<String,Integer> wordCount=new HashMap<>();
        String[] words=string.split(" ");
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
    public static ArrayList<String> getDuplicate(String string)
    {
        ArrayList<String> duplicates=new ArrayList<>();
        HashMap<String,Integer> wordCount=new HashMap<>();
        String[] words=string.split(" ");
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

    public static ArrayList<String> getWords(String string)
    {
        ArrayList<String> words=new ArrayList<>();
        String[] splitWords=string.split(" ");
        for(String word:splitWords)
        {
            if(words.contains(word))
                continue;
            words.add(word);
        }

        return words;
    }
    public static HashMap<String,Integer> getWordsCount(String string)
    {
        HashMap<String,Integer> wordCount=new HashMap<>();
        String[] words=string.split(" ");
        for(String word:words)
        {
            if(wordCount.containsKey(word))
                wordCount.put(word,wordCount.get(word)+1);
            else
                wordCount.put(word,1);
        }
        return wordCount;
    }
    public static void main(String[] args) {
        String string="Hello world hello world java world";
        ArrayList<String> uniqueWords=StringHandling.getUnique(string);
        ArrayList<String> duplicateWords =StringHandling.getDuplicate(string);
        ArrayList<String> totalWords =StringHandling.getWords(string);
        HashMap<String,Integer> wordCount=StringHandling.getWordsCount(string);
        System.out.println(uniqueWords);
        System.out.println(duplicateWords);
        System.out.println(totalWords);
        System.out.println(wordCount);
    }
}
