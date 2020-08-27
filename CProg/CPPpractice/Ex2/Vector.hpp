#ifndef VECTOR_H
#define VECTOR_H

class Vector {

	public:
		Vector();
		Vector(double val[2]);
		Vector(const Vector &v);
		~Vector();
		Vector& operator=(const Vector &v);
		double* getVect();
		void print();
		void allocMem();

		double *arr;

};

#endif

