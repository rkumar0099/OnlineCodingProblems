#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;    

int findDuplicate(vector<int> v);

int main() {
    vector<int> v = {1, 3, 4, 2, 2};
    int n = v.size();
    int *p = &v[0];
    sort(p, p+n);
    int val = findDuplicate(v);
    printf("Duplicate: %d\n", val);
}

int findDuplicate(vector<int> v) {
    int e = v.size()-1;
    for(int i = 0; i < v.size(); i ++)
        if (i+1 <= e && v[i] == v[i+1])
            return v[i];

    return -1;
}