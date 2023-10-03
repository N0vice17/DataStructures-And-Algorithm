#ifndef QUEUE_ARRAY_IMPLEMENTATION_H
# define QUEUE_ARRAY_IMPLEMENTATION_H

#define QUEUE_SIZE 100

typedef struct
{
	int	array[QUEUE_SIZE];
	int	head;
	int	tail;
}	Queue;

Queue	*queue_build(void);

void	queue_enqueue(int data, Queue *queue);

int		queue_dequeue(Queue *queue);

void	queue_destroy(Queue *queue);

#endif
