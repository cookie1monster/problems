package com.zillow.services;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.zillow.data.Person;

public class SortService {

    private static final String DESC = "Desc";
    private static final String ASC = "Asc";
    private final Map<String, Comparator<Person>> comparatorMap;

    public SortService() {
        comparatorMap = createComparatorMap();
    }

    public List<Person> sort(Iterable<Person> people, String sortField, String ascending) {
        List<Person> peopleList = new ArrayList<>();
        people.forEach(peopleList::add);

        Comparator<Person> comparator = getComparator(sortField.toLowerCase(), ascending.toLowerCase());
        peopleList.sort(comparator);

        return peopleList;
    }

    private Comparator<Person> getComparator(String sortField, String ascending) {
        Comparator<Person> comparator;
        if ("false".equals(ascending) || "0".equals(ascending))
            comparator = comparatorMap.get(sortField + DESC);
        else
            comparator = comparatorMap.get(sortField + ASC);

        if (comparator == null)
            throw new IllegalArgumentException(String.format("Comparator for field '%s' doesn't exist!", sortField));

        return comparator;
    }

    private Map<String, Comparator<Person>> createComparatorMap() {
        Map<String, Comparator<Person>> comparatorMap = new HashMap<>();
        addComparators("ssn", (Function<Person, String>) Person::getSsn, comparatorMap);
        addComparators("firstname", (Function<Person, String>) Person::getFirstName, comparatorMap);
        addComparators("lastname", (Function<Person, String>) Person::getLastName, comparatorMap);
        addComparators("heightin", (Function<Person, Double>) Person::getHeightIn, comparatorMap);
        addComparators("weightlb", (Function<Person, Double>) Person::getWeightLb, comparatorMap);
        addComparators("dateofbirth", (Function<Person, Date>) Person::getDateOfBirth, comparatorMap);
        return Collections.unmodifiableMap(comparatorMap);
    }

    private void addComparators(String field, Function ref, Map<String, Comparator<Person>> comparatorMap) {
        comparatorMap.put(field + DESC, comparing(ref, nullsLast(reverseOrder())));
        comparatorMap.put(field + ASC, comparing(ref, nullsLast(naturalOrder())));
    }
}
