/**
 * @author orchard.chang
 * @date 2019-04-10
 * @description: 没意义的一道题，入参是int，然而要越界？照理说编译都通过不了。 有一个方法二，是用x/10和x%10就好。
 */
public class ReverseInteger_7 {
    public int reverse(int x) {

        boolean flag = true;
        if (x < 0) {
            flag = false;
            x = 0 - x;
        }
        try {
            if (x >= 10) {
                String s = new StringBuilder(String.valueOf(x)).reverse().toString();
                if (s.startsWith("0")) {
                    x = Integer.valueOf(s.substring(1));
                } else {
                    x = Integer.valueOf(s);
                }
            }
        } catch (RuntimeException e) {
            return 0;
        }
        if (flag) {
            return x;
        } else {
            return -x;
        }
    }

    public static void main(String[] args) {
        ReverseInteger_7 a = new ReverseInteger_7();
        System.out.println(a.reverse(21));
    }
}
