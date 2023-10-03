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

void	linked_list_insert_at(Node *p, Node *q, int position)
{
	if (position == 0)
		return (linked_list_insert(q, p));

	int i = 0;
	while (i < position && q)
		q = q->next;
	return (linked_list_insert(p, q));
}

void	linked_list_delete_at(Node *p, int position)
{
	if (position == 0)
		return;

	int i = 0;
	while (i < position && p)
		p = p->next;

	if (p && p->next)
		return (linked_list_delete(p));
}
