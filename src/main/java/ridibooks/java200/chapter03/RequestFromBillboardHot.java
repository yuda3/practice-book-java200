package ridibooks.java200.chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class RequestFromBillboardHot {
    ArrayList<String> htmls = new ArrayList<>();
    ArrayList<Billboard> billboards = new ArrayList<>();
    boolean isConnection = false;

    public ArrayList<Billboard> getBillboards(){
        return billboards;
    }

    public void getAllHtml(String newUrls) throws Exception {
        htmls.clear();;
        URL url = null;
        try{
            url = new URL(newUrls);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8), 8);
            String line = "";
            while((line = reader.readLine()) != null){
                if(!line.trim().equals("")){
                    htmls.add(line.trim());
                }
            }
            isConnection = true;
        }catch (Exception e){
            isConnection = false;
            System.out.println("Billboard Parsing error!!");
        }
    }

    public String getTimeDate(String newUrls) throws Exception{
        String s = "";
        URL url = null;
        try{
            url = new URL(newUrls);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8), 8);
            String line ="";
            while((line = reader.readLine()) != null){
                if(!line.trim().equals("")){
                    s = line.trim();
                    s = s.substring(0, s.indexOf(">") -1);
                    s = s.substring(0, s.indexOf("\"") +1).trim();
                    break;
                }
            }
            isConnection = true;
        }catch (Exception e){
            isConnection = false;
            System.out.println("Billboard Parsing error!!");
        }
        return s;
    }

    public synchronized void getBillboardData(String msg){
        for (int i = 0; i < htmls.size(); i++) {
            String ss = htmls.get(i);
            if(ss.contains(msg)){
                String rank = ss.substring(ss.indexOf("chart-row--") + "chart-row--".length());
                rank = rank.substring(0, rank.indexOf("js")-1).trim();
                String song = ss.substring(ss.indexOf("Song Hover-") + "Song Hover-".length());
                song = song.substring(0, song.indexOf("\"")).trim();
                int j = 1;
                String imageurl = htmls.get(i + j);
                while (true){
                    if(imageurl.contains("images/pref_images")){
                        break;
                    }else {
                        j++;
                        imageurl = htmls.get( i+ j);
                    }
                }

                imageurl = imageurl.substring(imageurl.indexOf("https://"));
                imageurl = imageurl.substring(0, imageurl.indexOf(".jpg")+ ".jpg".length());
                int k = 1;
                String artisturl = htmls.get(i + j + k);
                while(true){
                    if(artisturl.contains("chart-row__artist")){
                        break;
                    }else {
                        j++;
                        artisturl = htmls.get( i + j + k);
                    }
                }

                artisturl = artisturl.substring(artisturl.indexOf("https://"));
                artisturl = artisturl.substring(0, artisturl.indexOf("\""));
                String artist = artisturl.substring(artisturl.lastIndexOf("/") + 1);
                artist = toArtis(artist);
                int m = 1;
                String lastweek = htmls.get(i + j + k + m);
                while(true){
                    if(lastweek.contains("chart-row__last-week")){
                        break;
                    }else {
                        j++;
                        lastweek = htmls.get(i + j + k + m);
                    }
                }
                int n = 1;
                lastweek = htmls.get(i + j+ k + m + n);
                while(true){
                    if(lastweek.contains("chart-row__value")){
                        break;
                    }else {
                        j++;
                        lastweek = htmls.get(i + j + k + m + n);
                    }
                }
                lastweek = lastweek.substring(lastweek.indexOf(">") + 1);
                lastweek = lastweek.substring(0, lastweek.indexOf("<")).trim();
                Billboard billboard = new Billboard(toInt(rank), replace(song), toInt(__toStr(lastweek)), imageurl, artisturl, artist);
                billboards.add(billboard);

            }
        }
    }


    public void printHtml(){
        for (String html : htmls) {
            System.out.println(html);
        }
    }

    public void printBillboard(){
        for (Billboard billboard : billboards) {
            System.out.println(billboard);
        }
    }

    public String replace(String msg){
        String ss = msg;
        ss = ss.replaceAll("&#39;","");
        ss = ss.replaceAll("&amp;" , "&");
        ss= ss.replaceAll("&quot;", "\"");
        return ss.trim();
    }

    private String __toStr(String lastWeek){
        return lastWeek.contains("--")? 101 + "":lastWeek;
    }

    private int toInt(String msg) {
        return Integer.parseInt(msg == null ? "-1":msg.trim());
    }

    private String toArtis(String msg){
        return msg.replaceAll("-", "");
    }

    public static void main(String[] args) throws Exception {
        RequestFromBillboardHot rfw = new RequestFromBillboardHot();
        String a = "http://www.billboard.com/charts/hot-100";
        String rs = rfw.getTimeDate(a);
        //rs = RestDay.toWantedDay(rs,1);
        System.out.println(rs);
        rfw.getAllHtml(a + rs);
        String str = "<article class=\"chart-row";
        rfw.getBillboardData(str);
        rfw.printBillboard();
    }

}
