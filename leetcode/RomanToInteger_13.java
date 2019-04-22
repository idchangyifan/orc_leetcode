/**
 * @author orchard.chang
 * @date 2019-04-19
 * @description:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInteger_13 {
    public static int romanToInt(String s) {
        int result = 0;
        char[] array = s.toCharArray();
        int i = 0;
        while (i < array.length) {
            if (array[i] == 'C') {
                if ((i + 1 < array.length) && array[i + 1] == 'M') {
                    i += 2;
                    result += 900;
                } else if ((i + 1 < array.length) && array[i + 1] == 'D') {
                    i += 2;
                    result += 400;
                } else {
                    i++;
                    result += 100;
                }

            } else if (array[i] == 'M') {
                i++;
                result += 1000;
            } else if (array[i] == 'D') {
                i++;
                result += 500;
            } else if (array[i] == 'X') {
                if ((i + 1 < array.length) && array[i + 1] == 'L') {
                    i += 2;
                    result += 40;
                } else if ((i + 1 < array.length) && array[i + 1] == 'C') {
                    i += 2;
                    result += 90;
                } else {
                    i++;
                    result += 10;
                }
            } else if (array[i] == 'L') {
                i++;
                result += 50;
            } else if (array[i] == 'I') {
                if ((i + 1 < array.length) && array[i + 1] == 'X') {
                    i += 2;
                    result += 9;
                } else if ((i + 1 < array.length) && array[i + 1] == 'V') {
                    i += 2;
                    result += 4;
                } else {
                    i++;
                    result += 1;
                }
            } else if (array[i] == 'V') {
                i++;
                result += 5;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
