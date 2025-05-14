package edu.scu.myheap;

import javax.swing.*;
import java.util.*;

public class Twitter {
    int postid;//博文总id
    Map<Integer,Set<Integer>> maps;//用户和关注关系
    Map<Integer,TreeMap<Integer,Integer>> news;
    Map<Integer,Map<Integer,Integer>> mynews;
    public Twitter() {
        postid =0;
        maps = new HashMap<>();
        news = new HashMap<>();
        mynews = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        check(userId);
        news.get(userId).put(postid,tweetId);
        mynews.get(userId).put(postid,tweetId);
        for (Map.Entry<Integer, Set<Integer>> entry : maps.entrySet()) {
            if (entry.getValue().contains(userId)) {
                news.get(entry.getKey()).put(postid,tweetId);
                System.out.println(news.get(entry.getKey()).firstEntry());
            }
        }
        postid++;
    }

    public List<Integer> getNewsFeed(int userId) {
        check(userId);
        Map<Integer,Integer> map = news.get(userId);
        List<Integer> list = new ArrayList<>();
        int index=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            index++;
            list.add(entry.getValue());
            if (index>=10) break;
        };
        return list;
    }

    public void follow(int followerId, int followeeId) {
        check(followerId,followeeId);
        Set<Integer> followees = maps.get(followerId);
        followees.add(followeeId);
        TreeMap<Integer, Integer> addnews = news.get(followerId);
        addnews.putAll(mynews.get(followeeId));
    }

    public void unfollow(int followerId, int followeeId) {
        check(followerId,followeeId);
        Set<Integer> followees = maps.get(followerId);
        Map<Integer,Integer> thisnews = news.get(followerId);
        for(Map.Entry<Integer,Integer> entry : mynews.get(followeeId).entrySet()) {
            thisnews.remove(entry.getKey());
        }
        followees.remove(followeeId);
    }
    private void check(int... ers) {
        for (int i : ers) {
            if (!maps.containsKey(i)) {
                maps.put(i,new HashSet<>());
            }
            if (!news.containsKey(i)) {
                news.put(i,new TreeMap<>((a,b)->b-a));
            }
            if (!mynews.containsKey(i)) {
                mynews.put(i,new HashMap<>());
            }
        }
    }
}
