package Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        try {
            Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()) {
                String item = iterator.next();
                list.add("Four");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }

        System.out.println("List after modification attempt: " + list);
    }
}

