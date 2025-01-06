import java.util.*;

public class minMovesToMoveAllBallsToOneBox {

    /* Brute Force Start -- Which I came up with initially */

    public int[] minOperations(String boxes) {
        // <Character Number (from string), Index of the Character Number>
        HashMap<Integer, Character> map = new HashMap<>();
        populateMap(map, boxes);

        for(Map.Entry<Integer, Character> e: map.entrySet()) {
            System.out.println(e.getKey() + ", " + e.getValue());
        }

        int ans[] = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++) {
            ans[i] = findTotalMoves(map, i);
        }

        return ans;
    }

    private int findTotalMoves(HashMap<Integer, Character> map, int i) {
        int count = 0;
        for(Map.Entry<Integer, Character> e: map.entrySet()) {
            count += Math.abs(i - e.getKey());
        }
        return count;
    }

    private void populateMap(HashMap<Integer, Character> map, String boxes) {
        for(int i = 0; i < boxes.length(); i++) {
            char ch = boxes.charAt(i);
            if(ch == '1') {
                map.put(i, ch);
            }
        }
    }

    /* Brute Force Ends -- Which I came up with initially */

    /* Brute Force Soluton by Leetcode Editorial */

    
}
