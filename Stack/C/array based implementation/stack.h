#ifndef STACK_H
#define STACK_H

typedef struct Stack Stack;
Stack *create(void);
void push(Stack *, int);
void pop(Stack *);
void top(Stack *);

#endif