#include "linkedList.h"
#include <stdio.h>

Node	*linked_list_search(int x, Node *p)
{
	while (p && p->data != x)
		p = p->next;
	return (p);
}

void	linked_list_insert(Node *p, Node *q)
{
	p->next = q->next;
	q->next = p;
}

void	linked_list_delete(Node *p)
{
	p->next = p->next->next;
}

