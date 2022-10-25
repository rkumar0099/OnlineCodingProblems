import java.util.*;

public class FindMin {

    public static void main(String[] args) {
        int[] a = new int[]{11, 13, 15, 17};
        int aEnd = a.length - 1;
        int max = findMaxIndex(a, a[0]);
        int min = a[0];
        if (max+1 <= aEnd && a[max+1] < min) {
            min = a[max+1];
        }
        System.out.println("Min: " + min);
    }

    public static int findMaxIndex(int[] a, int key) {
        int s = 0;
        int e = a.length - 1;
        int max = -1;
        while(s <= e) {
            int mid = (s+e+1)/2;
            if (a[mid] >= key && mid > max) {
                key = a[mid];
                max = mid;
                s = mid+1;
            } else if (a[mid] < key) {
                e = mid - 1;
            }
        }
        return max;
    }
}