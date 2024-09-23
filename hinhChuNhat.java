
package code.ptit;

import java.util.Scanner;


public class hinhChuNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        if(a <= 0 || b <= 0)
            System.out.println(0);
        else
            System.out.printf("%d %d", (a + b) << 1, a * b);
    }
}
