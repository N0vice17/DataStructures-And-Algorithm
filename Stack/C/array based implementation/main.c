#include "stack.h"
#define create(stack) Stack*stack=create()

int main()
{
    create(stack);
    
    for (int i = 1; i <= 10; push(stack, i++));
    pop(stack);
    pop(stack);
    pop(stack);
    top(stack);
    
    return 0;
}