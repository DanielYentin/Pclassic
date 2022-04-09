import java.util.*;
public class CactusFarm {
    public static void main(String[] args) {
        int[] initialPattern = {1, 0, 1};
        int[] finalPattern = {1, 1, 1};
        System.out.println(matchable(initialPattern, finalPattern));
    }

    public static boolean matchable(int[] initialPattern, int[] finalPattern) {
        int[] currentWorkingPattern = Arrays.copyOf(initialPattern, finalPattern.length-initialPattern.length);
        Deque<int[]> queue = new ArrayDeque<int[]>(); queue.add(currentWorkingPattern);
        while (!queue.isEmpty()) {
            // loop over all possible stamp positions and try them
            currentWorkingPattern = queue.remove(); 
            for (int i = 0; i <= finalPattern.length-initialPattern.length; i++) { 
                // make a temp array to try out diffrent stamps, add ones that are valid to queue
                int[] newWorkingPattern = Arrays.copyOf(currentWorkingPattern, finalPattern.length); 
                // stamp initial pattern on current working pattern
                if (stamp(initialPattern, i, newWorkingPattern, finalPattern)) {
                    if (Arrays.equals(newWorkingPattern, finalPattern)) {return true;} // if matched to final pattern return true
                    else if (Arrays.equals(newWorkingPattern, currentWorkingPattern)) {} // if nothing has changed dont add to queue
                    //else if () {} // if such a combination already exists in the queue do nothing;
                    else {queue.add(newWorkingPattern);} // otherwise add to queue
                }
            }
        } return false; // if no unqiue combination has worked return false
    }

    
    public static boolean stamp(int[] initialPattern, int start, int[] newWorkingPattern, int[] finalPattern) {
        for (int i = 0; i < initialPattern.length; i++) { 
            if (initialPattern[i] == 1) {newWorkingPattern[start+i] = 1;}
            // 0's are non regainable so if a 1 is placed on top of where a 0 has to be in the final pattern then we can imieaditly prune this branch
            if (newWorkingPattern[start+i] == 1 && finalPattern[start+i] == 0) {return false;} 
        } return true;
    }
}