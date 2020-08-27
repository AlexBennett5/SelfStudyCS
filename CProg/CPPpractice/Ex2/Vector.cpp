#include <cstdio>
#include "Vector.hpp"

Vector::Vector() {

	allocMem();
	arr[0] = 0.0;
	arr[1] = 0.0;
}

Vector::Vector(double val[]) {

	allocMem();
	arr[0] = val[0];
	arr[1] = val[1];
}

Vector::Vector(const Vector &v) {

	allocMem();
	arr[0] = v.arr[0];
	arr[1] = v.arr[1];	

}

Vector::~Vector() {
	delete[] arr;
}

Vector& Vector::operator=(const Vector &v) {
	arr[0] = v.arr[0];
	arr[1] = v.arr[1];
	return *this;
}

void Vector::allocMem() {
	arr = new double[2]; 
}

void Vector::print() {

	printf("%f \n %f", arr[0], arr[1]);

}


