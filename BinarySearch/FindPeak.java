import java.util.*;

public class FindPeak {
    public static void main(String[] args) {
        int[] a = new int[]{2, 1};
        int s = 0;
        int e = a.length - 1;
        int peak = findPeak(a, s, e);
        System.out.println("Peak: " + peak);
    }

    public static int findPeak(int[] a, int s, int e) {
        int mid = (s+e+1)/2;
        int peak = -1;
        System.out.println("Mid: " + mid);
        if (mid-1 < s && mid+1 <= e) {
            // left most element reached
            if (a[mid] > a[mid+1]) {
                peak = mid;
            }
        } else if (mid+1>e && mid-1 >= s) {
            // right most element reached
            if (a[mid] > a[mid-1]) {
                peak = mid;
            }
        } else if (mid-1 < s && mid+1 > e) {
                peak = mid;
        } else if (a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
                peak = mid;
        }
        if (peak > -1) 
            return peak;
        if (a[mid-1] > a[mid]) {
            peak = findPeak(a, s, mid-1);
        } else {
            peak = findPeak(a, mid+1, e);
        }
        return peak;
    } 

}