import java.util.HashMap;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class longestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        // HashSet<Character> set = new HashSet<>();
        // for(int i = 0; i < 5; i++) {
        //     set.add((char)(i + 'a'));
        // }
        // char ch = 'a';
        // System.out.println(set.contains(ch));
        // // System.out.println((char)(1 + 'a'));
        // for(char i : set) {
        //     System.out.print(i + " ");
        // }
        // // Iterator itr = set.keySet().iterator();

        int longestKSubStringSize = longestkSubstr("aabacbebebe", 3);
        System.out.println(longestKSubStringSize);
    } 
    
    public static int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        int maxLen = 0;
        
        while(j < n) {
            // calculation
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if(map.size() < k) {
                j++;
            } else if(map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else if(map.size() > k) {
                while(map.size() > k) {
                    char chI = s.charAt(i);
                    map.put(chI, map.get(chI) - 1);
                    if(map.get(chI) == 0) {
                        map.remove(chI);
                    }
                    i++;
                }
                j++;
            }
        }
        
        return maxLen == 0 ? -1 : maxLen;
    }
}
