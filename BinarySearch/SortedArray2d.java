import java.util.*;


public class SortedArray2d {

    public static void main(String[] args) {
        //int[][]arr = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int[][] arr = new int[][]{{1, 1}};
        boolean res = binarySearch(arr, 5);
        System.out.println(res);
    }

    public static boolean binarySearch(int[][] arr, int t) {
        int m = arr.length;
        int n = arr[0].length;
        int total = m*n;
        int s = 0;
        int e = total - 1;

        while(s <= e) {
            int mid = (s+e+1) / 2;
            int r = mid / n;
            int c = mid % n;
            if (arr[r][c]== t) {
                return true;
            } else if (t < arr[r][c]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }

}