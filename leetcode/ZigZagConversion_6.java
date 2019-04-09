import java.util.ArrayList;
import java.util.List;

/**
 * @author orchard.chang
 * @date 2019-04-09
 * @description:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 分析：首先，对于len <= numRows || numRows == 1这两种情况，直接返回s，无异议。
 * 其次，关键在于弄建立数据结构List<StringBuilder>。List中每个元素代表一行，每一行是一个StringBuilder。对s进行逐个字母的遍历，依次添加进当前行中。
 * 最后，要弄清当前行的变化规则：当为首行或者末行的时候，当前行的变化要反转，具体做法是设立一个flag，当前行为1时，下一个当前行应+1，当前行为numRows时，下一个当前行应-1。
 * 时间复杂度：O(N)，beats 93.94%
 */
public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= numRows || numRows == 1) {
            return s;
        }
        //list中每个元素代表一行
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            list.add(sb);
        }
        //初始化当前行为第一行
        int currentRow = 1;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            //当前行为首行或者末行的时候，加减规则要反转
            if (currentRow == numRows) {
                flag = false;
            } else if (currentRow == 1) {
                flag = true;
            }
            //将s中的当前字母添加到其对应的当前行
            list.get(currentRow - 1).append(s.charAt(i));
            //根据flag决定下一个当前行应该是加或者减
            if (flag) {
                currentRow++;
            } else {
                currentRow--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(list.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion_6 a = new ZigZagConversion_6();
        System.out.println(a.convert("PAYPALISHIRING", 4));
    }
}
