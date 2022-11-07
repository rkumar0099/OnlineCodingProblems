import java.util.*;


public class MedianTwoSortedArray {
    public static void main(String[] args) {
        // a 3
        // b -2 -1
        //int[] a = new int[]{0, 0};
        //int[] b = new int[]{0, 0};

        //int[] a = new int[]{20, 21, 32, 42, 52}; // 5
        //int[] b = new int[]{6, 7, 8, 9, 10, 11, 12, 13, 14}; // 9

        //int[] a = new int[] {2};
        //int[] b = new int[] {1, 3, 4};

        //int[] a = new int[]{4};
        //int[] b = new int[]{1, 2, 3};

        //int[] a = new int[]{1, 3};
        //int[] b = new int[]{2, 7};

        //int[] a = new int[]{2, 3};
        //int[] b = new int[]{1};

        //int[] a = new int[]{2, 3, 7};
        //int[] b = new int[]{1, 4, 5, 6, 8, 9, 10};

        //int[] a = new int[]{1, 2, 3};
        //int[] b = new int[]{4};

        //int[] a = new int[]{1, 2};
        //int[] b = new int[]{3, 4};

        int[][] testA = new int[][]{
            {1, 3, 4},
            {0, 0},
            {20, 21, 32, 42, 52},
            {2},
            {4},
            {1, 3},
            {2, 3},
            {2, 3, 7},
            {1, 2, 3},
            {1, 2}
        };

        int[][] testB = new int[][]{
            {2, 5, 6},
            {0, 0},
            {6, 7, 8, 9, 10, 11, 12, 13, 14},
            {1, 3, 4},
            {1, 2, 3},
            {2, 7},
            {1},
            {1, 4, 5, 6, 8, 9, 10},
            {4},
            {3, 4}
        };

        for (int i = 0; i < testA.length; i ++) {
            findMedian(testA[i], testB[i]);
        }
    }

    public static void findMedian(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int aStart = -1;
        int aEnd = -1;
        if (aLen > 0) {
            aStart = 0;
            aEnd = aLen - 1;
        }
        int bStart = -1;
        int bEnd = -1;
        if (bLen > 0) {
            bStart = 0;
            bEnd = bLen - 1;
        }
        int medianPos = (aLen + bLen) / 2; // 7
        int skip = medianPos + 1;
        int pos = 0;
        if ((aLen + bLen) % 2 == 0) {
            pos = 1;
        }
        if (pos == 0) {
            skip -= 1;
        } else {
            skip -= 2;
        }
        //System.out.println("skip: " + skip + ", aStart: " + aStart + ", aEnd: " + aEnd + 
        // ", bStart: " + bStart + ", bEnd: " + bEnd);
        double median = getMedian(a, b, aStart, aEnd, bStart, bEnd, pos, skip);
        System.out.println("\nMedian: " + median);
        System.out.println("\n");
    }

    public static double getMedian(int[] a, int[] b, int aStart, int aEnd, int bStart, int bEnd, int pos, int skip) {
        // base conditions
        // return -1 if both arrays are empty
        System.out.println("skip: " + skip + ", aStart: " + aStart + ", aEnd: " + aEnd + 
         ", bStart: " + bStart + ", bEnd: " + bEnd);
        if (aStart == -1 && bStart == -1) {
            return -1.0;
        }
        // check if a is empty or a has been traversed completely
        if (aStart == -1 || aStart > aEnd) {
            // a is empty
            int medianPos = bStart + skip;
            if (pos == 0) {
                return (double)b[medianPos];
            } else if (pos == 1) {
                return (double)(b[medianPos] + b[medianPos + 1]) / 2;
            }
        }
        
        // check if b is empty or b is traversed completely
        if (bStart == -1 || bStart > bEnd) {
               // b is empty
               int medianPos = aStart + skip;
               if (pos == 0) {
                   return (double)a[medianPos];
               } else if (pos == 1) {
                   return (double)(a[medianPos] + a[medianPos + 1]) / 2;
               }
        }

        // skip =0, no more elements to skip, and both arrays have not been completely traversed
        if (skip == 0) {
            System.out.println("Skip: " + skip + ", aStart: " + aStart + " aEnd: " + aEnd + ", bStart: " + bStart + " bEnd: " + bEnd);
            double val1 = 0.0;
            if (a[aStart] <= b[bStart]) {
                val1 = (double)a[aStart];
                aStart += 1;
            } else {
                val1 = (double)b[bStart];
                bStart += 1;
            }
            System.out.println("Val1: " + val1);
            if (pos == 0) {
                return val1;
            } else {
                double val2 = 0.0;
                if (aStart <= aEnd && bStart <= bEnd) {
                    val2 = (double)a[aStart] <= (double)b[bStart] ? (double)a[aStart] : (double)b[bStart];
                }
                else if (aStart <= aEnd) {
                    val2 = (double)a[aStart];
                } else {
                    val2 = (double)b[bStart];
                }
                System.out.println("Val2: " + val2);
                return (val1 + val2) / 2.0;
            }
        }

        int midA = (aStart+aEnd+1)/2;
        int midB = (bStart+bEnd+1)/2;
        int aElems = (midA-aStart+1);
        int bElems = (midB-bStart+1);
        int numElems = aElems + bElems;
        System.out.println("Mid A: " + a[midA] + ", Mid B: " + b[midB] + ", NumElems: " + numElems);


        if (a[midA] < b[bStart]) {
            if (skip - aElems >= 0) {
                skip -= aElems;
                return getMedian(a, b, midA+1, aEnd, bStart, bEnd, pos, skip);
            } else {
                aStart += skip;
                skip = 0;
                return getMedian(a, b, aStart, aEnd, bStart, bStart, pos, skip);
            }
        } else if (b[midB] < a[aStart]) {
            if (skip-bElems >= 0) {
                skip -= bElems;
                return getMedian(a, b, aStart, aEnd, midB+1, bEnd, pos, skip);
            } else {
                bStart += skip;
                skip = 0;
                return getMedian(a, b, aStart, aEnd, bStart, bEnd, pos, skip);
            }
        } else {
            if (skip - numElems >= 0) {
                skip -= numElems;
                return getMedian(a, b, midA+1, aEnd, midB+1, bEnd, pos, skip);
            } else {
                skip -= 1;
                if (a[aStart] <= b[bStart]) {
                    aStart += 1;
                } else {
                    bStart += 1;
                }
                return getMedian(a, b, aStart, aEnd, bStart, bEnd, pos, skip);
            }
        }
    }

    // returns the max index element less than or equal to the key
    public static int findMax(int s, int e, int[] arr, int key) {
        int max = -1;
        while(s <= e) {
            int mid = (s+e+1)/2;
            if (arr[mid] <= key && mid > max) {
                max = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return max;
    }
}