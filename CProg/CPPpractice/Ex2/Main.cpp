#include "Matrix.hpp"
#include "Vector.hpp"

int main() {

	double val1[2][2] = {{5.0,4.5},{3.2,2.7}};
	double val2[2] = {1.0, 1.0};

	Matrix m(val1);
	Vector v(val2);

	Vector v2;
	v2 = m*v;

	v2.print();

	return 0;
}


