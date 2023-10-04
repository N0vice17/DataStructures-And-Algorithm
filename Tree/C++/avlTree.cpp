#include <iostream>
#include <queue>
using namespace std;

class node
{
public:
    int data;
    node* left;
    node* right;
    int height;

    node(int value)
    {
        data = value;
        left = NULL;
        right = NULL;
        height = 1;
    }
};

int height(node* root)
{
    if (root == NULL)
    {
        return 0;
    }
    
    return root->height;
}

// Checking if Balance is disturbed, so that any of rotation can be performed
int getBalance(node* root)
{
    if (root == NULL)
    {
        return 0;
    }

    return (height(root->left) - height(root->right));
}

// Function to rotate the tree on left side if weight has increased on right side
node* leftRotate(node* x)
{
    node* y = x->right;
    node* T2 = y->left;

    y->left = x;
    x->right = T2;

    x->height = max(height(x->left), height(x->right)) + 1;
    y->height = max(height(y->left), height(y->right)) + 1;

    return y;
}

// Function to rotate the tree on right side if weight has increased on left side
node* rightRotate(node* y)
{
    node* x = y->left;
    node* T2 = x->right;

    x->right = y;
    y->left = T2;

    y->height = max(height(y->left), height(y->right)) + 1;
    x->height = max(height(x->left), height(x->right)) + 1;

    return x;
}

// Finding the successor node of the given node
node* successor(node* root)
{
    root = root->right;

    while (root->left != NULL)
    {
        root = root->left;
    }

    return root;
}

// Insertion of any node with given value
node* Insert(node* root, int value)
{
    if (root == NULL)
    {
        root = new node(value);
        return root;
    }
    if (value < root->data)
    {
        root->left = Insert(root->left, value);
    }
    else if (value > root->data)
    {
        root->right = Insert(root->right, value);
    }
    else
    {
        return root;
    }

    root->height = max(height(root->left), height(root->right)) + 1;

    int balance = getBalance(root);

    //left left case, so rightRotate required
    if (balance > 1 && value < root->left->data)
    {
        root = rightRotate(root);
        return root;
    }

    //left right case, so leftRotate & then rightRotate required
    if (balance > 1 && value > root->left->data)
    {
        root->left = leftRotate(root->left);
        root = rightRotate(root);
        return root;
    }

    //right right case, so leftRotate required
    if (balance < -1 && value > root->right->data)
    {
        root = leftRotate(root);
        return root;
    }

    //right left case, so rightRotate & then leftRotate required
    if (balance < -1 && value < root->right->data)
    {
        root->right = rightRotate(root->right);
        root = leftRotate(root);
        return root;
    }

    return root;
}

// Deletion of node with given value
node* Deletenode(node* root, int value)
{
    if (root == NULL)
    {
        return NULL;
    }
    if (value < root->data)
    {
        root->left = Deletenode(root->left, value);
    }
    else if (value > root->data)
    {
        root->right = Deletenode(root->right, value);
    }
    else
    {
        if (root->left == NULL && root->right == NULL)
        {
            delete(root);
            return NULL;
        }

        else if (root->left != NULL && root->right == NULL)
        {
            node* temp = root->left;
            delete(root);
            return temp;
        }

        else if (root->left == NULL && root->right != NULL)
        {
            node* temp = root->right;
            delete(root);
            return temp;
        }

        else if (root->left != NULL && root->right != NULL)
        {
            int temp = successor(root)->data;
            root->data = temp;
            root->right = Deletenode(root->right, temp);
        }
    }

    root->height = max(height(root->left), height(root->right)) + 1;

    int balance = getBalance(root);

    //left left case, so rightRotate required
    if (balance > 1 && getBalance(root->left) >= 0)
    {
        root = rightRotate(root);
        return root;
    }

    // left right case, so leftRotate & then rightRotate required
    if (balance > 1 && getBalance(root->left) < 0)
    {
        root->left = leftRotate(root->left);
        root = rightRotate(root);
        return root;
    }

    // right right case, so leftRotate required
    if (balance < -1 && getBalance(root->right) <= 0)
    {
        root = leftRotate(root);
        return root;
    }

    //right left case, so rightRotate & then leftRotate required
    if (balance < -1 && getBalance(root->right) > 0)
    {
        root->right = rightRotate(root->right);
        root = leftRotate(root);
        return root;
    }

    return root;
}

// LevelOrder traversal to verify our AVL tree
void LevelOrder(node* root)
{
    queue <node*> q;
    q.push(root);
    q.push(NULL);
    node* temp = NULL;
    while (!q.empty())
    {
        temp = q.front();
        q.pop();

        if (temp == NULL)
        {
            cout << endl;
            if (!q.empty())
            {
                q.push(NULL);
            }
        }

        else
        {
            cout << temp->data << " ";

            if (temp->left)
            {
                q.push(temp->left);
            }
            if (temp->right)
            {
                q.push(temp->right);
            }
        }
    }
    cout << endl;
}

/*

After Insert: 1, 2, 3
AVL Tree:

    2
   / \
  1   3

After Insert: 4, 5
AVL Tree:

    2
   / \
  1   4
     / \
    3   5

After Deletenode: 1
AVL Tree:

    4
   / \
  2   5
   \
    3

*/

int main()
{
    node* root = NULL;

    root = Insert(root, 1);
    root = Insert(root, 2);
    root = Insert(root, 3);
    LevelOrder(root);

    root = Insert(root, 4);
    root = Insert(root, 5);
    LevelOrder(root);
    
    root = Deletenode(root, 1);
    LevelOrder(root);

    return 0;
}