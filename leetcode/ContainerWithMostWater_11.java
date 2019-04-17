/**
 * @author orchard.chang
 * @date 2019-04-17
 * @description:Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * 思路：两个因素影响这个max值，一个是短板，一个是板子间距。设置两个指针，头尾各1个，开始向里夹逼。夹逼的策略是：选择矮的那一端开始向内-1或+1，因为对高的板子而言，
 * 向内是没有意义的，因为max值取决于短板。
 * 时间复杂度：o（n）
 */
public class ContainerWithMostWater_11 {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }

}
