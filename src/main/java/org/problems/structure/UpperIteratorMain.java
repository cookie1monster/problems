package org.problems.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class UpperIterator implements Iterator<Character> {
    private List<Character> list;
    private int pointer;
    private Integer toRemove;


    public UpperIterator(List<Character> list) {
        this.list = list;
        while (pointer < list.size() && !isValid(list.get(pointer))) {
            ++pointer;
        }
        toRemove = null;
    }

    @Override
    public Character next() {
        if (!hasNext())
            throw new NoSuchElementException();

        toRemove = pointer;
        Character ch = list.get(pointer);
        ++pointer;
        while (pointer < list.size() && !isValid(list.get(pointer))) {
            ++pointer;
        }
        return ch;
    }

    @Override
    public void remove() {
        if (toRemove == null)
            throw new IllegalStateException();

        list.remove((int) toRemove);
        --pointer;

        toRemove = null;
    }

    @Override
    public boolean hasNext() {
        return pointer < list.size();
    }

    private boolean isValid(Character ch) {
        return ch != null && ch >= 'A' && ch <= 'Z';
    }
}

public class UpperIteratorMain {
    public static void main(String[] args) {

        // d X t h Y Z b
        List<Character> list = new ArrayList<>();
        list.add('d');
        list.add('X');
        //list.add('t');
        //list.add('h');
        list.add('Y');
        list.add('Z');
        list.add('b');

        UpperIterator it = new UpperIterator(list);
        System.out.println(it.next());
        System.out.println(it.next());

        System.out.println(it.next());
        it.remove();

        System.out.println(it.hasNext());


        System.out.println(list);
    }
}