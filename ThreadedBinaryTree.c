#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct node
{
    int data;
    struct node *leftSubtree;
    struct node *rightSubtree;
    bool lThread, rThread;
};

struct node *createTree()
{
    return NULL;
}

struct node *insert(struct node *root, int num)
{
    struct node *temp = root;
    struct node *newNode = (struct node *)malloc(sizeof(struct node));
    newNode->data = num;
    newNode->lThread = true;
    newNode->rThread = true;
    if (temp == NULL)
    {
        newNode->leftSubtree = NULL;
        newNode->rightSubtree = NULL;
        printf("\nNew Node added successfully as the root: %d", newNode->data);
        return newNode;
    }
    else if (temp->data > num && temp->lThread == false)
    {
        temp->leftSubtree = insert(temp->leftSubtree, num);
    }
    else if (temp->data < num && temp->rThread == false)
    {
        temp->rightSubtree = insert(temp->rightSubtree, num);
    }
    else if (temp->data > num && temp->lThread == true)
    {
        temp->lThread = false;
        newNode->leftSubtree = temp->leftSubtree;
        newNode->rightSubtree = temp;
        temp->leftSubtree = newNode;
        printf("\nNew node added successfully to the left of %d!", temp->data);
    }
    else if (temp->data < num && temp->rThread == true)
    {
        temp->rThread = false;
        newNode->rightSubtree = temp->rightSubtree;
        newNode->leftSubtree = temp;
        temp->rightSubtree = newNode;
        printf("\nNew node added successfully to the right of %d!", temp->data);
    }

    return temp;
}

struct node *insertNodes(struct node *root)
{
    int num, n;
    printf("\nEnter number of nodes to add: ");
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
    {
        printf("\n\n\n%d) ", i);
        scanf("%d", &num);
        root = insert(root, num);
    }

    return root;
}

void inorderTrav(struct node *root)
{
    if (root == NULL)
    {
        printf("\nNo tree found!");
    }
    else
    {
        while (root->lThread != true)
        {
            root = root->leftSubtree;
        }

        while (root != NULL)
        {
            printf("%d  ", root->data);

            if (root->rThread == true)
            {
                root = root->rightSubtree;
            }
            else
            {
                root = root->rightSubtree;
                while (root->lThread != true)
                {
                    root = root->leftSubtree;
                }
            }
        }
    }
}

struct node *deleteNode(struct node *root, int num)
{
    struct node *temp = root;

    if (temp == NULL)
    {
        printf("\n\nTree not found!");
    }
    else if (temp->data >= num && temp->lThread == false)
    {
        if (temp->leftSubtree->data == num)
        {

            if (temp->leftSubtree->lThread == true && temp->leftSubtree->rThread == true)
            {
                temp->lThread = true;
                struct node *temp1 = temp->leftSubtree;
                temp->leftSubtree = temp->leftSubtree->leftSubtree;
                free(temp1);
                printf("\nNode deleted successfully!");
            }
            else if (temp->leftSubtree->lThread == true ^ temp->leftSubtree->rThread == true)
            {
                if (temp->leftSubtree->lThread == true)
                {
                    temp->leftSubtree->data = temp->leftSubtree->rightSubtree->data;
                    temp->leftSubtree->rThread = true;
                    temp->leftSubtree->rightSubtree = temp->leftSubtree->rightSubtree->rightSubtree;
                    temp->leftSubtree = deleteNode(temp->leftSubtree, temp->leftSubtree->leftSubtree->data);
                    printf("\nNode deleted successfully!");
                }
                else
                {
                    temp->leftSubtree->data = temp->leftSubtree->leftSubtree->data;
                    temp->leftSubtree->lThread = true;
                    temp->leftSubtree->leftSubtree = temp->leftSubtree->leftSubtree->leftSubtree;
                    temp->leftSubtree = deleteNode(temp->leftSubtree, temp->leftSubtree->leftSubtree->data);
                    printf("\nNode deleted successfully!");
                }
            }
            else
            {
                struct node *temp1 = temp->leftSubtree->leftSubtree;
                while (temp1->rightSubtree != NULL)
                {
                    temp1 = temp1->rightSubtree;
                }
                temp->leftSubtree->data = temp1->data;
                temp->leftSubtree->leftSubtree = deleteNode(temp->leftSubtree->leftSubtree, temp1->data);
                printf("\nNode deleted successfully!");
            }
        }
        else
        {
            temp->leftSubtree = deleteNode(temp->leftSubtree, num);
        }
    }
    else if (temp->data <= num && temp->rThread == false)
    {

        if (temp->rightSubtree->data == num)
        {

            if (temp->rightSubtree->lThread == true && temp->rightSubtree->rThread == true)
            {
                temp->rThread = true;
                struct node *temp1 = temp->rightSubtree;
                temp->rightSubtree = temp->rightSubtree->rightSubtree;
                free(temp1);
                printf("\nNode deleted successfully!");
            }
            else if (temp->rightSubtree->lThread == true ^ temp->rightSubtree->rThread == true)
            {
                if (temp->rightSubtree->lThread == true)
                {
                    temp->rightSubtree->data = temp->rightSubtree->rightSubtree->data;
                    temp->rightSubtree->rThread = true;
                    temp->rightSubtree->rightSubtree = temp->rightSubtree->rightSubtree->rightSubtree;
                    temp->rightSubtree = deleteNode(temp->rightSubtree, temp->rightSubtree->leftSubtree->data);
                    printf("\nNode deleted successfully!");
                }
                else
                {
                    temp->rightSubtree->data = temp->rightSubtree->rightSubtree->data;
                    temp->rightSubtree->lThread = true;
                    temp->rightSubtree->leftSubtree = temp->rightSubtree->leftSubtree->leftSubtree;
                    temp->rightSubtree = deleteNode(temp->rightSubtree, temp->rightSubtree->leftSubtree->data);
                    printf("\nNode deleted successfully!");
                }
            }
            else
            {
                struct node *temp1 = temp->rightSubtree->leftSubtree;
                while (temp1->rightSubtree != NULL)
                {
                    temp1 = temp1->rightSubtree;
                }
                temp->rightSubtree->data = temp1->data;
                temp->rightSubtree->leftSubtree = deleteNode(temp->rightSubtree->leftSubtree, temp1->data);
                printf("\nNode deleted successfully!");
            }
        }
        else
        {
            temp->rightSubtree = deleteNode(temp->rightSubtree, num);
        }
    }
    return temp;
}

void display(struct node *root)
{
    int choice, data, del;
    printf("Enter your choice\n 1.Insert\n 2.Inorder Traversal\n 3.Delete\n 4.Exit\n");
    scanf("%d", &choice);

    switch (choice)
    {
    case 1:
        root = insertNodes(root);
        break;

    case 2:
        inorderTrav(root);
        break;

    case 3:
        printf("\n\nEnter the node to be deleted: ");
        scanf("%d", &del);
        deleteNode(root, del);
        break;

    case 4:
        return;

    default:
        printf("\nInvalid choice!");
        break;
    }

    display(root);
}

int main()
{
    struct node *root = createTree();

    printf("\nName: Sarthak Pithe ");
    printf("\nRoll no: 1    ");
    printf("\nBatch: 2       ");
    printf("\nClass: SY CS-D          ");

    display(root);

    return 0;
}
