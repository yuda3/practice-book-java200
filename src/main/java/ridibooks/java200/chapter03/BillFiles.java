package ridibooks.java200.chapter03;

import java.io.*;
import java.util.Date;

public class BillFiles {
    public static void main(String[] args) {
        File f = new File("billboard");
        File[] fd = f.listFiles();
        assert fd != null;
        for (File file : fd) {
            String fname = file.getName();
            String post = fname.substring(fname.lastIndexOf(".") + 1);
            System.out.println("fname = " + post);
            System.out.println(file.getAbsolutePath());
            System.out.println(new Date(file.lastModified()));
            try(BufferedReader bf = new BufferedReader(new FileReader(file.getAbsolutePath()))){
                String msg = "";
                while ((msg = bf.readLine()) != null){
                    System.out.println(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("-----------------------------------------------------------------");
        }
    }
}
