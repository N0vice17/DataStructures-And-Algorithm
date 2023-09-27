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

void levelOrderTraversal(node* &root){
    queue<node *> q;
    q.push(root);
    q.push(NULL);

    while(!q.empty()){
        node* temp = q.front();
        q.pop();

        if(temp==NULL){
            cout <<endl;
            if(!q.empty()) q.push(NULL);
        }
        else{
            cout << temp -> data << " ";
            if(temp ->left) q.push(temp -> left);
            if(temp ->right) q.push(temp -> right);
        }
    }
}


vector<vector<int>> traa(node * root){
    vector<vector<int>> ans;
        vector<int> temp;
        queue<node *> q;
        if(root==NULL)
            return ans;
        q.push(root);
        q.push(NULL);

        while(!q.empty()){
            
            node* tmp = q.front();
            q.pop();

            if(tmp==NULL){
                temp.push_back(-1001);
                // cout<<endl;
                // ans.push_back(temp);
                if(!q.empty()) q.push(NULL);
            }
            else{
                temp.push_back(tmp->data);
                // cout << tmp -> val << " ";
                if(tmp ->left) q.push(tmp -> left);
                if(tmp ->right) q.push(tmp -> right);
            }
        }
        vector<int> level;
        for(int i=0;i<temp.size();i++){
            
            if(temp[i] == -1001){
                ans.push_back(level);
                level.clear();
            }
            else{
                level.push_back(temp[i]);
            }
        }
        return ans;
}

int main(int argc, char const *argv[])
{   //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
    cout << "---------------------------------------------------------------------" << endl;    
    node* root = NULL;
    root = BuildTree(root);
    cout << "---------------------------------------------------------------------" << endl;    
    cout << "---------------------------------------------------------------------" << endl;    
    levelOrderTraversal(root);
    return 0;
}