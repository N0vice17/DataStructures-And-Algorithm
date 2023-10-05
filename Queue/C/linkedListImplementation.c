#include "linkedListImplementation.h"
#include <stdlib.h>

Queue	*queue_build(void)
{
	Queue	*queue;

	queue = (Queue *) malloc(sizeof (Queue));
	queue->head = NULL;
	queue->tail = NULL;

	return (queue);
}

Node	*node_build(int data)
{
	Node	*node;

	node = (Node *) malloc(sizeof (Node));
	node->data = data;
	node->next = NULL;

	return (node);
}

void	queue_enqueue(int data, Queue *queue)
{
	Node	*node;
	node = node_build(data);

	if (!queue->head)
	{
		queue->head = node;
		queue->tail = node;
		return;
	}

	queue->tail->next = node;
	queue->tail = node;
}

int	queue_dequeue(Queue *queue)
{
	Node	*node_garbage;
	int		int_garbage;

	node_garbage = queue->head;
	int_garbage	= queue->head->data;

	queue->head = queue->head->next;

	free(node_garbage);
	return (int_garbage);
}

void	queue_destroy(Queue *queue)
{
	while(queue->head)
		queue_dequeue(queue);

	free(queue);
}
