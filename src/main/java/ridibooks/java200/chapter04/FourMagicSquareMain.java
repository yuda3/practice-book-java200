package ridibooks.java200.chapter04;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class FourMagicSquareMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JSONArray ja = new JSONArray();
        JSONArray jaresult = new JSONArray();

        JSONObject jo = new JSONObject();
        JSONObject j1 = new JSONObject();
        JSONObject j2 = new JSONObject();
        JSONArray ja1 = new JSONArray();
        j1.put("induId", "bank");
        j1.put("indunam", "kane");
        j2.put("commdityId","deposit");

        ja1.add(j2);

        jo.put("id", 1009);
        jo.put("cpsiteId", 1009);
        jo.put("cpsiteName", 1009);
        jo.put("industry", j1);
        jo.put("", 1009);
        jo.put("id", 1009);
        jo.put("id", 1009);
        ja.add(jo);
        ja.add(ja1);
        ja.add(jo);
        ja.add(ja1);
        jaresult.add(ja);
        System.out.println(jaresult);
    }
}
