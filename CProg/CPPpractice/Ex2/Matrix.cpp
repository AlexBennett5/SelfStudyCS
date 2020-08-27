#include <iostream>
#include <cstdio>
#include "Matrix.hpp"
#include "Vector.hpp"

Matrix::Matrix(double val[][2]) {
	
	allocMem();
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			arr[i][j] = val[i][j];
		}
	}
}

Matrix::Matrix(const Matrix &m) {

	allocMem();
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			arr[i][j] = m.arr[i][j];
		}
	}
}

Matrix::~Matrix() {

	delete[] arr[0];
	delete[] arr[1];
	delete[] arr;

}

void Matrix::allocMem() {

	arr = new double*[2];
	arr[0] = new double[2];
	arr[1] = new double[2];

}

Matrix& Matrix::operator=(const Matrix &m) {

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			arr[i][j] = m.arr[i][j];
		}
	}

	return *this;

}

Matrix& Matrix::operator+=(const Matrix &m) {

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			arr[i][j] += m.arr[i][j];
		}
	}
	
	return *this;

}

Matrix operator+(const Matrix &m1, const Matrix &m2) {
	Matrix temp(m1);
	return (temp += m2);
}
                
Matrix& Matrix::operator-=(const Matrix &m) {

	for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                        arr[i][j] -= m.arr[i][j];
                }
        }
        
        return *this;	
}
 
Matrix operator-(const Matrix &m1, const Matrix &m2) {
	Matrix temp(m1);
	return (temp -= m2);
}               
Matrix& Matrix::operator*=(const Matrix &m) {

	double ul = arr[0][0] * m.arr[0][0] + arr[0][1] * m.arr[1][0];
	double ur = arr[0][0] * m.arr[0][1] + arr[0][1] * m.arr[1][1];
	double ll = arr[1][0] * m.arr[0][0] + arr[1][1] * m.arr[1][0];
	double lr = arr[1][0] * m.arr[0][1] + arr[1][1] * m.arr[1][1];

	arr[0][0] = ul;
	arr[0][1] = ur;
	arr[1][0] = ll;
	arr[1][1] = lr;

	return *this;	

}

Matrix operator*(const Matrix &m1, const Matrix &m2) {
	Matrix temp(m1);
	return (temp *= m2);
}

Vector operator*(const Matrix &m, const Vector &v) {

	double res[2] = {0.0, 0.0};

	res[0] = m.arr[0][0] * v.arr[0] + m.arr[0][1] * v.arr[1];
	res[1] = m.arr[1][0] * v.arr[0] + m.arr[1][1] * v.arr[1];
	
	Vector vect(res);
	return vect;
}

Matrix& Matrix::operator/=(const Matrix &m) {

	Matrix inv = inverse(m);
	*this *= inv;
	return *this;

}

Matrix operator/(const Matrix &m1, const Matrix &m2) {
	Matrix temp(m1);
	return (temp /= m2);
}

Matrix Matrix::inverse(const Matrix &m) {

	double val[2][2] = {{m.arr[1][1], -m.arr[0][1]}, {-m.arr[1][0], m.arr[0][0]}};
	double det = 1/((m.arr[0][0]*m.arr[1][1])-(m.arr[1][0]*m.arr[0][1]));

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			val[i][j] *= det;
		}
	}

	Matrix inv(val);
	return inv;

}

void Matrix::print() {

	for (int i = 0; i < 2; i++) {

		printf("%f  %f\n", arr[i][0], arr[i][1]);
	}

}

