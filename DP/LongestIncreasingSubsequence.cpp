#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int getLongestCommonSubsequence(vector<int> v1, vector<int> v2);

int main() {
    //vector<int> v1 = {10, 9, 2, 5, 3, 7, 101, 18};
    // {2, 3, 5, 7, 9, 10, 18, 101}
    //vector<int> v1 = {7, 7, 7, 7, 7, 7};
    vector<int> v1 = {0, 1, 0, 3, 2, 3};
    vector<int> v2 = v1;
    int* start = &v1[0];
    int n = v1.size();
    sort(start, start+n);
    //printf("v1 elem0 %d, v2 elem0 %d\n", v1[0], v2[0]);
    int lisValue = getLongestCommonSubsequence(v1, v2);
    printf("LIS: %d\n", lisValue);
    
}

int getLongestCommonSubsequence(vector<int> v1, vector<int> v2) {
    // v1.size() must be >= to v2.size()-
    int n1 = v1.size();
    int n2 = v2.size();
    //printf("n1: %d, n2: %d\n", n1, n2);
    int subseq[n1][n2];
    int lastElem = -1000000;

    for(int i = 0; i < n1; i ++) {
        if (lastElem == v1[i]) {
            for(int j = 0; j < n2; j ++)
                subseq[i][j] = subseq[i-1][j];
            continue;
        }
        lastElem = v1[i];
        for(int j = 0; j < n2; j ++) {
            if (v1[i] == v2[j]) {
                //printf("i: %d, j: %d\n", i, j);
                if (i-1 >= 0 && j-1 >= 0) 
                    subseq[i][j] = subseq[i-1][j-1] + 1;
                else 
                    subseq[i][j] = 1;
            } else {
                if (i-1 >= 0 && j-1 >= 0) {
                    int maxValue = std::max({subseq[i-1][j], subseq[i-1][j-1], subseq[i][j-1]});
                    subseq[i][j] = maxValue;
                } else if (j-1 >= 0)
                    subseq[i][j] = subseq[i][j-1];
                else if (i-1 >= 0)
                    subseq[i][j] = subseq[i-1][j];
                else 
                    subseq[i][j] = 0;
                }
        }
    }
    /*
    for(int i = 0; i < n1; i ++){
        for(int j = 0; j < n2; j ++) {
            printf("%d ", subseq[i][j]);
        }
        printf("\n");
    }
    */
    return subseq[n1-1][n2-1];
}
