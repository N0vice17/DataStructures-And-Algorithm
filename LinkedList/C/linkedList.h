#ifndef LINKEDLIST_H
#define LINKEDLIST_H

typedef struct Node
{
	
	int			data;
	struct Node	*next;

}	Node;

Node	*linked_list_search(int x, Node *p);

/*
 * Given two nodes p and q,
 * inserts p between q and q.next
 */
void	linked_list_insert(Node *p, Node *q);

/*
 * Given a node p, removes p.next from the list
 */
void	linked_list_delete(Node *p);

#endif
