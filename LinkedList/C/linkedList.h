#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include <stdlib.h>
#include <stdio.h>

typedef struct Node Node;
Node *create(void);
void insert(Node **, int);
void display(Node *);

#endif
