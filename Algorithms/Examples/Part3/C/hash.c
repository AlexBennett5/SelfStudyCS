#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>
#include "hash.h"

Hashtable* create_hashtable() {
	Hashtable *ht = NULL;
	ht = malloc(sizeof(Hashtable));
	ht->table = malloc(sizeof(Hash_Data*) * HT_SIZE);
	for (int i = 0; i < HT_SIZE; i++)
		ht->table[i] = NULL;
	return ht;
}

unsigned int hash(char *key) {
	unsigned long int hashval = 0;
	unsigned int len = strlen(key);
	for (int i = 0; i < len; i++)
		hashval = hashval * 29 + key[i];	
	return hashval % HT_SIZE;
}

Hash_Data* newpair(char *key, char *value) {
	Hash_Data *newpair;
	newpair = malloc(sizeof(Hash_Data));
	newpair->key = strdup(key);
	newpair->value = strdup(value);
	newpair->next = NULL;
	return newpair;
}

void set(Hashtable *ht, char *key, char *value) {
	unsigned int slot = hash(key);
	Hash_Data *entry = ht->table[slot];
	if (entry == NULL) {
		ht->table[slot] = newpair(key, value);
		return;
	}
	Hash_Data* prev;
	while (entry != NULL) {
		if (strcmp(entry->key, key) == 0) {
			free(entry->value);
			entry->value = strdup(value);
			return;
		}
		prev = entry;
		entry = prev->next;
	}
	prev->next = newpair(key, value);	
}

char* get(Hashtable *ht, char *key) {
	unsigned int slot = hash(key);
	Hash_Data *entry = ht->table[slot];
	if (entry == NULL)
		return NULL;
	while(entry != NULL) {
		if (strcmp(entry->key, key) == 0)
			return entry->value;
		entry = entry->next;
	}
	return NULL;
}

