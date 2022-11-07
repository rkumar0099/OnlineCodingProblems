#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

bool findTarget(vector<vector<int>>& matrix, int target, int m, int n);
bool searchRow(vector<int>& row, int target, int s, int e);

int main() {
    vector<vector<int>> matrix = {
        {1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}
        };
    int t = 5;
    long unsigned m = matrix.size();
    long unsigned n = matrix.at(0).size();
    
    bool res = findTarget(matrix, t, m, n);
    printf("Res: %d\n", res);
    return 0;
}

bool findTarget(vector<vector<int>>& matrix, int target, int m, int n) {
    for(vector<int>& row: matrix) {
        bool res = searchRow(row, target, 0, n-1);
        if (res)
            return res;
    }
    return false;
}

bool searchRow(vector<int>& row, int target, int s, int e) {
    while(s<=e) {
        int mid = (s+e+1)/2;
        int value = row.at(mid);
        if (value == target)
            return true;
        if (value < target)
            s = mid+1;
        else 
            e = mid-1;
        
    }
    return false;
}