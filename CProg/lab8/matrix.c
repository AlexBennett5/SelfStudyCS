#include "matrix.h"
#include <stdbool.h>

matrix_t matrix_create(int rows, int cols) { 

	double *elts = malloc(rows * cols * sizeof(double));	
  	matrix_t m = {rows, cols, elts};
	return m;
}

double matrix_get(matrix_t m, int r, int c) { 
  	
	assert(r < m.rows && c < m.cols);
  	int index = (m.cols * r) + c;
	return m.elts[index];
}

void matrix_set(matrix_t m, int r, int c, double d) { 
  
	assert(r < m.rows && c < m.cols);
	int index = (m.cols * r) + c;
	m.elts[index] = d;
}


void matrix_free(matrix_t m) { 

	free(m.elts);
}

matrix_t matrix_multiply(matrix_t m1, matrix_t m2) { 
  
 	matrix_t m = matrix_create(m1.rows, m2.cols);

	for (int i = 0; i < m1.rows; i++) {
		for (int j = 0; j < m2.cols; j++) {

			double sum = 0.0;

			for (int k = 0; k < m1.cols; k++) {

				sum += matrix_get(m1, i, k) * matrix_get(m2, k, j);
			}

			matrix_set(m, i, j, sum);

		}

	}

	return m;
}

matrix_t matrix_transpose(matrix_t m) { 
  
 	matrix_t t = matrix_create(m.cols, m.rows);

	for (int i = 0; i < m.rows; i++) {
		for (int j = 0; j < m.cols; j++) {
		
			double val = matrix_get(m, i, j);
			matrix_set(t, j, i, val);
		}
	}	
	
	return t;
}

matrix_t matrix_multiply_transposed(matrix_t m1, matrix_t m2) { 
  	
	assert(m1.cols == m2.cols);

 	matrix_t m = matrix_create(m1.rows, m2.rows);

        for (int i = 0; i < m1.rows; i++) {
                for (int j = 0; j < m2.rows; j++) {

                        double sum = 0.0;

                        for (int k = 0; k < m1.cols; k++) {

                                sum += matrix_get(m1, i, k) * matrix_get(m2, j, k);
                        }

                        matrix_set(m, i, j, sum);

                }

        }

        return m;	
}

matrix_t matrix_multiply_fast(matrix_t m1, matrix_t m2) { 
	
	assert(m1.cols == m2.cols);
  	matrix_t m2_t = matrix_transpose(m2);
  	matrix_t res =  matrix_multiply_transposed(m1, m2_t);
	matrix_free(m2_t);
	return res;
}

void matrix_print(matrix_t m) { 
  for (int i = 0; i < m.rows; i++) { 
    for (int j = 0; j < m.cols; j++) { 
      printf("%g\t", matrix_get(m, i, j));
    }
    printf("\n");
  }
  printf("\n");
}


