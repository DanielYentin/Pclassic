import java.util.*;
public class TTT {
    public static void main(String[] args) {
		System.out.println(solve(5));
		System.out.println(solve(25));
        System.out.println(solve(3));
    }
    public static ArrayList<Integer> solve(int hyp) {
        ArrayList<Integer> triplets = new ArrayList<Integer>();
        for (int a = 1; a < hyp; a++) {
            double b = Math.sqrt(hyp*hyp - a*a);
            if (b%1 == 0) {
                triplets.add(a); triplets.add((int)(b));
            }
        }
        return triplets;
    }
 }
