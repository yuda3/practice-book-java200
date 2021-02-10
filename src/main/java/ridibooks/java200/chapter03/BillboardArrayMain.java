package ridibooks.java200.chapter03;

import java.util.ArrayList;

public class BillboardArrayMain {
    public static void main(String[] args) {
        ArrayList<Billboard> bills = new ArrayList<>();
        bills.add(new Billboard(1, "Despacito", 1, "https://www.billboard.com/images/pref_images/q61808osztw.jpg", "luis fonsi"));
        bills.add(new Billboard(2, "That's What I Like", 2, "https://www.billboard.com/images/pref_images/q59725qvpol.jpg", "bruno mars"));
        bills.add(new Billboard(3, "I am the one", 3, "https://www.billboard.com/images/pref_images/q64532p164ztw.jpg", "jd khaled"));

        System.out.println(bills.size());
        showAbout(bills.get(0));
        bills.remove(1);
        System.out.println("bills.size() = " + bills.size());
        System.out.println("--------------------");
        for (Billboard bill : bills) {
            showAbout(bill);
        }
    }

    private static void showAbout(Billboard bb) {
        String sf = String.format("%d, %s, %d, %s, %s", bb.getRank(), bb.getSong(), bb.getLastWeek(), bb.getImageSrc(), bb.getArtist());
        System.out.println(sf);
    }
}
