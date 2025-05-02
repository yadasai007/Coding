package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
    String name;
    int age;
    // Constructor, getters, setters
    Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public Integer getAge() {
        return age;
    }
    public String getName()
    {
        return name;
    }
}

// Expected Output: {25=[Alice, Charlie], 30=[Bob]}
public class StreamsPractice {

    public static void convertUpper()
    {
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        names=names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(names);
        // Expected Output: ["ALICE", "BOB", "CHARLIE"]
    }
    public static void aggregate()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Sum = "+numbers.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Max = "+numbers.stream().mapToInt(Integer::intValue).max().getAsInt());
        System.out.println("Min = "+numbers.stream().mapToInt(Integer::intValue).min().getAsInt());
        // Expected Output: Sum=15
        // Expected Output: Max = 5, Min = 1
    }
    public static void getAnyAll()
    {
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Grapes");
        System.out.println(words.stream().anyMatch(name->name.startsWith("A"))?"There is any string starts with \"A\" ":"There is no string starts with \"A\"");
        System.out.println(words.stream().allMatch(name->name.length()>8)?"All strings have length > 8":"All strings do not have length > 8");
        /*
        Any string starts with "A".
        All strings have length > 3.
         */
    }

    public static void getDistinct()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println(numbers.stream().distinct().collect(Collectors.toList()));
        // Expected Output: [1, 2, 3, 4, 5]
    }
    public static void sortStrings()
    {
        List<String> fruits = Arrays.asList("Banana", "Apple", "Cherry");
        System.out.println(fruits.stream().sorted().collect(Collectors.toList()));
        System.out.println(fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        // Expected Output (Natural): ["Apple", "Banana", "Cherry"]
        // Expected Output (Reverse): ["Cherry", "Banana", "Apple"]
    }
    public static void getFlatmap()
    {
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        System.out.println(nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList()));
        // Expected Output: [1, 2, 3, 4, 5, 6]
    }

    public static void groupByAge()
    {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25)
        );
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName, Collectors.toList()))));
        // Expected Output: {25=[Alice, Charlie], 30=[Bob]}

    }
    public static void evenOdd()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(numbers.stream().collect(Collectors.partitioningBy(number->number%2==0)));
        // Expected Output: {false=[1, 3, 5], true=[2, 4, 6]}
    }
    public static void getEven(int n)
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers.stream().filter(number->number%2==0).limit(n).collect(Collectors.toList()));
        // Expected Output: [2, 4, 6](n=3)
    }
    public static void wordCount()
    {
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        System.out.println(words.stream().collect(Collectors.groupingBy(word->word,Collectors.counting())));
        // Expected Output: {apple=2, banana=2, cherry=1}
    }

    public static void getLongest()
    {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript", "C++");
        System.out.println(words.stream().max(Comparator.comparingInt(String::length)).orElse(""));
        // Expected Output: "JavaScript"
    }

    public static void getOddSquares()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().filter(n->n%2!=0).mapToInt(Integer::intValue).map(n->n*n).sum());
        // Expected Output: 1² + 3² + 5² = 1 + 9 + 25 = 35
    }
    public static void mergeWithoutDuplicates()
    {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4, 5);
        System.out.println(Stream.concat(list1.stream(),list2.stream()).distinct().collect(Collectors.toList()));
        // Expected Output: [1, 2, 3, 4, 5]
    }
    public static void main(String[] args) {
        convertUpper();
        aggregate();
        getAnyAll();
        getDistinct();
        sortStrings();
        getFlatmap();
        wordCount();
        evenOdd();
        getEven(4);
        getEven(3);
        groupByAge();
        getLongest();
        getOddSquares();
        mergeWithoutDuplicates();
    }
}
