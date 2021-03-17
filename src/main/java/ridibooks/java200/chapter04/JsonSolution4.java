package ridibooks.java200.chapter04;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonSolution4 {
    private static final String pathname = "test.csv";
    public static void main(String[] args) throws IOException {
        CsvMapper mapper = new CsvMapper();
        // ヘッダなし
        CsvSchema schema = mapper.schemaFor(JsonPojo.class);

        Path path = Paths.get(pathname);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            MappingIterator<JsonPojo> it = mapper.readerFor(JsonPojo.class).with(schema).readValues(br);
            List<JsonPojo> userList = it.readAll();
            userList.stream().flatMap(c -> Stream.of(c.getCp_id())).forEach(System.out::println);
            Map<String, List<JsonPojo>> map = userList.stream().sorted(Comparator.comparing(JsonPojo::getLogin_info_no)).collect(Collectors.groupingBy(JsonPojo::getCp_id));
            Set<String> setKey = new TreeSet<>();
            for (Object o : map.keySet()) {
                setKey.add((String) o);
            }
        }
    }
}
