#include<iostream>
#include<stdio.h>
#include<math.h>
#include<queue>

using namespace std;

struct Tree {
    int value;
    Tree *left;
    Tree *right;
};

struct Tree* getTree(int num);
struct Tree* getRandomTree();
void printRoot(Tree* root);
int countNodesInCompleteBinaryTree(Tree *root);
int getLevel(Tree *root);
int getLeafNodes(Tree *root, int depth, int level);

int main() {
    //Tree *rand = getRandomTree();
    //printRoot(rand);
    //printf("\n");

    Tree *t = getTree(5);
    int nodes = countNodesInCompleteBinaryTree(t);
    printf("Total Nodes: %d\n", nodes);
}

int countNodesInCompleteBinaryTree(Tree* root) {
    if (root == NULL)
        return 0;
        
    int rootLevel = getLevel(root);
    if (rootLevel == 0)
        return 1;
        
    int rootDepth = 0;
    int nonLeafNodes = pow(2, rootLevel) - 1;
    int leafNodes = getLeafNodes(root, 0, rootLevel);
        
    printf("NonLeafNodes: %d, LeafNodes: %d\n", nonLeafNodes, leafNodes);
    return (nonLeafNodes + leafNodes);
}

int getLevel(Tree *t) {
    if (t == NULL) {
        return 0;
    }
    int level = 0;
    while(t->left != NULL){
        level += 1;
        t = t->left;
    }
    return level;
}

struct Tree* getTree(int num) {
    // complete with consecutive num elems, e.g, num = 6, tree = [1, 2, 3, 4, 5, 6]
    queue<Tree*> nodes;
    int arr[num] = {};
    for(int i = 1; i<=num; i ++) {
        arr [i-1] = i;
    }

    printf("Number of elements in arr: %d\n", num);
    Tree *t = NULL;
    Tree *temp = NULL;
    t = new Tree;

    if (t == NULL) {
        printf("Memory not allocated\n");
        exit(1);
    }

    t->value = arr[0];
    t->left = NULL;
    t->right = NULL;

    Tree *root = t;

    for(int i = 1; i < num; i ++) {
        if (t->left != NULL && t->right != NULL){
            t = nodes.front();
            nodes.pop();
        }
        if (t -> left == NULL){
            t->left = new Tree;
            temp = t->left;
            temp->value = arr[i];
            temp->left = NULL;
            temp->right = NULL;
            nodes.push(temp);
        } else {
            t->right = new Tree;
            temp = t->right;
            temp->value = arr[i];
            temp->left = NULL;
            temp->right = NULL;
            nodes.push(temp);
        }
    }
    return root;
}

// preorder traversal
void printRoot(Tree* root) {
    //printf(" %p ", (void*)root);
    if (root == NULL)
        return;
    printf("%d ", root->value);
    if (root -> left != NULL)
        printRoot(root->left);
    if (root -> right != NULL)
        printRoot(root -> right);
}

// get random tree for testing
struct Tree* getRandomTree() {
    int a[7] = {1, 2, 3, 4, 5, 6, 7};
    Tree *root = new Tree;
    Tree *temp = root;
    root->value = a[0];
    root->left = new Tree;
    root->right = new Tree;
    temp = root->left;
    temp->value = a[1];
    temp->left = new Tree;
    temp->right = new Tree;
    temp = root->right;
    temp->value = a[2];
    temp->left = new Tree;
    temp->right = new Tree;

    temp = root->left->left;
    temp->value = a[3];
    temp = root->left->right;
    temp->value = a[4];

    temp = root->right->left;
    temp->value = a[5];
    temp = root->right->right;
    temp->value = a[6];

    return root;
}

int getLeafNodes(Tree *root, int depth, int level) {
    Tree *node = root;
    Tree *left = root;
    for(int i = 1; i<level; i ++){
        node = node->right;
        left = left -> left;
    }
    if (left->left == NULL)
        return 0;

    if (node -> right != NULL){ 
        //printf("Leave node finalized node->right\n");
        return pow(2, level);
    }

    if (node -> left != NULL){
        //printf("Leave node finalized node->left\n");
        return (pow(2, level) - 1);
    }

    int leftLeaveNodes = getLeafNodes(root->left, depth+1, level-1);
    int rightLeaveNodes = getLeafNodes(root->right, depth+1, level-1);
    return leftLeaveNodes + rightLeaveNodes;
}