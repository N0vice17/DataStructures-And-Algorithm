#include "linkedList.h"
#define create(l) Node*l=create()
#define insert(l, n) insert(&l, n)
#define delete(l) free(l)

int main()
{

    create(l1); // creating the list

    insert(l1, 1);      // inserting at last
    insert(l1, 2);      // inserting at last
    insert(l1, 3);      // inserting at last
    insert(l1, 4);      // inserting at last
    display(l1);         // printing the list
    delete(l1);
    

    create(l2); // creating the list
    insert(l2, 5);      // inserting at last
    insert(l2, 6);      // inserting at last
    insert(l2, 7);      // inserting at last
    insert(l2, 8);      // inserting at last
    display(l2);         // printing the list
    delete(l2);

    return 0;
}