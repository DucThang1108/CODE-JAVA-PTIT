
package code.ptit;
import java.util.Scanner;
import java.util.Stack;

public class thuGonDaySo {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();
        while (n-- > 0)
        {
            int x = sc.nextInt();
            if (!st.isEmpty() && (x + st.peek()) % 2 == 0)
                st.pop();
            else
                st.push(x);
        }
        System.out.println(st.size());
    }
}
