#include <stdio.h>
#include <stdlib.h>
#include "list.h"

List *cons(int head, List *tail) { 
  List *cell = malloc(sizeof(List));
  cell->head = head;
  cell->tail = tail;
  return cell;
}

int sum(List *list) {
  
	if (list->tail == NULL) {
		return list->head;
	} else {
		return list->head + sum(list->tail);
	}

}

void iterate(int (*f)(int), List *list) {
  
	if (list->tail == NULL) {
		list->head = (*f) (list->head);
	} else {
		list->head = (*f) (list->head);
		iterate((*f), list->tail);
	}

}

void print_list(List *list) { 

	while (list->tail != NULL) {

		printf("%d, ", list->head);
		list = list->tail;
	}

	printf("%d\n", list->head);


}

List *merge(List *list1, List *list2) { 
  
	if (list1 == NULL) return list2;
	if (list2 == NULL) return list1;

	if (list1->head < list2->head) {
		list1->tail = merge(list1->tail, list2);
		return list1;
	} else {
		list2->tail = merge(list1, list2->tail);
		return list2;
	}

	return NULL;

}

void move_list(List *list1, List *list2) {

	if (list1 == NULL || list2 == NULL) return;

	if (list1->tail != NULL)
		list1->tail = list1->tail->tail;

	if (list2->tail != NULL)
		list2->tail = list2->tail->tail;

	move_list(list1->tail, list2->tail);

}

void split(List *list, List **list1, List **list2) { 

	*list1 = list;
	*list2 = list->tail;	
	move_list(*list1, *list2);	

}

List *msort(List *list) { 
  if (list == NULL || list->tail == NULL) { 
    return list;
  } else { 
    List *list1;
    List *list2;
    split(list, &list1, &list2);
    list1 = msort(list1);
    list2 = msort(list2);
    return merge(list1, list2);
  }
}
