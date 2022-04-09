import java.util.*;
public class PompousPeacocks {
    public static void main(String[] args) {
        ArrayList<int[]> peacocks = new ArrayList<int[]>();
        peacocks.add(new int[] {0, 1});
        peacocks.add(new int[] {1, 2});
        System.out.println(unbeatable(peacocks));
    }
	
    public static int unbeatable(ArrayList<int[]> peacocks) { // find both peacocks and keep track of second one by moving its index -1 every time you remove a pecock
        // find peacock with largest vibrance
        int maxVIndex = 0;
        for (int p = 0; p < peacocks.size(); p++) {
            if(peacocks.get(p)[0] > peacocks.get(maxVIndex)[0]) {
                maxVIndex = p;
            }
        }
        
        //remove all pecocks with lower vibrance and confidence
        int maxV = peacocks.get(maxVIndex)[0]; int currentC = peacocks.get(maxVIndex)[1];
        int size = peacocks.size();
        for (int p = 0; p < size; p++) {
            if ((maxV > peacocks.get(p)[0] && currentC >= peacocks.get(p)[1]) || (maxV >= peacocks.get(p)[0] && currentC > peacocks.get(p)[1])) {
                peacocks.remove(p); p--; size--;
            }
        }
        
        // find peacock with largest confidence
        int maxCIndex = 0;
        for (int p = 0; p < peacocks.size(); p++) {
            if(peacocks.get(p)[1] > peacocks.get(maxCIndex)[1]) {
                maxCIndex = p;
            }
        }
        
        //remove all pecocks with lower vibrance and confidence
        int maxC = peacocks.get(maxCIndex)[1]; int currentV = peacocks.get(maxCIndex)[0];
        size = peacocks.size();
        for (int p = 0; p < size; p++) {
            if ((maxC > peacocks.get(p)[1] && currentV >= peacocks.get(p)[0]) || (maxC >= peacocks.get(p)[1] && currentV > peacocks.get(p)[0])) {
                peacocks.remove(p); p--; size--;
            }
        }
        
        //return # of remaing peacocks
        return peacocks.size();
    }
}
