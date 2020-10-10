package com.mycompany.workwithcollections;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        arraylistexample();
        //linkedlistexample();
        //hashsetexample();
        //hashmapexample();
    }
    //Пример с коллекцией ArrayList
    private static void arraylistexample() {
        
        List<String> groups = new ArrayList<>();
        
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
        boolean result = groups.contains("Pet Shop Boys") ? true : false;
        //Выводим результат
        System.out.println(result);
        System.out.println("----------------------");
        
        // Удаление конкретного элемента из коллекции
        groups.remove("Fancy");
        // Удаление элемента по индексу
        groups.remove(0);
        
        //При удалении стоит воспользоваться методом TrimToSize()
        //чтобы привести размер массива в соответствие с хранимыми значениями
        ((ArrayList)groups).trimToSize();
          
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
    private static void linkedlistexample() {
        
        List<String> states = new LinkedList<>();
        
        // Добавляем в коллекцию элементы
        states.add("Germany");
        states.add("France");
        ((LinkedList)states).addLast("Great Britain"); // Добавляем элемент на последнее место
        ((LinkedList)states).addFirst("Spain"); // Добавляем элемент на первое место
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
        ((LinkedList)states).removeFirst(); // Удаляем первый элемент
        ((LinkedList)states).removeLast(); // Удаляем последний элемент
        
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
    private static void hashsetexample() {
        
        Set<String> popGroups = new HashSet<>();
        Set<String> rockGroups = new HashSet<>();
        
        popGroups.add("Modern Talking");
        popGroups.add("Bad Boys Blue");
        popGroups.add("CCCatch");
        popGroups.add("Fancy");
        
        rockGroups.add("Queen");
        rockGroups.add("Metallica");
        rockGroups.add("Rammstein");
        rockGroups.add("ZZ Top");
        
        int hashcodeRock = rockGroups.hashCode();
        int hashcodePop = popGroups.hashCode();
        
        rockGroups.addAll(popGroups);
        for (Object group : rockGroups) {
            System.out.println(group);
        }
        
        System.out.println(hashcodeRock);
        System.out.println(hashcodePop);
    }
    
    //Пример с коллекцией LinkedHashSet
    private static void linkedhashsetexample() {
        Set<String> groups = new LinkedHashSet<>();
    }
    
    //Пример с коллекцией TreeSet
    private static void treesetexample() {
        Set<String> groups  = new TreeSet<>();
    }
    
    //Пример с коллекцией HashMap
    private static void hashmapexample() {
        
        HashMap popGroups = new HashMap();
        HashMap rockGroups = new HashMap();
        
        popGroups.put(5,"Modern Talking");
        popGroups.put(6, "Bad Boys Blue");
        popGroups.put(7, "CCCatch");
        popGroups.put(8, "Fancy");
        
        rockGroups.put(1, "Queen");
        rockGroups.put(2, "Metallica");
        rockGroups.put(3, "Rammstein");
        rockGroups.put(4, "ZZ Top");
            
        rockGroups.putAll(popGroups);
        
        for (int counter = 1; counter <= rockGroups.size(); counter++){
            System.out.println(rockGroups.get(counter));
        }        
    }
    
    //Пример с коллекцией LinkedHashMap
    private static void linkedhashmapexample() {
        Map groups = new LinkedHashMap();
    }
    
    //Пример с коллекцией TreeMap
    private static void treemapexample() {
        Map groups = new TreeMap();
    }
    
    //Пример с коллекцией ArrayDeque
    private static void arraydequeexample() {
        Queue<String> groups = new ArrayDeque<>();
    }
    
    //Пример с коллекцией PriorityDeque
    private static void priorityqueueexample() {
        Queue<String> groups = new PriorityQueue<>();
    }
    
    static class Person{      
        String name;
        public Person(String value){
            this.name = value;
        }
        String getName(){
            return name;
        }
    }    
}
