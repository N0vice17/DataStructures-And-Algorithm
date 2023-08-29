#include "stack.h"
#include <stdlib.h>
#define length(arr) (sizeof (arr) / sizeof *(arr))

struct Stack
{
    int arr[10];
    int top;
};

Stack *create(void)
{
    Stack *stack = malloc(sizeof(Stack));
    if (!stack)
        return NULL;
    stack->top = -1;
    return stack;
}

inline static _Bool overflow(Stack *stack)
{
    return length(stack->arr) - 1 == stack->top;
}

inline static _Bool underflow(Stack *stack)
{
    return -1 == stack->top;
}

int printf(const char *, ...);

void push(Stack *stack, int data)
{
    if (overflow(stack))
        printf("Stack overflow!\n");
    else
        stack->arr[++(stack->top)] = data;
}

void pop(Stack *stack)
{
    if (underflow(stack))
        printf("Stack underflow!\n");
    else
        printf("%d\n", stack->arr[(stack->top)--]);
}

void top(Stack *stack)
{
    if (underflow(stack))
        printf("Stack underflow!\n");
    else
        printf("%d\n", stack->arr[stack->top]);
}