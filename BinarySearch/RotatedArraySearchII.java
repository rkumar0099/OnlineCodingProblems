import java.util.*;

public class RotatedArraySearchII {
    public static void main(String[] args) {
        //int[] arr = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int[] arr = new int[]{2, 2, 2, 0, 1};
        int s = 0;
        int e = arr.length - 1;
        System.out.println("e: " + e);
        int t = 2;
        int right = findRightMostMax(s, e, arr);
        System.out.println("Right: " + right);

        int a1 = binarySearch(s, right, arr, t);
        int a2 = binarySearch(right+1, e, arr, t);
        System.out.println("" + a1 + ", " + a2);
    }

    public static int findRightMostMax(int s, int e, int[] arr) {
        int max = arr[0];
        int index = 0;
        while(s <= e) {
            if (arr[s] < max) {
                return index;
            }
            if (arr[s] >= max) {
                max = arr[s];
                index = s;
            }
            s += 1;
        }
        return index;
    }
    
    // I assume mid value is max, find left max
    public static int findMax(int s, int e, int[] arr, int max) {
        int index = -1;
        while(s <= e) {
            int mid = (s+e+1)/2;

            if (arr[mid] >= max) {
                index = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return index;
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
}