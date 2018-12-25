package org.problems.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

class HitCounter {

    ConcurrentMap<Integer, AtomicInteger> timeframe;
    ConcurrentMap<Integer, AtomicInteger> hits;

    public HitCounter() {
        timeframe = new ConcurrentHashMap<>();
        hits = new ConcurrentHashMap<>();
        for (int i = 0; i < 300; ++i) {
            timeframe.put(i, new AtomicInteger(0));
            hits.put(i, new AtomicInteger(0));
        }
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int time = timestamp % 300;
        if (timeframe.get(time).get() == timestamp) {
            hits.get(time).incrementAndGet();
        } else {
            timeframe.get(time).updateAndGet(t -> timestamp);
            hits.get(time).updateAndGet(h -> 1);
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int hitsVal = 0;
        for (int i = 0; i < 300; ++i) {
            if (timeframe.get(i).get() > timestamp - 300)
                hitsVal += hits.get(i).get();
        }
        return hitsVal;
    }
}
