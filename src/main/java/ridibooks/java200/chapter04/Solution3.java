package ridibooks.java200.chapter04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution3 {
    private static final String pathname = "test.csv";

    public static void main(String[] args) {
        // csvファイル読込
        File csv = new File(pathname);
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {

            // 先頭行はカラム名
            final String[] name = br.readLine().split(",");
            List<String> jsonRecords = new LinkedList<>();

            loop: while (true) {

                // 全行取得
                String record = br.readLine();
                if (record == null) break loop;
                String[] column = record.split(",");

                // {"header0":"column0","header1":"column1"}という形に成形
                String jsonRecord = "{" + IntStream.range(0, name.length).boxed()
                        .map(v -> "\"" + name[v] + "\":\"" + column[v] + "\"")
                        .collect(Collectors.joining(",")) + "}";

                jsonRecords.add(jsonRecord);
            }

            // [{"header0":"0","header1":"1"},{"header0":"2","header1":"3"}]という形に接続
            String json = "[" + String.join(",", jsonRecords) + "]";

            System.out.println(json);

        } catch (IOException e) {

        }
    }
}
