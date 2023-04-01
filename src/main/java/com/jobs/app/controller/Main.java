package com.jobs.app.controller;

import java.util.*;

public class Main {
        public static int birdSighting(int[] birdId) {
            Map<Integer, Integer> birdCount = new HashMap<Integer, Integer>();
            int maxIdOccurence = 0;
            for (int j : birdId) {
                int count = birdCount.getOrDefault(j, 0) + 1;
                birdCount.put(j, count);
                maxIdOccurence = Math.max(maxIdOccurence, count);
            }

            List<Integer> frequentBirds = new ArrayList<Integer>();
            for (int birdType : birdCount.keySet()) {
                if (birdCount.get(birdType) == maxIdOccurence) {
                    frequentBirds.add(birdType);
                }
            }
            return Collections.min(frequentBirds);

    }

    public static void main(String[] args) {
        int[] testArrayOfId = {3,9,2,7,9,3,7,7,2,2,2,8,8,44,3,3};
        int highestOccurringId = birdSighting(testArrayOfId);
        System.out.println(highestOccurringId);
    }
}
