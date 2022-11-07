import java.util.*;


public class FLPosSortedArray { 

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 8, 8, 8, 10};
        int t = 8;
        int s = 0;
        int e = arr.length - 1;
        // func BinarySearch returns the min or max index of the target
        // type = 0, return min, type = 1, return max
        int min = BinarySearch(s, e, arr, t, 0);
        int max = BinarySearch(s, e, arr, t, 1);
        System.out.println("Min: " + min + ", Max: " + max);
    }

    public static int BinarySearch(int s, int e, int[] arr, int t, int type) {
        int flag = 0;
        int value = -1;
        if (type == 0) {
            value = 10000000;
        } else if (type == 1) {
            value = 0;
        } else {
            return value;
        } 

        while(s <= e) {
            int mid = (s+e+1)/2;
            if (t == arr[mid]) {
                flag = 1;
                if (mid < value && type == 0) {
                    value = mid;
                    e = mid - 1;
                } else if (mid > value && type == 1) {
                    value = mid;
                    s = mid + 1;
                }
            } else if (t > arr[mid]) {
                s = mid + 1;
            } else if (t < arr[mid]) {
                e = mid - 1;
            }
        }
        if (flag == 1) {
            return value;
        }
        return -1;
    }
}