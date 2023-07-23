#include <iostream>
#include <stack>
using namespace std;
bool isRightAssociative(char op)
{
    return (op == '^') ? true : false;
}
int getOperatorWeight(char op)
{
    int weight = -1;
    switch (op)
    {
        case '+':
        case '-':
            weight = 1;
            break;
        case '*':
        case '/':
            weight = 2;
            break;
        case '^':
            weight = 3;
    }
    return weight;
}
bool hasHigherPrecedence(char op1, char op2)
{
    int operator1Weight = getOperatorWeight(op1);
    int operator2Weight = getOperatorWeight(op2);
    if (operator1Weight == operator2Weight)
        return isRightAssociative(op1) ? false : true;
    return (operator1Weight > operator2Weight) ? true : false;
}
bool isClosingParentheses(char ch)
{
    return (ch == ')' || ch == '}' || ch == ']') ? true : false;
}
bool isOpeningParentheses(char ch)
{
    return (ch == '(' || ch == '{' || ch == '[') ? true : false;
}
bool isOperator(char ch)
{
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/') ? true : false;
}
bool isOperand(char ch)
{
    return ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) ? true : false;
}
string infixToPostfix(string expression)
{
    stack<char> s;
    string postfix;
    for (int i = 0; i < expression.length(); i++)
    {
        if (expression[i] == ' ' || expression[i] == ',')
            continue;
        else if (isOperand(expression[i]))
            postfix += expression[i];
        else if (isOperator(expression[i]))
        {
            while (!s.empty() && !isOpeningParentheses(s.top()) && hasHigherPrecedence(s.top(), expression[i]))
            {
                postfix += s.top();
                s.pop();
            }
            s.push(expression[i]);
        }
        else if (isOpeningParentheses(expression[i]))
            s.push(expression[i]);
        else if (isClosingParentheses)
        {
            while (!s.empty() && !isOpeningParentheses(s.top()))
            {
                postfix += s.top();
                s.pop();
            }
            s.pop();
        }
    }
    while (!s.empty())
    {
        postfix += s.top();
        s.pop();
    }
    return postfix;
}
int main()
{
    string expression;
    getline(cin, expression);
    cout << infixToPostfix(expression);
    return 0;
}
