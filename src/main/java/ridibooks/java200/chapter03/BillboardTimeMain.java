package ridibooks.java200.chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class BillboardTimeMain {
    public static void main(String[] args) throws Exception {
        String newUrls = "https://www.billboard.com/charts/hot-100/";
        String s = "";
        URL url = null;
        try{
            url  = new URL(newUrls);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8), 8);
            String line = "";
            while((line = reader.readLine()) != null){
                if((!line.trim().equals(""))){
                    if(line.trim().contains("<time datetime =")){
                        s = line.trim();
                        s = s.substring(0, s.indexOf(">") -1);
                        s = s.substring(0, s.indexOf("\"") +1).trim();
                        break;

                    }
                }
            }
        }catch (Exception e){
            System.out.println("Billboard Parsing error");
        }
        System.out.println(s);
    }

}
