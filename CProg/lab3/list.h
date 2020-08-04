#ifndef LIST_H
#define LIST_H 
 
struct List { 
  int head;
  struct List *tail;
};

typedef struct List List;


List *cons(int head, List *tail);
List *msort(List *list);


int sum(List *list);

void iterate(int (*f)(int), List *list);

void print_list(List *list);

void move_list(List *list1, List *list2);

List *merge(List *list1, List *list2);

void split(List *list, List **list1, List **list2);

#endif
