package ridibooks.java200.chapter4;

import java.util.Scanner;

public class OddMagicSquareMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("ODD NUMBER");
        OddMagicSquare odd = new OddMagicSquare(n);
        odd.make();
        odd.print();
    }
}
