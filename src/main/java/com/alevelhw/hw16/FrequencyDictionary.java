package com.alevelhw.hw16;

import org.apache.commons.lang3.time.StopWatch;

import java.util.*;

public class FrequencyDictionary {
    private final FrequencyDictionaryComparatorByValue firstComp = new FrequencyDictionaryComparatorByValue();
    private final Comparator<Map.Entry<String, Integer>> Comp =
            firstComp.thenComparing(new FrequencyDictionaryComparatorByKey());
    private final StopWatch watch = new StopWatch();
    private final String data;
    private Set<Map.Entry<String, Integer>> treeSet;

    public FrequencyDictionary(String data) {
        this.data = data;
        this.treeSet = getDictionary(data);
    }

    public Set<Map.Entry<String, Integer>> getTreeSet() {
        return treeSet;
    }

    public String getData() {
        return data;
    }

    private Set<Map.Entry<String, Integer>> getDictionary(String data) {
        watch.start();

        data = data.toLowerCase();
        String[] dataSplit = data.split(" ");
        for (int i = 0; i < dataSplit.length; i++) {
            dataSplit[i] = dataSplit[i].replaceAll("[^\\p{L}]+", "");
        }
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String key : dataSplit) {
            int value = 0;
            for (String s : dataSplit) {
                if (key.equals(s)) {
                    value++;
                }
            }
            treeMap.put(key, value);
        }
        treeMap.remove("");
        treeSet = new TreeSet<>(Comp);
        treeSet.addAll(treeMap.entrySet());

        watch.stop();
        System.out.println("Time Elapsed for getDictionary: " + watch.getTime() + " milliseconds");
        return treeSet;
    }

    private class FrequencyDictionaryComparatorByKey implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getKey().compareTo(o2.getKey());
        }
    }

    private class FrequencyDictionaryComparatorByValue implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }
}
