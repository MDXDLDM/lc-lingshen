package edu.scu.mystack;

import java.util.LinkedList;
import java.util.List;

public class No735 {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i]>0||list.isEmpty()){
                list.add(asteroids[i]);
            }else{
                while(!list.isEmpty()){
                    int temp = list.get(list.size()-1);
                    if (temp<0){
                        list.add(asteroids[i]);
                        break;
                    }
                    if(temp+asteroids[i]<0){
                        list.remove(list.size()-1);
                        if(list.isEmpty()){
                            list.add(asteroids[i]);
                            break;
                        }
                    }else if(temp+asteroids[i]==0){
                        list.remove(list.size()-1);
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
