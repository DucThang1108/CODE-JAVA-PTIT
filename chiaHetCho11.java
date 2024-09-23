
package code.ptitv2;

import java.util.Scanner;

public class chiaHetCho11 {

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        scanner.nextLine(); 

        while (T-- > 0) {
            String N = scanner.nextLine(); 

            int oddSum = 0;
            int evenSum = 0;
            for (int i = 0; i < N.length(); i++) {
                int digit = Character.getNumericValue(N.charAt(i));
                if (i % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }

            int diff = Math.abs(oddSum - evenSum);
            if (diff % 11 == 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}