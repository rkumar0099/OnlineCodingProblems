import java.util.*;

public class RotatedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 0, 1};
        int s = 0;
        int e = arr.length - 1;
        int pivot = findPivot(s, e, arr, arr[0]);
        System.out.println(pivot);

        
        int t = 2;
        int a1 = binarySearch(0, pivot, arr, t);
        int a2 = -1;
        if (pivot + 1 < arr.length) {
            a2 = binarySearch(pivot + 1, arr.length - 1, arr, t);
        }
        if (a1 != -1 || a2 != -1) {
            System.out.println(true);
        }
    }

    public static int binarySearch(int s, int e, int[] arr, int t) {
        while(s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == t) {
                return mid;
            } else if (t < arr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static int findPivot(int s, int e, int[] arr, int key) {
        int max = 0;
        while(s <= e) {
            int mid = (s+e+1)/2;
            if (key == arr[mid]) {
                max = mid;
                int max1 = findPivot(s, mid-1, arr, key);
                int max2 = findPivot(mid+1, e, arr, key);
                if (max1 > mid && max1 > max2) {
                    return max1;
                } else if (max2 > mid && max2 > max1) {
                    return max2;
                } 
                return max;
            } else if (arr[mid] > key && mid > max) {
                max = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return max;
    }
}