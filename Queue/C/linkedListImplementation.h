#ifndef QUEUE_LINKED_LIST_IMPLEMENTATION_H
#define QUEUE_LINKED_LIST_IMPLEMENTATION_H

#include "../../LinkedList/C/linkedList.h"

typedef struct
{

	Node	*head;
	Node	*tail;

}	Queue;

Queue	*queue_build(void);

void	queue_enqueue(int data, Queue *queue);

int		queue_dequeue(Queue *queue);

void	queue_destroy(Queue *queue);

#endif
