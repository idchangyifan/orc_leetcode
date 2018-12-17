/**
 * @auther orchard.chang
 * @date 2018-12-17
 * @description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * 思路：这道题，看上来很简单，可以很容易的写出O（m+n）的解法。但是这样很蠢，毕竟人家有排好序的数组，显然应该往二分查找的思路去靠。
 * 题目要求找中位数，首先得知道啥是中位数：Dividing a set into two equal length subsets, that one subset is always greater than the other.
 * 那么我们将数组A和数组B分别分成两个部分，再做一个组合，记为左边部分和右边部分。
 *       left_part          |        right_part
 * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
 * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
 * 如果可以保证：
 * len(left_part)=len(right_part)
 * max(left_part)≤min(right_part)
 * 即：
 * i+j=m−i+n−j (or:m−i+n−j+1)   注：这里的or条件是当m+n为基数。这里其实可以发现，j=(m+n)/2-i == (m+n+1)/2-i。（+1是为了保证m+n在为基数下的正确性，但即便m+n是偶数，也不影响结果）
 * B[j−1]≤A[i] and A[i−1]≤B[j]
 * 所以，只需要用二分查找，找出i，保证上述条件并做好边界检验即可找到中位数为：
 * max(A[i−1],B[j−1]), when m+n is odd
 * (max(A[i-1],B[j-1])+min(A[i],B[j]))/2, when m+n is even
 *
 * 注：边界条件其实就是i==0||j==0||i==m||j==n
 *
 * 再注：由于j=(m+n+1)/2-i,为了保证j始终大于等于0，所以要假设n>m，这将在代码的开始部分作出初始化操作。
 *
 * 再再注：这道题是典型的数学分析胜过代码实现，理解这类问题，一定要拿起笔自己多想一想，把数学问题想通了，实现代码就是分分钟的问题了。
 *
 * 再再再注：个人认为公司面试笔试不会出这种变态的问题，一般不会有人可以在第一次遇到这种问题就能完美解答的。能完美解答这类问题的，只能说明他刷过LeetCode而且记忆力很好。。。
 *
 * 再再再再注：思想就是这样了，然而排名并不高，看了下排名在前的代码，总体思路是不变的，然而用了一些小tricks，这里就不详细展开了。
 */
public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //初始化操作，确保n>=m，使得j的值始终大于等于0
        if (n < m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        //开始二分查找i的初始区间为[0,m]
        int start = 0;
        int end = m;
        int i = 0;
        int j = 0;
        while (start <= end) {
            i = (start + end) / 2;
            j = (m + n + 1) / 2 - i;
            //终止条件：
            if ((j == 0 || i == m || nums2[j - 1] <= nums1[i]) && (i == 0 || j == n || nums1[i - 1] <= nums2[j])) {
                //奇数
                if ((m + n) % 2 == 1) {
                    return Math.max(i == 0 ? -999999.0 : nums1[i - 1], j == 0 ? -999999.0 : nums2[j - 1]);
                } else {
                    return (Math.max(i == 0 ? -999999.0 : nums1[i - 1], j == 0 ? -999999.0 : nums2[j - 1]) + Math.min(i == m ? 999999.0 : nums1[i], j == n ? 999999.0 : nums2[j])) / 2.0;
                }
            }
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                start = i + 1;
                continue;
            }
            if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                end = i - 1;
            }
        }
        return 0.0;
    }


    public static void main(String[] args) {
        MedianOfTwoSortedArrays_4 a = new MedianOfTwoSortedArrays_4();
        int[] b = {1, 2};
        int[] c = {3, 4};
        System.out.println(a.findMedianSortedArrays(b, c));
    }
}
