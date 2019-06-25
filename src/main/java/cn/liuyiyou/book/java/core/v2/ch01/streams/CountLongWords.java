package cn.liuyiyou.book.java.core.v2.ch01.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {

    static String RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(RESOURCE_PATH + "/gutenberg/alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12)
                count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}