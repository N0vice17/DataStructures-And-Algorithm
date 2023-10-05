#ifndef HASH_TABLE_CHAINING_STRATEGY_H
#define HASH_TABLE_CHAINING_STRATEGY_H

#define HASH_TABLE_SIZE 1153

typedef int (HashFunction)(char *);

typedef struct HashNode
{

	char			*key;
	void			*value;
	struct HashNode	*next;

}	HashNode;

typedef struct
{
	
	HashNode		**table;
	HashFunction	*hash_function;

}	HashTable;

HashTable	*hash_table_build(int *size, HashFunction *function);

void		hash_table_insert(char *key, void *value, HashTable *table);

void		*hash_table_search(char *key, HashTable *table);

#endif
