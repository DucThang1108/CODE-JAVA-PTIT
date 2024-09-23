
package code.ptitv2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Pair implements Serializable, Comparable<Pair>{
    private int first, second;
    public Pair(int fisrt, int second) {
        this.first = first;
        this.second = second;
    }
    public int getFirst() {
        return first;
    }
    public int getSecond() {
        return second;
    }
    public int compareTo(Pair o) {
        return this.first - o.first;
    }
    public String toString(){
        return "(" + first + ", " + second + ")";
    }
}
public class lietKeCapSo_1 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("DATA.in");
        ObjectInputStream is = new ObjectInputStream(file);
        ArrayList<Pair> a = (ArrayList<Pair>) is.readObject();
        Collections.sort(a);
        for(Pair i : a)
            if(i.getFirst()<i.getSecond())
                System.out.println(i);
    }
}