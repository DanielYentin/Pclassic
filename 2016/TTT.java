import java.util.*;
public class TTT {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }
    public static ArrayList<Integer> solve(int hyp) {
        ArrayList<Integer> triplets = new ArrayList<Integer>();
        for (int leg1 = 1; leg1 < hyp; leg1++) {
            double leg2 = Math.sqrt(hyp*hyp - leg1*leg1);
            if (leg2%1 == 0) {
                triplets.add(leg1); triplets.add((int)leg2);
            }
        }
        return triplets;
    }
 }
