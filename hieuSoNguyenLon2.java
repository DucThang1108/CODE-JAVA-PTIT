package code.ptit;

import java.math.BigInteger;
import java.util.Scanner;


public class hieuSoNguyenLon2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();
        BigInteger C = A.subtract(B);
        System.out.println(C.toString());
    }
}
