package ridibooks.java200.chapter04;

import java.io.*;
import java.util.*;

public class Solution2 {
    private static final String pathname = "test.csv";
    private static final String pathOutName = "testOut.csv";

    public static void main(String[] args) {

        List<String[]> ret = new ArrayList<>();
        Set<String> name = new TreeSet<>();
        try {
            File f = new File(pathname);
            BufferedReader br = new BufferedReader(new FileReader(f));

            String line = "";
            List<String> tmpList;
            Map<Integer, String[]> map = new HashMap<>();
            while((line = br.readLine()) != null) {

                String[] array = line.split(",");
                tmpList = new ArrayList<>(Arrays.asList(array));
                name.add(array[0]);
                for (int i = 0; i < 6; i++) {
                    tmpList.remove(5);
                }
                ret.add(array);
            }
            br.close();
            Comparator<List<String>> getListComparator = Comparator.comparingInt(x -> Integer.parseInt(x.get(1)));
            Comparator<List<String>> getComparing = Comparator.comparing(String::valueOf);
            int i = 0;
            for (String[] strings : ret) {
                map.put(i,strings);
                i++;
            }
            for (Integer integer : map.keySet()) {
                System.out.println(Arrays.toString(map.get(integer)));
            }
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(pathOutName)));
//            for(List<String> l: ret) {
//                pw.println(String.join(",", l));
//            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
