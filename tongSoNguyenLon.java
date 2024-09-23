
package code.ptitv2;

import java.math.BigInteger;
import java.util.Scanner;

public class tongSoNguyenLon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            System.out.println(a.add(b).toString());
        }
    }
}