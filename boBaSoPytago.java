
package code.ptitv2;

import java.util.Arrays;
import java.util.Scanner;

public class boBaSoPytago {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Số lượng bộ test
        while (T-- > 0) {
            int N = scanner.nextInt(); // Số lượng phần tử trong dãy A[]
            long[] A = new long[N]; // Dãy số A[]
            
            // Đọc dãy số A[]
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextLong();
            }
            
            // Sắp xếp dãy số A[] theo thứ tự tăng dần
            Arrays.sort(A);
            
            // Sử dụng thuật toán "2-pointer" để kiểm tra
            boolean found = false;
            for (int i = 0; i < N; i++) {
                long a = A[i];
                int left = 0;
                int right = N - 1;
                while (left < right) {
                    long b = A[left];
                    long c = A[right];
                    long sum = b * b + c * c;
                    if (sum == a * a) {
                        found = true;
                        break;
                    } else if (sum < a * a) {
                        left++;
                    } else {
                        right--;
                    }
                }
                if (found) {
                    break;
                }
            }
            
            // In kết quả
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
