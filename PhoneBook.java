package Seminar05_HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBook{
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    public static void printBook(Map<String, ArrayList<Integer>> map){
        for (var item : map.entrySet()) {
            String phones = "\t";
            for(int number: item.getValue()){
                phones = phones + number + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneNumbers = new HashMap<>();
        addNumber("Ivanov", 151641, phoneNumbers);
        addNumber("Ivanov", 23111, phoneNumbers);
        addNumber("Petrov", 75138, phoneNumbers);
        addNumber("Abazov", 1549, phoneNumbers);
        addNumber("Ivanov", 1289, phoneNumbers);
        addNumber("Petrov", 98774, phoneNumbers);

        phoneNumbers = phoneNumbers.entrySet()      // Set<Entry<String, String>>
                .stream()               // Stream<Entry<String, String>>
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        printBook(phoneNumbers);
    }
}