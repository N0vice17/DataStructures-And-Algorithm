#include "linkedList.h"

struct Node // defining the structure
{
    int data;
    Node *next;
};

Node *create() // creating the list and return the address to the caller function
{
    Node *list;

    list = NULL;

    return list;
}

void insert(Node **headPtr, int value)
{
    Node *temp = malloc(sizeof(Node));
    if (!temp)
        return;
    temp->data = value;
    Node *i = *headPtr; // temporary pointer to traverse till the end

    if (!i) // if list is empty
        *headPtr = temp;

    else
    {
        while (i->next)
            i = i->next;
        i->next = temp;
    }

    temp->next = NULL;
}

void display(Node *node)
{
    printf("\nThe list is:\n");

    while (node) // while(node != NULL)
    {
        printf("%d ", node->data);
        node = node->next;
    }
}
