#include "stack.h"
#include <stdlib.h>
#define capacity 10

struct Node
{
    int data;
    Node *next;
};

struct Stack
{
    Node *top;
    int count;
};

Stack *create(void)
{
    Stack *stack = malloc(sizeof(Stack));
    if (!stack)
        return NULL;
    stack->top = NULL;
    stack->count = 0;
    return stack;
}

inline static _Bool overflow(Stack *stack)
{
    return capacity == stack->count;
}

inline static _Bool underflow(Stack *stack)
{
    return !stack->count;
}

int printf(const char *, ...);

void push(Stack *stack, int data)
{
    if (overflow(stack))
        printf("Stack overflow!\n");
    else
    {
        Node *newNode = malloc(sizeof(Node));
        if (!newNode)
            return;
        if (!stack->count) // for the first inserted node
            newNode->next = NULL;
        newNode->data = data;
        newNode->next = stack->top;
        stack->top = newNode;
        stack->count++;
    }
}

void pop(Stack *stack)
{
    if (underflow(stack))
        printf("Stack underflow!\n");
    else
    {
        printf("%d\n", stack->top->data);

        Node *del = stack->top;
        stack->top = stack->top->next;
        free(del);
        stack->count--;
    }
}

void top(Stack *stack)
{
    if (underflow(stack))
        printf("Stack underflow!\n");
    else
        printf("%d\n", stack->top->data);
}