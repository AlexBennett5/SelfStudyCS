import numpy as np
import random
from matplotlib import pyplot as plt

def pairs(n):
	arr = np.arange(n)
	np.random.shuffle(arr)
	mid = n//2
	m1 = np.array(arr[:mid])
	m2 = np.array(arr[mid:])
	return (m1, m2)

def kinetic_exchange(v, w):
	vnew = np.add(v,w).astype(float)
	wnew = np.add(v,w).astype(float)
	for k in range(0,len(v)):
		R = random.uniform(0,1)
		vnew[k] = (vnew[k]*R).astype(float)
		wnew[k] = (wnew[k]*(1-R)).astype(float)
	return(vnew, wnew)

def gini(w):
	denom = len(w)*np.sum(w)
	iter = w*np.arange(1,len(w)+1)
	num = 2*np.sum(iter)
	gini = (num/denom) - (1 + (1/len(w)))
	return gini

def sim(N, T):
	gs = np.empty(T, dtype=float)
	v,w = pairs(N)
	for k in range(0,T):
		v,w = kinetic_exchange(v,w)
		z = np.concatenate((v,w))
		z = np.sort(z)
		gs[k] = gini(z)
	z = np.concatenate((v,w))
	z = np.sort(z)
	return (z, gs)
		
def main():
	w,y = sim(500000,30)
	x = np.arange(30)
	

if __name__ == “__main__”:
	main()
