#include<stdio.h>
#include<stdlib.h>

struct Node 
{
    int data;
    int power;
    struct Node* next;
};

// Function to create new node
void create_node(int x, int y, struct Node** temp)
{
    struct Node *r, *z;
    z = *temp;
    if (z == NULL) 
    {
        r = (struct Node*)malloc(sizeof(struct Node));
        r->data = x;
        r->power = y;
        *temp = r;
        r->next = (struct Node*)malloc(sizeof(struct Node));
        r = r->next;
        r->next = NULL;
    }
    else 
    {
        r->data = x;
        r->power = y;
        r->next = (struct Node*)malloc(sizeof(struct Node));
        r = r->next;
        r->next = NULL;
    }
}

// Function Adding two polynomial numbers
void polynomial_add(struct Node* poly1, struct Node* poly2, struct Node* poly)
{
    while (poly1->next && poly2->next) {
        // If power of 1st polynomial is greater then 2nd,
        // then store 1st as it is and move its pointer
        if (poly1->power > poly2->power) 
        {
            poly->power = poly1->power;
            poly->data = poly1->data;
            poly1 = poly1->next;
        }

        // If power of 2nd polynomial is greater then 1st,
        // then store 2nd as it is and move its pointer
        else if (poly1->power < poly2->power) {
            poly->power = poly2->power;
            poly->data = poly2->data;
            poly2 = poly2->next;
        }

        // If power of both polynomial numbers is same then
        // add their data
        else 
        {
            poly->power = poly1->power;
            poly->data = poly1->data + poly2->data;
            poly1 = poly1->next;
            poly2 = poly2->next;
        }

        // Dynamically create new node
        poly->next= (struct Node*)malloc(sizeof(struct Node));
        poly = poly->next;
        poly->next = NULL;
    }
    while (poly1->next || poly2->next)
    {
        if (poly1->next) 
        {
            poly->power = poly1->power;
            poly->data = poly1->data;
            poly1 = poly1->next;
        }
        else if (poly2->next) 
        {
            poly->power = poly2->power;
            poly->data = poly2->data;
            poly2 = poly2->next;
        }

        poly->next = (struct Node*)malloc(sizeof(struct Node));
        poly = poly->next;
        poly->next = NULL;
    }
}

// Display Linked list
void Display(struct Node* node)
{
    while (node->next != NULL) 
    {
        printf("%dx^%d", node->data, node->power);
        node = node->next;
        if (node->data >= 0) 
        {
            if (node->next != NULL)
                printf("+");
        }
    }
}

// Driver code
int main()
{
    struct Node *poly1 = NULL, *poly2 = NULL, *poly = NULL;

    // Create first list of 5x^2 + 4x^1 + 2x^0
    create_node(5, 2, &poly1);
    create_node(4, 1, &poly1);
    create_node(2, 0, &poly1);

    // Create second list of -5x^1 - 5x^0
    create_node(-5, 1, &poly2);
    create_node(-5, 0, &poly2);

    printf("1st Polynomial: ");
    Display(poly1);

    printf("\n2nd Polynomial: ");
    Display(poly2);

    poly = (struct Node*)malloc(sizeof(struct Node));

    // Function add two polynomial numbers
    polynomial_add(poly1, poly2, poly);

    // Display resultant List
    printf("\nAdded polynomial: ");
    Display(poly);

    return 0;
}