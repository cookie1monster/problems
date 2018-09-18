package com.zillow.services;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.IntStream;

import com.zillow.data.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortServiceTest {

    private SortService sortService = new SortService();

    private List<Person> people;
    private Person p1;
    private Person p2;
    private Person p3;
    private Person p4;
    private Person p5;
    private Person p6;

    @Before
    public void setUp() {
        p1 = new Person("32112332",
                new GregorianCalendar(1976, Calendar.FEBRUARY, 11).getTime(),
                "Daffy",
                "Duck",
                6., 170.);
        p2 = new Person("83746584",
                new GregorianCalendar(1801, Calendar.FEBRUARY, 25).getTime(),
                null,
                "Baggins",
                null, null);
        p3 = new Person("87248492",
                null,
                null,
                "Mouse",
                5.1, 181.);
        p4 = new Person(null,
                new GregorianCalendar(1975, Calendar.DECEMBER, 11).getTime(),
                "Bugs",
                "Bunny",
                5.8, 170.);
        p5 = new Person("51293895",
                new GregorianCalendar(1975, Calendar.DECEMBER, 12).getTime(),
                "Porky",
                "Pig",
                6., 185.);
        p6 = new Person(null,
                null,
                "Lola",
                "Bunny",
                null, null);
        people = Arrays.asList(p1, p2, p3, p4, p5, p6);

    }

    @Test
    public void shouldSortBySSNAsc() {
        List<Person> expected = Arrays.asList(p1, p5, p2, p3, p4, p6);
        List<Person> actual = sortService.sort(people, "ssn", "true");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortBySSNDesc() {
        List<Person> expected = Arrays.asList(p3, p2, p5, p1, p4, p6);
        List<Person> actual = sortService.sort(people, "ssn", "false");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByDateOfBirthAsc() {
        List<Person> expected = Arrays.asList(p2, p4, p5, p1, p3, p6);
        List<Person> actual = sortService.sort(people, "dateOfBirth", "true");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByDateOfBirthDesc() {
        List<Person> expected = Arrays.asList(p1, p5, p4, p2, p3, p6);
        List<Person> actual = sortService.sort(people, "dateOfBirth", "false");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByFirstNameAsc() {
        List<Person> expected = Arrays.asList(p4, p1, p6, p5, p2, p3);
        List<Person> actual = sortService.sort(people, "firstName", "true");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByFirstNameDesc() {
        List<Person> expected = Arrays.asList(p5, p6, p1, p4, p2, p3);
        List<Person> actual = sortService.sort(people, "firstName", "false");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByLastNameAsc() {
        List<Person> expected = Arrays.asList(p2, p4, p6, p1, p3, p5);
        List<Person> actual = sortService.sort(people, "lastName", "true");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByLastNameDesc() {
        List<Person> expected = Arrays.asList(p5, p3, p1, p4, p6, p2);
        List<Person> actual = sortService.sort(people, "lastName", "false");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByHeightAsc() {
        List<Person> expected = Arrays.asList(p3, p4, p1, p5, p2, p6);
        List<Person> actual = sortService.sort(people, "heightIn", "true");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByHeightDesc() {
        List<Person> expected = Arrays.asList(p1, p5, p4, p3, p2, p6);
        List<Person> actual = sortService.sort(people, "heightIn", "false");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByWeightAsc() {
        List<Person> expected = Arrays.asList(p1, p4, p3, p5, p2, p6);
        List<Person> actual = sortService.sort(people, "weightLb", "true");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortByWeightDesc() {
        List<Person> expected = Arrays.asList(p5, p3, p1, p4, p2, p6);
        List<Person> actual = sortService.sort(people, "weightLb", "false");
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSortByUnknownField() {
        sortService.sort(people, "unknown", "false");
    }

    private void assertEquals(List<Person> expected, List<Person> actual) {
        IntStream.range(0, actual.size()).forEach(i -> Assert.assertEquals(expected.get(i), actual.get(i)));
    }
}
