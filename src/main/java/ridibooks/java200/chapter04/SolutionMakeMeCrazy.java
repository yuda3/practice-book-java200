package ridibooks.java200.chapter04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionMakeMeCrazy {
    private static final String pathname = "test.csv";
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            File file = new File(pathname);
            br = new BufferedReader(new FileReader(file));
            String line;
            String[] data;
            String name = "";
            List<String[]> tmpList = new ArrayList<>();
            List<List<String[]>> data1 = new ArrayList<>();
            Comparator<List<String>> getListComparator = Comparator.comparingInt(x -> Integer.parseInt(x.get(1)));
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                tmpList.add(data) ;
                data1.add(tmpList);
            }
            int j = 0;
            for(int i = 0; i < data1.size(); i++){
                List<String[]> strings = data1.get(j);
                String[] strings2 = strings.get(j);
                name = strings2[0];
                StringBuilder sb = new StringBuilder();
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                StringBuilder sb4 = new StringBuilder();
                StringBuilder sb5 = new StringBuilder();
                StringBuilder sb6 = new StringBuilder();
                StringBuilder sb7 = new StringBuilder();
                StringBuilder sb8 = new StringBuilder();
                StringBuilder sb9 = new StringBuilder();
                StringBuilder sb10 = new StringBuilder();
                StringBuilder sb11 = new StringBuilder();
                for (String[] strings1 : strings) {
                    if (name.equals(strings1[0])) {
                        j++;
                        sb.append(strings1[1]);
                        sb.append("|");
                        sb1.append(strings1[2]);
                        sb1.append("|");
                        sb2.append(strings1[3]);
                        sb2.append("|");
                        sb3.append(strings1[4]);
                        sb3.append("|");
                        sb4.append(strings1[5]);
                        sb4.append("|");
                        sb5.append(",");
                        sb5.append("");
                        sb6.append("");
                        sb6.append(",");
                        sb7.append("");
                        sb7.append(",");
                        sb8.append("");
                        sb8.append(",");
                        sb9.append("");
                        sb9.append(",");
                        sb10.append(strings1[11]);
                        sb10.append("|");
                        sb11.append(strings1[12]);
                        sb11.append("|");
                    }else{
                        continue;
                    }
                }

                System.out.println(
                        name + "," + sb.toString() + ",|" + sb1.toString() + ",|" + sb2.toString() + ",|" + sb3.toString() + ",|"
                                + sb4.toString() + "," + sb5.toString() + sb6.toString() + sb7.toString()
                                + sb8.toString() + sb9.toString() + ",|"  + sb10.toString() + ",|" + sb11.toString()
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
