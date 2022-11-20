#include<iostream>
#include<vector>
#include<stdio.h>
#include<math.h>

using namespace std;

int getLIS(vector<int>& nums);

int main() {
    vector<int> nums = {10, 9, 2, 5, 3, 7, 101, 18};
    int res = getLIS(nums);
}

int getLIS(vector<int>& nums) {
    int totalN = 2*pow(10, 4) + 1;
    int arr[totalN] = {};

    printf("Total items: %d, init: %d\n", totalN, arr[0]);

    return 0;
}

int getMaxSubseq(int *arr, int s, int e) {
    int max = 0;
    while(s <= e) {
        
    }
}

