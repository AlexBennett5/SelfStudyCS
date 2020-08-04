#include <stdio.h>
#include "revwords.h"

static char strings[][80] = {
  "University",
  "University of Cambridge",
  "Hello, world",
  " Hello ",
  "University of Cambridge!",
  " University of Cambridge",
  "-$$$!!!-",
  "University-of-Cambridge"
};

int main(void) { 
  for (int i = 0; i < 8; i++) {
    printf("Original: %s\n", strings[i]);
    reverse_words(strings[i]);
    printf("Reversed: %s\n", strings[i]);
  }
  return 0;
}


  
  
