package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

// class User {
//     String id;
//     int age;

//     @Override
//     public int hashCode() {
//         int result = 17;          // seed
//         result = 31 * result + id.hashCode();
//         result = 31 * result + age;
//         return result;
//     }
// Conceptually:

// A number derived from the object’s identity

// Often related to memory address (but not guaranteed)
// }
// class User {
//     String id;

//     User(String id) {
//         this.id = id;
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o)
//             return true;
//         if (!(o instanceof User))
//             return false;
//         User user = (User) o;
//         return id.equals(user.id);
//     }

//     @Override
//     public int hashCode() {
//         return id.hashCode();
//     }
// }

class Student implements Comparable<Student> {

    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // NATURAL order of Student = by roll number
    @Override
    public int compareTo(Student other) {
        // this < other -> negative
        // this == other -> zero
        // this > other -> positive
        return this.rollNo - other.rollNo;
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + marks;
    }
}

public class JavaUtil {
    public static void main(String[] args) {
        List<Integer> n = new ArrayList<>();

        n.add(1);
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(2, 10);
        System.out.println("index : 3: " + n.get(2));
        System.out.println("Size:" + n.size());

        System.out.println(n);
        Collections.sort(n);
        System.out.println(n);

        Set<Integer> s = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s.add(1);
        s.add(1);
        s.add(6);
        s.add(1);
        s.add(1);
        s.add(2);
        s.add(2);
        s.add(5);
        s2.add("test1");
        s2.add("test");
        s2.add("test3");
        System.out.println(s);
        System.out.println(s2);

        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(3);
        nums.add(1);
        nums.add(2);

        System.out.println(nums); // [1, 2, 3]

        LinkedList<String> list = new LinkedList<>();
        list.addFirst("A");
        list.addLast("B");

        System.out.println(list);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("A", 90);
        scores.put("B", 80);

        System.out.println(scores.get("B"));

        Optional<String> name = Optional.of("Java");

        
        name.ifPresent(System.out::println);

        UUID id = UUID.randomUUID();
        System.out.println(id);

        Random r = new Random();
        System.out.println(r.nextInt(100));

        // public boolean equals(Object obj) {
        // return this == obj;
        // }
        // == Or Identity => same memory location comparison
        // equals Or equality => same logical meaning comparison
        // By default, Java assumes identity = equality
        // This is almost never correct for business objects.

        // Why Java does this (mental model first)

        // Imagine a large apartment complex:

        // hashCode() → decides which building

        // equals() → decides which apartment

        // Java never checks apartments in other buildings.

        // Java handles this by:
        // Storing multiple objects in the same bucket
        // Calling equals() to differentiate
        // Practical mental model (memorize this)
        // hashCode() → WHERE to look
        // equals() → WHICH one is correct
        // Or even shorter:
        // hashCode filters, equals confirms

        // “HashMap uses hashCode() to narrow the search and equals() to confirm
        // equality.
        // equals() never calls hashCode(), and different hash codes skip equality
        // checks entirely.”

        String str1 = "JAVA";
        String str2 = "JAVA";

        // CONTENT comparison
        System.out.println(str1.equals(str2)); // true

        // REFERENCE comparison
        System.out.println(str1 == str2); // true (String Pool)

        // hashCode is SAME because content is same
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        Map<String, String> map = new HashMap<>();

        map.put("user1", "Razzak");

        // New String object, same content
        String key = new String("user1");

        // HashMap will:
        // 1. call key.hashCode()
        // 2. go to correct bucket
        // 3. call equals() to confirm
        System.out.println(map.get(key)); // Razzak

        Map<User, String> userRoleMap = new HashMap<>();

        userRoleMap.put(new User("U1"), "ADMIN");

        // Lookup with logically same user
        User lookup = new User("U1");

        System.out.println(userRoleMap.get(lookup)); // ADMIN ✅

        // How HashMap actually stores something
        // map.put(key, value);
        // Step 1: Call hashCode() on the key
        // int hash = key.hashCode();
        // key = "user1";
        // hashCode = 111578566; // example number
        // Important:
        // This number can be very large
        // It can be negative
        // It is NOT directly usable as an array index
        // Step 2: Convert hashCode → bucket index
        // HashMap has an internal array of size N (default is 16).
        // index = hashCode & (N - 1);
        // index = 111578566 & 15 = 6
        // ➡️ Bucket index = 6
        // This is the “where”.
        // Case 2: Bucket already has entries (collision)
        // Iterates over objects in that bucket
        // Calls equals() on each one
        // If equals() matches → replace/update
        // Else → add as a new entry
        // This is where equals() is used.

        // “A bucket is just an internal array slot in HashMap. Java uses hashCode to
        // calculate which bucket to use,
        // and equals is only used to compare objects inside that bucket.”

        List<Student> students = new ArrayList<>();

        students.add(new Student(3, "Rahul", 85));
        students.add(new Student(1, "Aman", 90));
        students.add(new Student(2, "Neha", 80));

        // Java asks: "Do students know how to compare themselves?"
        // YES → uses compareTo()
        Collections.sort(students);

        System.out.println(students);

        // Comparator<Student> sortByMarks = (student1, student2) -> {
        // return student1.marks - student2.marks;
        // };
        Comparator<Student> sortByName = (student1, student2) -> {
            return student1.name.compareTo(student2.name);
        };
        Collections.sort(students, sortByName);
        System.out.println(sortByName);

        Comparator<Student> byMarks = Comparator.comparingInt(st -> st.marks);

        Comparator<Student> byMarksDesc = Comparator.comparingInt((Student stu) -> stu.marks).reversed();

        Comparator<Student> byName = Comparator.comparing(stud -> stud.name);
        Collections.sort(students, byName);
        System.out.println(students);

        // User findUserById(String id) {
        // return userMap.get(id); // may return null
        // }
        // User user = findUserById("U1");
        // System.out.println(user.getName()); // 💥 NPE risk

        // Optional

        // A lambda is a short way to write a function and pass it as data.

        // ❌ More than one abstract method → NOT functional interface
        // ✅ One abstract method → Functional interface

        // A stream is a pipeline to process data from a collection.

        // numbers.stream()
        // .filter(n -> n % 2 == 0)
        // .forEach(System.out::println);

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 7, 8);

        int result = numbers2.stream()
                .filter(n1 -> n1 % 2 == 0)
                .map(n1 -> n1 * n1)
                .reduce(0, Integer::sum);

        System.out.println("stream : " + result); // 56

        // ❓ What is Method Reference?

        // A shortcut for lambdas when the lambda just calls a method.

        // 🧠 Rule

        // If lambda does only one method call, use method reference.

        // List<String> names = List.of("Java", "Spring", "Boot");

        // names.forEach(System.out::println);

    }
}
