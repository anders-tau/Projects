package WorkWithCollections;

import java.util.ArrayList;
import java.util.HashSet;

public class Program {
    public static void main(String[] args) {
        ArrayListExample();
        HashSetExample();
    }

    private static void ArrayListExample() {
        ArrayList<String> groups = new ArrayList<String>();
        groups.add("Modern Talking");
        groups.add("Bad Boys Blue");
        groups.add("CCCatch");
        groups.add("Fancy");
        for (String group : groups) {
            System.out.println(group);
        }
    }

    private static void HashSetExample() {
        HashSet groups = new HashSet();
        groups.add("Modern Talking");
        groups.add("Bad Boys Blue");
        groups.add("CCCatch");
        groups.add("Fancy");
    }
}


