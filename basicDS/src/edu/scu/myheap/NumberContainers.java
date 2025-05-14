package edu.scu.myheap;

import java.util.*;

public class NumberContainers {
    HashMap<Integer, Integer> numbers;//index-number
    HashMap<Integer, TreeSet<Integer>> map;
    public NumberContainers() {
        numbers = new HashMap<>();
        map = new HashMap<>();
    }

    public void change(int index, int number) {
        if (numbers.containsKey(index)) {
            int value = numbers.get(index);
            TreeSet<Integer> set = map.get(value);
            set.remove(index);
            if (set.isEmpty()) {
                map.remove(value);
            }
        }
        numbers.put(index, number);
        if (!map.containsKey(number)) {
            map.put(number, new TreeSet<>());
        }
        map.get(number).add(index);
    }

    public int find(int number) {
        if (map.containsKey(number)) {
            return map.get(number).first();
        }
        return -1;
    }
}

