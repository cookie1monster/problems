package org.problems.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReaderExample {

    public static void main(String[] args) {
        Stream<String> stream = CSVReader.getStream("/Users/vito/Downloads/exmpl.csv");
        List<Exmpl> exmpls = stream.map(str -> {
            String[] spl = str.split(";");
            return new Exmpl(spl[0], Integer.parseInt(spl[1]), spl[2], spl[3]);
        }).collect(Collectors.toList());

        System.out.println(exmpls);
    }
}

class Exmpl {
    String s1;
    int i1;
    String s2;
    String s3;

    public Exmpl(final String s1, final int i1, final String s2, final String s3) {
        this.s1 = s1;
        this.i1 = i1;
        this.s2 = s2;
        this.s3 = s3;
    }
}