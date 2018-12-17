import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: orchard.chang
 * @Date: 2018/12/11
 * @Description:
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * 思路：只遍历1次，用i、j两个指针，j在前，i在后。当出现重复字符的时候，i直接更新状态为j+1。ans=j-i+1，每次循环取当前ans与之前ans的最大值即可。
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    /**
     * 这里是利用hashmap来保存每个字符在String s中的序号。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            ans = Math.max(j - i + 1, ans);
            map.put(s.charAt(j), j);
        }
        return ans;
    }


    /**
     * 由于所有的字符ascii也就128个，所以可以用一个128位的数组替代hashmap会更快，第N位就代表ascii码为N的字符。（这里有点儿类似“桶排序”的思想）
     * 然而我错了，本以为这特么可以更快，然而并不快。因为这里i和j不出意外的话都访问了两次S中的字符。不如hashmap的方法高效。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] charmap = new int[256];
        int ans = 0, n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, charmap[s.charAt(j)]);
            ans = Math.max(j - i + 1, ans);
            charmap[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(111);
    }

}
