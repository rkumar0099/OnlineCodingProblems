import java.util.*;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int t = 15;
        //int[] a = new int[]{1, 2, 3, 4, 5};
        //int t = 11;
        int s = 0;
        int e = a.length - 1;
        int min = minSize(a, s, e, t);
        System.out.println("Min Size: " + min);
    }

    public static int minSize(int[] a, int s, int e, int t) {
        int aLen = e+1;
        int[] sumArr = new int[aLen];
        int sum = 0;
        int min = 10000000;

        for(int i = 0; i<=e; i ++) {
            sum += a[i];
            sumArr[i] = sum;
        }

        for(int i = 0; i<=e; i ++) {
            if (a[i] >= t) {
                return 1;
            }
            if (sumArr[i] >= t && (i+1) < min) {
                min = i+1;
            }
            int minLen = binarySearch(sumArr, s, i, s, i, t);
            if (minLen == 10000000)
                continue;
            if (minLen < min) 
                min = minLen;
        }
        if (min == 10000000)
            return 0;
        return min;
    }

    public static int binarySearch(int[] a, int s, int e, int startS, int endE, int t) {
        int elem = a[e];
        int min = 10000000;
        while(startS <= endE) {
            int mid = (startS+endE+1)/2;
            int diff = elem - a[mid];
            if (diff >= t) {
                int value = e - mid;
                if (value < min) {
                    min = value;
                }
                startS = mid+1;
            } else {
                endE = mid-1;
            }
        }
        return min;
    }

}