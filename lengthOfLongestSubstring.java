package leetcodecn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "skepmelhn";
        System.out.println(new lengthOfLongestSubstring().solve2(s));
    }



     public int fuXi(String s){
        Map map = new HashMap();
        int max= 0;
         for (int i = 0, j=0; j < s.length() ; j++) {
             if (map.containsKey(s.charAt(j))){
                 i = Math.max((int)map.get(s.charAt(j))+1, i);
             }
             max = Math.max(max, j-i+1);
             map.put(s.charAt(j), j);

         }
        return max;
     }







    /*

    滑动窗口解法 优化的

     */
        public int solve2(String s) {

            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);    //取得重复元素的坐标 跳过
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;

        }
    /*
        滑动窗口解法
     */
    public int solve1(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            System.out.println(j);
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

        /*        int max = 0;
        Set set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            ok:
            for (int j = i; j < s.length(); j++) {
               if (set.contains(s.charAt(j))) {
                   set.clear();
                   break ok;
               }
               set.add(s.charAt(j));
               max = Math.max(max, set.size());
            }
        }
        return max;*/
    }




    /*
        暴力破解法
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                if (allUniqe(s.substring(i, j))) max = max > s.substring(i, j).length()? max : s.substring(i, j).length();
            }
        }
        return max;
    }



    private boolean allUniqe(String str){
        Set set = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
}
