
package code.ptitv2;
import java.util.ArrayList;
import java.util.Scanner;
public class quanLyKhoXangDau{
       private static class DonHang{
        private String id,hangSanXuat;
        private long sl,donGia,thue,thanhTien;
        private double phanTramThue;
                
        public DonHang(String id, long sl) {
            this.id = id;
            this.sl = sl;
            if(this.id.startsWith("X")){
                this.phanTramThue = 0.03;
                this.donGia = 128000;
            }else if(this.id.startsWith("D")){
                this.phanTramThue = 0.035;
                this.donGia = 11200;
            }else{
                this.phanTramThue = 0.02;
                this.donGia = 9700;
            }
            if(this.id.endsWith("TN")){
                this.hangSanXuat = "Trong Nuoc";
                this.phanTramThue = 0;
            }else if(this.id.endsWith("BP")){
                this.hangSanXuat = "British Petro";
            }else if(this.id.endsWith("ES")){
                this.hangSanXuat = "Esso";
            }else if(this.id.endsWith("SH")){
                this.hangSanXuat = "Shell";
            }else if(this.id.endsWith("CA")){
                this.hangSanXuat = "Castrol";
            }else this.hangSanXuat = "Mobil";
            this.thue = (long) (this.sl*this.donGia *this.phanTramThue);
            this.thanhTien = this.sl*this.donGia +this.thue;
        }
        
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<DonHang> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new DonHang(sc.next(),sc.nextLong()));
        }
        for(DonHang tmp : ds)
            System.out.printf("%s %s %d %d %d\n",tmp.id,tmp.hangSanXuat,tmp.donGia,tmp.thue,tmp.thanhTien);
           
    }
}
