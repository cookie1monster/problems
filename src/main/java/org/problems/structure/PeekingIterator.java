package org.problems.structure;

import java.util.Iterator;

//https://leetcode.com/problems/peeking-iterator/description/
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer peekVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.peekVal = iterator.hasNext() ? iterator.next() : null;
    }

    public Integer peek() {
        return peekVal;
    }

    @Override
    public Integer next() {
        Integer curr = peekVal;
        if (iterator.hasNext() && peekVal != null)
            peekVal = iterator.next();
        else
            peekVal = null;
        return curr;
    }

    @Override
    public boolean hasNext() {
        return peekVal != null || iterator.hasNext();
    }
}
