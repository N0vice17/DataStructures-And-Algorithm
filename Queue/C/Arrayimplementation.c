#include "ArrayImplementation.h"
#include <stdlib.h>

Queue	*queue_build(void)
{
	Queue	*queue;

	queue = (Queue *) malloc(sizeof (Queue));
	queue->head = 0;
	queue->tail = 0;

	return (queue);
}

void	queue_enqueue(int data, Queue *queue)
{
	queue->array[queue->tail] = data;
	queue->tail += 1;
}

int	queue_dequeue(Queue *queue)
{
	int	garbage;

	garbage = queue->array[queue->head];
	queue->head += 1;
	return (garbage);
}

void	queue_destroy(Queue *queue)
{
	free(queue);
}
