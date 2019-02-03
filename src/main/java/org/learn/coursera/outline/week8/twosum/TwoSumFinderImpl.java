package org.learn.coursera.outline.week8.twosum;

import java.util.*;

public class TwoSumFinderImpl implements TwoSumFinder {

    private final Set<Long> originalSet;
    private final Map<Long, Integer> encountersMap;

    public TwoSumFinderImpl(List<Long> originalSet) {
        this.originalSet = new TreeSet<>(originalSet);
        this.encountersMap = initilizeMap(originalSet);
    }

    private Map<Long, Integer> initilizeMap(List<Long> numbers) {
        final Map<Long, Integer> map = new HashMap<>(1_000_000);
        for (Long number : numbers) {
            map.put(number, 0);
        }

        return map;
    }

    @Override
    public Integer find(Long sum) {
        Integer counter = 0;
        for (Long x : originalSet) {
            if (encountersMap.containsKey(sum - x) && x != sum - x) {
                counter ++;
                break;
            }
        }
        return counter;
    }
}
