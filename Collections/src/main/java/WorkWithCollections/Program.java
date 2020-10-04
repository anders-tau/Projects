package WorkWithCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        ArrayListExample();
        //HashSetExample();
        //HashMapExample();
    }

    private static void ArrayListExample() {
        boolean result;
        ArrayList<String> groups = new ArrayList<>();
        result = groups.add("Modern Talking");
        result = groups.add("Bad Boys Blue");
        result = groups.add("CCCatch");
        result = groups.add("Fancy");
        Collections.sort(groups, Collections.reverseOrder());
        for (String group : groups) {
            System.out.println(group);
        }
    }

    private static void HashSetExample() {
        boolean result;
        int hashcode_pop;
        int hashcode_rock;
        
        HashSet pop_groups = new HashSet();
        HashSet rock_groups = new HashSet();
        
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
    
    private static void HashMapExample() {
        boolean result;
        
        HashMap pop_groups = new HashMap();
        HashMap rock_groups = new HashMap();
        
        pop_groups.put(1,"Modern Talking");
        pop_groups.put(2, "Bad Boys Blue");
        pop_groups.put(3, "CCCatch");
        pop_groups.put(4, "Fancy");
        
        rock_groups.put(1, "Queen");
        rock_groups.put(2, "Metallica");
        rock_groups.put(3, "Rammstein");
        rock_groups.put(4, "ZZ Top");
            
        rock_groups.putAll(pop_groups);
        
        for (int counter = 1; counter <= rock_groups.size(); counter++){
            System.out.println(rock_groups.get(counter));
        }        
    }    
}


