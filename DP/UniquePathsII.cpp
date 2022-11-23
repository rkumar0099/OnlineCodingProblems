#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

long findUniquePaths(vector<vector<int>>& v);

int main() {
    vector<vector<int>> v1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    vector<vector<int>> v2 = {{0, 0}, {1, 1}, {0, 0}};
    vector<vector<int>> v3 = {{1, 0}, {0, 0}};
    vector<vector<int>> v4 = {{1}};
    vector<vector<int>> v5 = {{0}};

    vector<vector<vector<int>>> cases = {v1, v2, v3, v4, v5};

    for(vector<vector<int>> v : cases) {
        long paths = findUniquePaths(v);
        printf("Unique paths to dest: %ld\n", paths);
    }
}

long findUniquePaths(vector<vector<int>>& v) {  
    int rows = v.size();
    int cols = v[0].size();
    long arr[rows][cols];

    // initialize the long array
    for(int i = 0; i < rows; i ++){
        for(int j = 0; j < cols; j ++){
            arr[i][j] = 0;
        }
    }

    for(int i = 0; i < rows; i ++) {
        for(int j = 0; j < cols; j ++) {
            int rightPos = j+1;
            int downPos = i+1;
            if (v[i][j] == 1) {
                continue;
            }
            if (i == 0 && j == 0)
                arr[i][j] = 2;
            if (rightPos < cols && v[i][rightPos] != 1)
                arr[i][rightPos] += arr[i][j];
            if (downPos < rows && v[downPos][j] != 1)
                arr[downPos][j] += arr[i][j];
        }
    }

    return arr[rows-1][cols-1] / 2;
}