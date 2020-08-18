#include <stdlib.h>
#include <stdio.h>
#include "re.h"

arena_t create_arena(int size) { 
	
      	arena_t arena = malloc(sizeof(arena_t));
      	arena->size = size;
	arena->current = 0;
       	arena->elts = malloc(size * sizeof(Regexp));
	return arena;	

}

void arena_free(arena_t a) { 
	
	free(a->elts);
	free(a);
}

Regexp *re_alloc(arena_t a) { 

	if (a->current < a->size) {
		Regexp *re = a->elts + a->current;
		a->current += 1;
		return re;
	} else {
		return NULL;
	}
}

Regexp *re_chr(arena_t a, char c) { 

	Regexp *re = re_alloc(a);
	
	if (re != NULL) {
		re->type = CHR;
		re->data.chr = c;
		return re;
	}

	return NULL;

}

Regexp *re_alt(arena_t a, Regexp *r1, Regexp *r2) { 

	Regexp *re = re_alloc(a);

	if (re != NULL) {
		re->type = ALT;
		re->data.pair.fst = r1;
		re->data.pair.snd = r2;
		return re;
	}

	return NULL;
}

Regexp *re_seq(arena_t a, Regexp *r1, Regexp *r2) { 

	Regexp *re = re_alloc(a);

	if (re != NULL) {
		re->type = SEQ;
		re->data.pair.fst = r1;
		re->data.pair.snd = r2;
		return re;
	}

	return NULL;
}

int re_match(Regexp *r, char *s, int i) { 

	if (s != NULL && r != NULL) {

		switch (r->type) {
		case CHR:
			if (s[i] == r->data.chr) return i;
			else return -1;
			break;
		case ALT:
			if (re_match(r->data.pair.fst, s, i) != -1 || re_match(r->data.pair.snd, s, i) != -1) return i;
		       	else return -1;
			break;
		case SEQ:
			if (re_match(r->data.pair.fst, s, i) != -1 && 	
	
				//TODO: Finish this function	

		}

	}	

}



void re_print(Regexp *r) { 
  if (r != NULL) { 
    switch (r->type) {
    case CHR: 
      printf("%c", r->data.chr);
      break;
    case SEQ:
      if (r->data.pair.fst->type == ALT) { 
	printf("(");
	re_print(r->data.pair.fst);
	printf(")");
      } else {
	re_print(r->data.pair.fst);
      }
      if (r->data.pair.snd->type == ALT) { 
	printf("(");
	re_print(r->data.pair.snd);
	printf(")");
      } else {
	re_print(r->data.pair.snd);
      }
      break;
    case ALT:
      re_print(r->data.pair.fst);
      printf("+");
      re_print(r->data.pair.snd);
      break;
    }
  } else { 
    printf("NULL");
  }
}    


      
  
