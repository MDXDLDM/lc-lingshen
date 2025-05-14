package edu.scu.myheap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class FoodRatings {
    HashMap<String,String> belong;//存储每个菜是哪一种烹饪方式
    HashMap<String,Integer> belong2;
    HashMap<String, PriorityQueue<String[]>> rate;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        belong = new HashMap<>();
        belong2 = new HashMap<>();
        rate = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            belong.put(foods[i], cuisines[i]);
            belong2.put(foods[i], ratings[i]);
            if (!rate.containsKey(cuisines[i])) {
                rate.put(cuisines[i], new PriorityQueue<>(new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        int a = Integer.parseInt(o1[0]);
                        int b = Integer.parseInt(o2[0]);
                        if (a == b) return o1[1].compareTo(o2[1]);
                        return b-a;
                    }
                }));
            }
            rate.get(cuisines[i]).add(new String[] {String.valueOf(ratings[i]), foods[i]});
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = belong.get(food);
        belong2.put(food, newRating);
        PriorityQueue<String[]> p = rate.get(cuisine);
        p.add(new String[] {String.valueOf(newRating), food});
    }

    public String highestRated(String cuisine) {
        PriorityQueue<String[]> p = rate.get(cuisine);
        while(!p.isEmpty()&&Integer.parseInt(p.peek()[0])!=belong2.get(p.peek()[1])) {
            p.poll();
        }
        return p.peek()[1];
    }
}
