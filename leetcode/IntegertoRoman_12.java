/**
 * @author orchard.chang
 * @date 2019-04-18
 * @description:
 */
public class IntegertoRoman_12 {
    public  static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int numOfM = 0, numOfD = 0, numOfC = 0, numOfL = 0, numOfX = 0, numOfV = 0, numOfI = 0;
        //M
        for (int i = 0; i < num / 1000; i++) {
            result.append('M');
        }
        num %= 1000;
        if (num >= 900) {
            result.append("M");
            result.insert(result.lastIndexOf("M"), 'C');
            num %= 900;
        }

        //D
        for (int i = 0; i < num / 500; i++) {
            result.append('D');
        }
        num %= 500;
        if (num >= 400) {
            result.append("D");
            result.insert(result.lastIndexOf("D"), "C");
            num %= 400;
        }

        //C
        for (int i = 0; i < num / 100; i++) {
            result.append("C");
        }
        num %= 100;
        if (num >= 90) {
            result.append("C");
            result.insert(result.lastIndexOf("C"), "X");
            num %= 90;
        }

        //L
        for (int i = 0; i < num / 50; i++) {
            result.append("L");
        }
        num %= 50;
        if (num >= 40) {
            result.append("L");
            result.insert(result.lastIndexOf("L"), "X");
            num %= 40;
        }

        //X
        for (int i = 0; i < num / 10; i++) {
            result.append("X");
        }
        num %= 10;
        if (num == 9) {
            result.append("X");
            result.insert(result.lastIndexOf("X"), "I");
            num %= 9;
        }

        //V
        for (int i = 0; i < num / 5; i++) {
            result.append("V");
        }
        num %= 5;
        if (num == 4) {
            result.append("V");
            result.insert(result.lastIndexOf("V"), "I");
            num %= 4;
        }

        //I
        for (int i = 0; i < num; i++) {
            result.append("I");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
