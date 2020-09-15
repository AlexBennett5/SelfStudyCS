#ifndef HASH_H
#define HASH_H 1

#define HT_SIZE 10000

typedef struct Hash_Data {
	char *key;
	char *value;
	struct Hash_Data *next;
} Hash_Data;

typedef struct {
	Hash_Data **table;
} Hashtable;

Hashtable* create_hashtable();
unsigned int hash(char *key);
Hash_Data* newpair(char *key, char *value);
void set(Hashtable *ht, char *key, char *value);
char* get(Hashtable *ht, char *key);

#endif
