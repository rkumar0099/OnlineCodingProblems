import java.util.*;

public class TwoSumII {
    public static void main(String[] args) {
        //int[] a = new int[]{2, 7, 11, 15};
        int[] a = new int[]{2, 3, 4};
        int s = 0;
        int e = a.length - 1;
        int target = 6;
        int[] res = twoSum(a, s, e, s, e, target);
        System.out.println("Res: " + res[0] + ", " + res[1]);
    }

    public static int[] twoSum(int[] a, int s, int e, int midS, int midE, int t) {
            if (s > e || midS > midE) {
                return new int[]{-1, -1};
            }
            int mid = (midS+midE+1)/2;
            int target = t - a[mid];
            System.out.println("t: " + t + ", Mid: " + a[mid] + ", target: " + target);
            int index = BinarySearch(a, s, e, target, mid);
            if (index > -1) {
                return index > mid ? new int[]{mid+1, index+1} : new int[]{index+1, mid+1};
            }
            int[] res;
            res = twoSum(a, s, e, midS, mid-1, t);
            if (res[0] > -1) {
                return res;
            }
            res = twoSum(a, s, e, mid+1, midE, t);
            return res; 
    }

    public static int BinarySearch(int[] a, int s, int e, int key, int ignore) {
        while(s<=e) {
            int mid = (s+e+1)/2;
            if (a[mid] == key && mid != ignore) {
                return mid;
            } else if (a[mid] < key) {
                s = mid+1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}