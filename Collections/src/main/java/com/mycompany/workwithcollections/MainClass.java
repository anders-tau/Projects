package com.mycompany.workwithcollections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {
    
    enum Courses {
            JAVA, SPRING, HIBERNATE, JAVASCRIPT, PYTHON, SQL
        }
    
    public static void main(String[] args) {
        //arraylistexample();
        //linkedlistexample();
        //hashsetexample();
        //treesetexample();
        //hashmapexample();
        treemapexample();
        //enumsetexample();
        //enumexample();
        //arraydequeexample();
        //enummapexample();
        //streamandlambdaexample();
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
        groups.forEach(System.out::println);
        System.out.println("----------------------");
        
        System.out.println(groups.get(1)); //Получаем элемент по индексу
        System.out.println("----------------------");
        
        groups.set(0, "Pet Shop Boys"); //Заменяем значение элемента с индексом 0 на новое значение Pet Shop Boys
        
        //Выводим количество элементов в коллекции
        System.out.printf("Коллекция groups содержит %d элементов \n", groups.size());
        System.out.println("----------------------");
        
        //Выводим все элементы коллекции
        groups.forEach(System.out::println);
        System.out.println("----------------------");
        
        boolean result = groups.contains("Pet Shop Boys");
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
        states.forEach(x -> System.out.println(x));
        System.out.println("--------------------");
        
        System.out.printf("Коллекция states содержит %d элементов \n", states.size());
        System.out.println("--------------------");
        
        System.out.println(states.get(1));
        System.out.println("--------------------");
        
        states.set(1, "Portugal");
        states.forEach(x -> System.out.println(x));
        System.out.println("--------------------");
        
        //Проверяем на наличие элемента в списке
        if(states.contains("Germany")){  
            System.out.println("Коллекция содержит элемент Germany");
        }
        
        states.remove("Germany");
        ((LinkedList)states).removeFirst(); // Удаляем первый элемент
        ((LinkedList)states).removeLast(); // Удаляем последний элемент
        states.forEach(System.out::println);
        System.out.println("-----------not sorted-------------");
        
        Collections.sort(states);
        
        states.forEach(state -> {
            System.out.println(state);
        });
        System.out.println("-----------sorted-----------------");
          
        //В качестве объектов в коллекции можно хранить свои классы
        //Класс Person объявлен ниже с конструктором, позволяющим задавать
        //имя при создании класса
        LinkedList<Person> people = new LinkedList<>();
        
        people.add(new Person("Thomas Anders"));
        people.addFirst(new Person("Diter Bolen"));
        people.addLast(new Person("Freddie Mercury"));
        people.remove(1); // Удаляем второй элемент
        people.forEach(p -> {
            System.out.println(p.getName());
        });
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
        System.out.println(hashcodeRock);
        System.out.println(hashcodePop);        
             
        rockGroups.addAll(popGroups);
        rockGroups.forEach(x -> System.out.println(x));
        // Пытаемся добавить элемент, который уже есть в коллекции
        boolean isAdded = rockGroups.add("Queen");
        System.out.println(isAdded);    //Должны получить результат false
        
        System.out.println(rockGroups.getClass());
        
    }
    
    //Пример с коллекцией TreeSet
    private static void treesetexample() {
        
        Set<String> groups = new HashSet<>();
        Set<String> sortedGroups  = new TreeSet<>();
        
        groups.add("Dire Straits");
        groups.add("Depeche Mode");
        groups.add("Moby");
        groups.add("Nazareth");
        
        sortedGroups.addAll(groups);
        
        Iterator<String> iter = sortedGroups.iterator();
        while (iter.hasNext()) {
            String element = iter.next();
            System.out.println(element);
        }
        
        System.out.println("------------------------------");
        
        SortedSet<String> ss = ((TreeSet)sortedGroups).subSet("Dire Straits", "Nazareth");
        Iterator<String> newIter = ss.iterator();
        while (newIter.hasNext()) {
            String newElement = newIter.next();
            System.out.println(newElement);
        }
        
        System.out.println("------------------------------");
        
        SortedSet<String> tail = ((TreeSet)sortedGroups).tailSet("Dire Straits");
        Iterator<String> ni = tail.iterator();
        while (ni.hasNext()) {
            String ne = ni.next();
            System.out.println(ne);
        }
        
        System.out.println("------------------------------");
        
        System.out.println(((TreeSet)sortedGroups).first());
        System.out.println("------------------------------");
        
        System.out.println(((TreeSet)sortedGroups).last());
        System.out.println("------------------------------");
        
        System.out.println(((TreeSet)sortedGroups).lower("Moby"));
        System.out.println("lower Moby---------------------");
        
        System.out.println(((TreeSet)sortedGroups).higher("Moby"));
        System.out.println("higher Moby--------------------");
        
    }
    
    //Пример с коллекцией HashMap
    private static void hashmapexample() {
        
        Map<Integer, String> popGroups = new HashMap<>();
        Map<Integer, String> rockGroups = new HashMap<>();
        
        popGroups.put(5, "Modern Talking");
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
        
        System.out.println("keys-------------------------");
        
        Set<Integer> keys = rockGroups.keySet();
        keys.forEach(System.out::println);
        
        System.out.println("values-----------------------");
        
        Collection<String> values = rockGroups.values();
        values.forEach(System.out::println);
        
        System.out.println("-----------------------------");
        
        // Перебор элементов
        rockGroups.entrySet().forEach(item -> {
            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
        });
        
        System.out.println("-----------------------------");
        
        Map<String, Person> musicians = new HashMap<>();
        musicians.put("1i1", new Person("Dave Gahan"));
        musicians.put("1i2", new Person("Till Lindemann"));
        musicians.put("1i3", new Person("James Hetfield"));
         
        musicians.entrySet().forEach(item -> {
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        });        
    }
    
        //Пример с коллекцией TreeMap
    private static void treemapexample() {
        Map<String, Person> musicians = new TreeMap<>();
        musicians.put("1", new Person("Dave Gahan"));
        musicians.put("2", new Person("Till Lindemann"));
        musicians.put("3", new Person("James Hetfield"));
        
        Map<String, Person> afterMap = ((TreeMap)musicians).tailMap("2");
        afterMap.entrySet().forEach(itemAfter -> {
            System.out.printf("Key: %s  Value: %s \n", itemAfter.getKey(), itemAfter.getValue().getName());
        });        
        
        System.out.println("-----------------------------");
        
        Map<String, Person> beforeMap = ((TreeMap)musicians).headMap("3");
        beforeMap.entrySet().forEach(itemBefore -> {
            System.out.printf("Key: %s  Value: %s \n", itemBefore.getKey(), itemBefore.getValue().getName());
        });
        
        System.out.println("-----------------------------");
        
    }
       
    //Пример с коллекцией ArrayDeque
    private static void arraydequeexample() {
        Queue<String> groups = new ArrayDeque<>();
        groups.add("Dire Straits");
        groups.add("Depeche Mode");
        groups.add("Moby");
        groups.add("Nazareth");
        groups.offer("Deep Purple");        
        System.out.println(groups.element());
        System.out.println(groups.peek());
        System.out.println(groups.poll());
        System.out.println(groups.remove());
    }
    
    //Пример с коллекцией PriorityDeque
    private static void priorityqueueexample() {
        Queue<String> groups = new PriorityQueue<>();
    }
     
    //Пример с перечислением Enum
    private static void enumexample() {
        System.out.println(Courses.JAVA.name());
        System.out.println(Courses.JAVA.ordinal());
        
        Courses[] CoursesArray = Courses.values();
        System.out.println(Arrays.toString(CoursesArray));
        System.out.println("----------------------------------------");
    }
    
    //Пример с колллекцией EnumSet
    private static void enumsetexample() {
        EnumSet<Courses> studyCourses;
        studyCourses = EnumSet.of(Courses.JAVA, Courses.SPRING, Courses.HIBERNATE, Courses.JAVASCRIPT, Courses.SQL);
        System.out.println(studyCourses);
        System.out.println("----------------------------------------");
        studyCourses = EnumSet.range(Courses.SPRING, Courses.SQL);
        System.out.println(studyCourses);
        System.out.println("----------------------------------------");
        studyCourses = EnumSet.allOf(Courses.class);
        System.out.println(studyCourses);
        System.out.println("----------------------------------------");
        Collection col = new ArrayList<>();
        col.add(Courses.JAVA);
        col.add(Courses.HIBERNATE);
        col.add(Courses.SPRING);
        EnumSet finalCourse = EnumSet.copyOf(col);
        System.out.println(finalCourse);
        System.out.println("----------------------------------------");
        EnumSet<Courses> mainCourses;
        mainCourses = EnumSet.of(Courses.JAVA, Courses.SPRING, Courses.SQL);
        EnumSet<Courses> complementCourses;
        complementCourses = EnumSet.complementOf(mainCourses);
        System.out.println(complementCourses);
        System.out.println("----------------------------------------");
    }
    
    //Пример с колллекцией EnumMap
    private static void enummapexample() {
        EnumMap<Courses, String> trainingCourses = new EnumMap<>(Courses.class);
        trainingCourses.put(Courses.JAVA, "Very important");
        trainingCourses.put(Courses.PYTHON, "Not now");
        trainingCourses.put(Courses.SQL, "Middle level");
        System.out.println(trainingCourses);
        System.out.println("----------------------------------------");
        System.out.println(trainingCourses.get(Courses.JAVA));
        trainingCourses.entrySet().forEach(item -> {
            System.out.printf("Ключ: %s  Значение: %s \n", item.getKey(), item.getValue());
        });
    }

    //Пример Stream API и лямбда
    private static void streamandlambdaexample(){
        
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        System.out.println("streamFromValues = " + streamFromValues.collect(Collectors.toList()));
        
        IntStream streamFromString = "123".chars();
        System.out.print("streamFromString = ");
        streamFromString.forEach(e -> System.out.print(e + " , ")); // напечатает streamFromString = 49 , 50 , 51 ,
        System.out.println();
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
