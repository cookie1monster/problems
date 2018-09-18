package com.zillow;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.zillow.data.Person;
import com.zillow.services.SortService;


public class Main {
    public static void main(String[] args) {

        SortService sortService = new SortService();

        Person p1 = new Person("32112332",
                new GregorianCalendar(1976, Calendar.FEBRUARY, 11).getTime(),
                "Daffy",
                "Duck",
                6., 170.);
        Person p2 = new Person("83746584",
                new GregorianCalendar(1801, Calendar.FEBRUARY, 25).getTime(),
                null,
                "Baggins",
                null, null);
        Person p3 = new Person("87248492",
                null,
                null,
                "Mouse",
                5.1, 181.);
        Person p4 = new Person(null,
                new GregorianCalendar(1975, Calendar.DECEMBER, 11).getTime(),
                "Bugs",
                "Bunny",
                5.8, 170.);
        Person p5 = new Person("51293895",
                new GregorianCalendar(1975, Calendar.DECEMBER, 12).getTime(),
                "Porky",
                "Pig",
                6., 185.);
        Person p6 = new Person(null,
                null,
                "Lola",
                "Bunny",
                null, null);
        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5, p6);
        sortService.sort(people, "lastName", "true").forEach(System.out::println);
    }
}
