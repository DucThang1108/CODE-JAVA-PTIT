
package code.ptitv2;

import java.math.BigInteger;
import java.util.Scanner;

public class tongSoNguyenLon2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        System.out.println(a.add(b).toString());
    }
}