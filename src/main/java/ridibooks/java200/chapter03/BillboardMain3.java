package ridibooks.java200.chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class BillboardMain3 {
    public static void main(String[] args) throws Exception {
        String newUrls = "https://www.billboard.com/charts/hot-100/";
        URL url = null;
        try{
            url = new URL(newUrls);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8), 8);
            String line = null;
            while((line = reader.readLine()) != null){
                if(!line.trim().equals("")){
                    System.out.println(line.trim());
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
