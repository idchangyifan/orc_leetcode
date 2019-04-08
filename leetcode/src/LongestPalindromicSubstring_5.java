/**
 * @author Orchard Chang
 * @date 2019/4/8 0008 22:39
 * @description 最长回文子串，没啥好说的，动态规划，代码一目了然。有一个Manacher's algorithm算法，可以只用o(n)的时间，然而太tricky了，所以有兴趣再看
 */
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int ii = 0;
        int jj = 0;
        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        //i开始j结尾
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i > jj - ii) {
                        ii = i;
                        jj = j;
                    }
                }
            }
        }
        return s.substring(ii, jj + 1);
    }






}
