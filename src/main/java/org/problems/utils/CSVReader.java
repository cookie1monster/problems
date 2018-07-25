package org.problems.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CSVReader {

    public static Stream<String> getStream(String fileName) {
        try {
            return Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Stream<String> getStream1(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            /////

            return stream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
