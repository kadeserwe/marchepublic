package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class testSaveOrder {

    public static void main(String[] args) {
//        Set<String> fruits = new HashSet<>();
//
//        fruits.add("Apple");
//        fruits.add("Banana");
//        fruits.add("Orange");
//        fruits.add("Apple");  // Duplicate, won't be added again
//
//        for (String fruit : fruits) {
//            System.out.println(fruit);
//        }

        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");  // Duplicate, won't be added again

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

}}
