#include<iostream>
#include<queue>
using namespace std;

class node
{
public:
    int data ;
    node* right;
    node* left;
    node(int data){
        this->data = data;
        this -> left = NULL;
        this -> right = NULL;
    }
};
void traverseLeft(node* root, vector<int> &ans) {
    //base case
    if( (root == NULL) || (root->left == NULL && root->right == NULL) )
        return ;
        
    ans.push_back(root->data);
    if(root->left)
        traverseLeft(root->left, ans);
    else
        traverseLeft(root->right, ans);
        
}

void traverseLeaf(node* root, vector<int> &ans) {
    //base case
    if(root == NULL)
        return ;
        
    if(root->left == NULL && root->right == NULL) {
        ans.push_back(root->data);
        return;
    }
    
    traverseLeaf(root->left, ans);
    traverseLeaf(root->right, ans);
    
}

void traverseRight(node* root, vector<int> &ans) {
    //base case
    if( (root == NULL) || (root->left == NULL && root->right == NULL) )
        return ;
    
    if(root->right)
        traverseRight(root->right, ans);
    else
        traverseRight(root->left, ans);
        
    //wapas aagye
    ans.push_back(root->data);
        
}

vector <int> boundary(node *root)
{
    vector<int> ans;
    if(root == NULL)
        return ans;
        
    ans.push_back(root->data);
    
    //left part print/store
    traverseLeft(root->left, ans);
    
    //traverse Leaf Nodes
    
    //left subtree
    traverseLeaf(root->left, ans);
    //right subtree
    traverseLeaf(root->right, ans);
    
    //traverse right part
    traverseRight(root->right, ans);
    
    return ans;
    
    
}
node* BuildTree(node* root){
    cout << "Enter value of  node:";
    int data;
    cin >> data;
    root = new node(data);
    if(data == -1){
        
        return NULL;
    }

    cout<< " Enter Data for inserting in left of " << data<<endl;
    root -> left = BuildTree(root->left);
    cout<< " Enter Data for inserting in right of " << data<<endl;
    root -> right = BuildTree(root->right);
    cout<<endl;
    return root;
}

int main(int argc, char const *argv[])
{   //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
    cout << "---------------------------------------------------------------------" << endl;    
    node* root = NULL;
    root = BuildTree(root);
    cout << "---------------------------------------------------------------------" << endl;    
    cout << "---------------------------------------------------------------------" << endl;    
    vector<int> res =  boundary(root);
    
    return 0;
}
