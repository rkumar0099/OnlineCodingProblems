#include <iostream>
#include <stdio.h>
#include <vector>
#include <cstring>
#include <string>
#include <algorithm>
#include <initializer_list>

using namespace std;

int getLCS(string s1, string s2);

int main() {
    string s1 = "ABCDEFGH";
    string s2 = "ABDFGHI";
    int lcsLen = getLCS(s1, s2);
    printf("The max subseq: %d\n", lcsLen);
}

int getLCS(string s1, string s2) {
    int n1 = s1.length();
    int n2 = s2.length();
    if (n2 > n1) {
        string temp = s1;
        s1 = s2;
        s2 = temp; 
        int temp2 = n1;
        n1 = n2;
        n2 = temp2;
    }

    int subseq[n1][n2];
    for(int i = 0; i < n1; i ++) {
        for(int j = 0; j < n2; j ++) {
            if (s1[i] == s2[j]) {
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
                }
        }
    }
    /*
    for(int i = 0; i < n1; i ++) {
        for (int j = 0; j < n2; j ++) {
            printf("%d ", subseq[i][j]);
        }
        printf("\n");
    }
    */
    return subseq[n1-1][n2-1];
}
