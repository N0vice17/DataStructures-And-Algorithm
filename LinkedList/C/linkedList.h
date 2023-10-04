#ifndef LINKEDLIST_H
#define LINKEDLIST_H

typedef struct Node
{
	
	int			data;
	struct Node	*next;

}	Node;

/*
 * Given an integer x and a node p,
 * return the address of the first node
 * where data is x or NULL if it doens't exists.
 */
Node	*linked_list_search(int x, Node *p);

/*
 * Given two nodes p and q,
 * inserts p between q and q.next
 */
void	linked_list_insert(Node *p, Node *q);
void	linked_list_insert_at(Node *p, Node *q, int position);

/*
 * Given a node p, removes p.next from the list
 */
void	linked_list_delete(Node *p);
void	linked_list_delete_at(Node *p, int position);

#endif
