#include <stdio.h>
#include <stdlib.h>
#include "tree.h"


int main(void) { 
  Tree *test = empty;

  printf("Empty tree:\n");
  for (int i = 1; i <= 5; i++) { 
    printf("  member(%d, test) = %d\n", i, tree_member(i, test));
  }

  printf("Inserting 1..5:\n");
  test = tree_insert(1, test);
  test = tree_insert(2, test);
  test = tree_insert(3, test);
  test = tree_insert(4, test);
  test = tree_insert(5, test);

  for (int i = 1; i <= 5; i++) { 
    printf("  member(%d, test) = %d\n", i, tree_member(i, test));
  }

  printf("Removing 1 & 4:\n");
  test = tree_remove(1, test);
  test = tree_remove(4, test);

  for (int i = 1; i <= 5; i++) { 
    printf("  member(%d, test) = %d\n", i, tree_member(i, test));
  }

  printf("Freeing the tree\n");
  tree_free(test);
  return 0;
}
 
