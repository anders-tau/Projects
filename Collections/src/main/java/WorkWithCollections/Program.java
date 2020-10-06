package WorkWithCollections;

import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayDeque;
import java.util.PriorityQueue;


public class Program {
    public static void main(String[] args) {
        //ArrayListExample();
        //LinkedListExample();
        //HashSetExample();
        HashMapExample();
    }
    //Пример с коллекцией ArrayList
    private static void ArrayListExample() {
        boolean result;
        
        ArrayList<String> groups = new ArrayList<>();
        
        groups.add("Modern Talking"); //Добавляем значения в коллекцию
        groups.add("Bad Boys Blue");
        groups.add("CCCatch");
        groups.add("Fancy");
        
        groups.add(4, "Savage"); //Добавляем элемент по индексу
        
        Collections.sort(groups, Collections.reverseOrder()); //Сортируем в порядке убывания
        
        //Выводим все элементы коллекции
        for (String group : groups) {
            System.out.println(group);
        }
        System.out.println("----------------------");
        
        System.out.println(groups.get(1)); //Получаем элемент по индексу
        System.out.println("----------------------");
        
        groups.set(0, "Pet Shop Boys"); //Заменяем значение элемента с индексом 0 на новое значение Pet Shop Boys
        
        //Выводим количество элементов в коллекции
        System.out.printf("Коллекция groups содержит %d элементов \n", groups.size());
        System.out.println("----------------------");
        
        //Выводим все элементы коллекции
        for(String group : groups){
            System.out.println(group);
        }
        System.out.println("----------------------");
        
        // Используя тернарную операцию, проверяем содержит ли коллекция элемент 
        result = groups.contains("Pet Shop Boys") ? true : false;
        //Выводим результат
        System.out.println(result);
        System.out.println("----------------------");
        
        // Удаление конкретного элемента из коллекции
        groups.remove("Fancy");
        // Удаление элемента по индексу
        groups.remove(0);
        
        //При удалении стоит воспользоваться методом TrimToSize()
        //чтобы привести размер массива в соответствие с хранимыми значениями
        groups.trimToSize();
          
        //Сохраняем коллекцию в массив groupsArray
        Object[] groupsArray = groups.toArray();
        //Сортируем массив groupsArray по возрастанию
        Arrays.sort(groupsArray);
        //Выводим массив groupsArray
        for(Object group : groupsArray){
            System.out.println(group);
        }
        System.out.println("----------------------");        
    }
    
    //Пример с коллекцией LinkedList
    private static void LinkedListExample() {
        LinkedList<String> states = new LinkedList<>();
        // Добавляем в коллекцию элементы
        states.add("Germany");
        states.add("France");
        states.addLast("Great Britain"); // Добавляем элемент на последнее место
        states.addFirst("Spain"); // Добавляем элемент на первое место
        states.add(1, "Italy"); // Добавляем элемент по индексу 1
        
        for(String state : states){
            System.out.println(state);
        }
        System.out.println("--------------------");
        
        System.out.printf("Коллекция states содержит %d элементов \n", states.size());
        System.out.println("--------------------");
        
        System.out.println(states.get(1));
        System.out.println("--------------------");
        
        states.set(1, "Portugal");
        for(String state : states){
            System.out.println(state);
        }
        System.out.println("--------------------");
        
        //Проверяем на наличие элемента в списке
        if(states.contains("Germany")){  
            System.out.println("Коллекция содержит элемент Germany");
        }
        
        states.remove("Germany");
        states.removeFirst(); // Удаляем первый элемент
        states.removeLast(); // Удаляем последний элемент
        
        for(String state : states){
            System.out.println(state);
        }
        System.out.println("-----------not sorted-------------");
        
        Collections.sort(states);
        
        for(String state : states){
            System.out.println(state);
        }
        System.out.println("-----------sorted-----------------");
          
        //В качестве объектов в коллекции можно хранить свои классы
        //Класс Person объявлен ниже с конструктором, позволяющим задавать
        //имя при создании класса
        LinkedList<Person> people = new LinkedList<Person>();
        
        people.add(new Person("Thomas Anders"));
        people.addFirst(new Person("Diter Bolen"));
        people.addLast(new Person("Freddie Mercury"));
        people.remove(1); // Удаляем второй элемент
          
        for(Person p : people){
            System.out.println(p.getName());
        }
        Person first = people.getFirst();
        System.out.println(first.getName()); // Выводим первый элемент
    }        
  
    //Пример с коллекцией HashSet
    private static void HashSetExample() {
        boolean result;
        int hashcode_pop;
        int hashcode_rock;
        
        HashSet<String> pop_groups = new HashSet<>();
        HashSet<String> rock_groups = new HashSet<>();
        
        result = pop_groups.add("Modern Talking");
        result = pop_groups.add("Bad Boys Blue");
        result = pop_groups.add("CCCatch");
        result = pop_groups.add("Fancy");
        
        result = rock_groups.add("Queen");
        result = rock_groups.add("Metallica");
        result = rock_groups.add("Rammstein");
        result = rock_groups.add("ZZ Top");
        
        hashcode_rock = rock_groups.hashCode();
        hashcode_pop = pop_groups.hashCode();
        
        result = rock_groups.addAll(pop_groups);
        for (Object group : rock_groups) {
            System.out.println(group);
        }
        
        System.out.println(hashcode_rock);
        System.out.println(hashcode_pop);
    }
    
    //Пример с коллекцией LinkedHashSet
    private static void LinkedHashSetExample() {
        LinkedHashSet<String> groups = new LinkedHashSet<>();
    }
    
    //Пример с коллекцией TreeSet
    private static void TreeSetExample() {
        TreeSet<String> groups  = new TreeSet<>();
    }
    
    //Пример с коллекцией HashMap
    private static void HashMapExample() {
        boolean result;
        
        HashMap pop_groups = new HashMap();
        HashMap rock_groups = new HashMap();
        
        pop_groups.put(5,"Modern Talking");
        pop_groups.put(6, "Bad Boys Blue");
        pop_groups.put(7, "CCCatch");
        pop_groups.put(8, "Fancy");
        
        rock_groups.put(1, "Queen");
        rock_groups.put(2, "Metallica");
        rock_groups.put(3, "Rammstein");
        rock_groups.put(4, "ZZ Top");
            
        rock_groups.putAll(pop_groups);
        
        for (int counter = 1; counter <= rock_groups.size(); counter++){
            System.out.println(rock_groups.get(counter));
        }        
    }
    
    //Пример с коллекцией LinkedHashMap
    private static void LinkedHashMapExample() {
        LinkedHashMap groups = new LinkedHashMap();
    }
    
    //Пример с коллекцией TreeMap
    private static void TreeMapExample() {
        TreeMap groups = new TreeMap();
    }
    
    //Пример с коллекцией ArrayDeque
    private static void ArrayDequeExample() {
        ArrayDeque<String> groups = new ArrayDeque<>();
    }
    
    //Пример с коллекцией PriorityDeque
    private static void PriorityQueueExample() {
        PriorityQueue<String> groups = new PriorityQueue<>();
    }
}

class Person{
      
    String name;
    
    public Person(String value){
        this.name = value;
    }
    
    String getName(){
        return name;
    }
}