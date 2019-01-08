// $Id: $
package uk.co.littlestickyleaves.hello.j9plus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You can now make a Map or a List in one go
 * The returned Collection is unmodifiable
 */
public class Initialization {

    private static final Map<String, Integer> NEW_MAP_MAKING = Map.of("Hello", 3,
            "Hi", 10,  "Greetings", 1, "Hey", 2);

    private static final Map<String, Integer> MAP_FROM_ENTRIES = Map.ofEntries(Map.entry("Hello", 3),
            Map.entry("Hi", 10), Map.entry("Greetings", 1), Map.entry("Hey", 2));

    private static final Map<String, Integer> OLD_MAP_MAKING = new HashMap<>();

    static {
        OLD_MAP_MAKING.put("Hello", 3);
        OLD_MAP_MAKING.put("Hi", 10);
        OLD_MAP_MAKING.put("Greetings", 1);
        OLD_MAP_MAKING.put("Hey", 2);
    }

    public static void main(String[] args) {
        Initialization initialization = new Initialization();
        initialization.go();
    }

    private void go() {
        System.out.println("The type of the Map made from Map.of() is: " + NEW_MAP_MAKING.getClass());
        System.out.println("The type of the Map made from Map.ofEntries() is: " + MAP_FROM_ENTRIES.getClass());
        System.out.println("The type of the Map made from new HashMap() is: " + OLD_MAP_MAKING.getClass());

        List<Integer> fromArraysAsList = Arrays.asList(1, 2, 3, 4);
        List<Integer> fromListOf = List.of(1, 2, 3, 4);

        System.out.println("The type of the List made from Arrays.asList() is: " + fromArraysAsList.getClass());
        System.out.println("The type of the List made from List.of() is: " + fromListOf.getClass());
    }

}
