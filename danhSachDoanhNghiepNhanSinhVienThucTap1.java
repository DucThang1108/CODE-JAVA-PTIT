
package code.ptitv2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class danhSachDoanhNghiepNhanSinhVienThucTap1 {

    static class Company {

        String id;
        String name;
        int slot;

        public Company(String name, String fullName, int numberOfStudent) {
            this.id = name;
            this.name = fullName;
            this.slot = numberOfStudent;
        }

        public int getSlot() {
            return slot;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return id + " "
                    + name + " "
                    + slot;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Company> companies = new ArrayList<>();
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String name = sc.nextLine();
            String fullName = sc.nextLine();
            int numberOfStudent = Integer.parseInt(sc.nextLine());
            companies.add(new Company(name, fullName, numberOfStudent));
        }
        companies.sort(Comparator.comparing(Company::getSlot).reversed()
                .thenComparing(Company::getId));
        for (Company c : companies) {
            System.out.println(c);
        }
    }
}