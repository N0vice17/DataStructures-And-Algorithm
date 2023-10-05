#include "chainingStrategy.h"
#include <string.h>
#include <stdlib.h>

int	hash_function(char *key)
{
	int	sum = 0;
	int	i = 0;

	while (key[i])
		sum += key[i++];

	return (sum % HASH_TABLE_SIZE);
}

HashTable	*hash_table_build(int *size, HashFunction *function)
{
	HashTable	*table;
	table = (HashTable *) malloc(sizeof (HashTable));

	if (size)
		table->table = (HashNode **) malloc(*size * sizeof (HashNode *));
	else
		table->table = (HashNode **) malloc(HASH_TABLE_SIZE * sizeof (HashNode *));

	if (function)
		table->hash_function = function;
	else
		table->hash_function = &hash_function;

	return (table);
}

HashNode	*hash_node_build(char *key, void *value)
{
	HashNode	*node;

	node = (HashNode *) malloc(sizeof (HashNode));
	node->key = key;
	node->value = value;
	node->next = NULL;

	return (node);
}

void	hash_table_insert(char *key, void *value, HashTable *table)
{
	HashNode	*node = hash_node_build(key, value);	
	int 		index = table->hash_function(key);

	if (!table->table[index])
		table->table[index] = node;
	else
	{
		node->next = table->table[index];
		table->table[index] = node;
	}
}

void	*hash_table_search(char *key, HashTable *table)
{
	int	index = table->hash_function(key);

	if (!table->table[index])
		return (NULL);
	else
	{
		HashNode	*current_node;

		current_node = table->table[index];
		while (current_node && strcmp(key, current_node->key) != 0)
			current_node = current_node->next;

		if (current_node)
			return (current_node->value);
		else
			return (NULL);
	}
}
