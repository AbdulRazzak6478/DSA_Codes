package core;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Practice {

    public static void main(String[] args) throws Exception {
        System.out.println("Practice Java Methods");

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(7);

        System.out.println("List: " + list);

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A");

        System.out.println(set); // [A, B]
        System.out.println("Hashmap");

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        System.out.println(map.get("A")); // 1

        // class User {
        // int id;

        // User(int id) { this.id = id; }

        // public boolean equals(Object o) {
        // User u = (User) o;
        // return this.id == u.id;
        // }
        // }

        // FileReader file = new FileReader("filte.txt"); // must handle

        try {
            int a = 10 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Always runs");
        }

        // Lambda Expression
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 6);

        list2.forEach(n -> System.out.println(n));

        List<Integer> list3 = list2.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .toList();
        System.out.println("Stream List : " + list3);

        System.out.println("Optional ");
        Optional<String> name = Optional.ofNullable(null);

        System.out.println(name.orElse("Default"));

        LocalDate date = LocalDate.now();
        LocalDate nextWeek = date.plusDays(7);

        System.out.println(nextWeek);

        // Files.write(Paths.get("test.txt"), "Hello".getBytes());

        // String data = Files.readString(Paths.get("test.txt"));

        // @FunctionalInterface
        // interface MyFunc {
        // void sayHello();
        // }

        // public class Main {

        // public static void main(String[] args) {

        // MyFunc obj = () -> {
        // System.out.println("Hello from Lambda");
        // };

        // obj.sayHello();
        // }
        // }

        // User user = getUser();

        // if(user != null) {
        // System.out.println(user.getName());
        // }

        // Optional<User> user = getUser();

        // user.ifPresent(u -> System.out.println(u.getName()));

        // String data = Files.readString(Paths.get("test.txt"));

        Files.write(Paths.get("test.txt"), "Hello".getBytes());

        String data = Files.readString(Paths.get("test.txt"));

        System.out.println(data);

        // import java.util.*;

        // class User implements Comparable<User> {

        // String name;
        // int age;

        // User(String name, int age) {
        // this.name = name;
        // this.age = age;
        // }

        // @Override
        // public int compareTo(User u) {

        // // Ascending order
        // return this.age - u.age;
        // }

        // @Override
        // public String toString() {
        // return name + " - " + age;
        // }
        // }

        // public class Main {

        // public static void main(String[] args) {

        // List<User> users = new ArrayList<>();

        // users.add(new User("Abdul", 24));
        // users.add(new User("Rahul", 20));
        // users.add(new User("Sam", 28));

        // Collections.sort(users);

        // System.out.println(users);
        // }
        // }

        // import java.util.*;

        // class User {

        // String name;
        // int age;

        // User(String name, int age) {
        // this.name = name;
        // this.age = age;
        // }

        // @Override
        // public String toString() {
        // return name + " - " + age;
        // }
        // }

        // public class Main {

        // public static void main(String[] args) {

        // List<User> users = new ArrayList<>();

        // users.add(new User("Abdul", 24));
        // users.add(new User("Rahul", 20));
        // users.add(new User("Sam", 28));

        // Comparator<User> comp = (u1, u2) -> u2.age - u1.age;

        // users.sort(comp);

        // System.out.println(users);
        // }
        // }
        // }

    }

}