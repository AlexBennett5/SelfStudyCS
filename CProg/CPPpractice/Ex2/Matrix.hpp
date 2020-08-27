#ifndef MATRIX_H
#define MATRIX_H

class Vector;

class Matrix {
	
	public:
		Matrix(double val[][2]);
		Matrix(const Matrix &m);
		~Matrix();
		void allocMem();
		Matrix& operator=(const Matrix &m);
		Matrix& operator+=(const Matrix &m);
		Matrix& operator-=(const Matrix &m);		
		Matrix& operator*=(const Matrix &m);
		Matrix& operator/=(const Matrix &m);		
		Matrix inverse(const Matrix &m);
		void print();	
		
		double **arr;

};

Matrix operator+(const Matrix &m1, const Matrix &m2);
Matrix operator-(const Matrix &m1, const Matrix &m2);
Matrix operator*(const Matrix &m1, const Matrix &m2);
Matrix operator/(const Matrix &m1, const Matrix &m2);
Vector operator*(const Matrix &m, const Vector &v);

#endif

