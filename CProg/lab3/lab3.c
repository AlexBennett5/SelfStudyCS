#include <stdio.h>
#include <stdlib.h>
#include "list.h"

int triple(int x) { 
  return x + x + x;
}

int increment(int x) { 
  return x + 1;
}

int main(void) { 
  List *test = cons(5, cons(1, cons(3, cons(2, cons(4, NULL)))));
  print_list(test);

  
  iterate(triple, test);
  print_list(test);

  iterate(increment, test);
  print_list(test);

  int n = sum(test);
  printf("Sum = %d\n", n);
  

  test = msort(test);
  print_list(test);
 
  return 0;
}
  

