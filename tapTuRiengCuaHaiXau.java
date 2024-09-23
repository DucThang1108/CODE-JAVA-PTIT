
package code.ptit;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class tapTuRiengCuaHaiXau {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0)
        {
            String s1 = sc.nextLine().trim();
            String s2 = sc.nextLine().trim();
            List<String> a = Arrays.asList(s1.split("\\s+"));
            List<String> b = Arrays.asList(s2.split("\\s+"));
            Set<String> s = new TreeSet<>();
            for (String i : a)
                if (!b.contains(i))
                    s.add(i);
            for (String i : s)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

  
