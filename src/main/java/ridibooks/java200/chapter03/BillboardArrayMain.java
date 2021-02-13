package ridibooks.java200.chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class BillboardArrayMain {
    public static void main(String[] args) throws Exception {
        ArrayList<String> bills = new ArrayList<>();
        String newUrls = "https://www.billboard.com/charts/hot-100/";
        URL url = null;
        try{
            url  = new URL(newUrls);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8), 8);
            String line = null;
            while((line = reader.readLine()) != null){
                if(!line.trim().equals("")){
                    bills.add(line.trim());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (String bill : bills) {
            System.out.println(bill);
        }
    }
}
