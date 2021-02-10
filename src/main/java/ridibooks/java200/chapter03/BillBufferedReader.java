package ridibooks.java200.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;

public class BillBufferedReader {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("billboard\\bill.txt"))){
            String msg ="";
            while((msg = br.readLine())!= null){
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
