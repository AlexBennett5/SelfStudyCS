import numpy as np
import random
from matplotlib import pyplot as plt

#This is an older and less accurate version of this program. 
#Use EconMobility.py instead

def pairs(n):
	arr = np.arange(n)
	np.random.shuffle(arr)
	mid = n//2
	m1 = np.array(arr[:mid])
	m2 = np.array(arr[mid:])
	return (m1, m2)

def kinetic_exchange(v, w):
        a,b = pairs(len(v)*2)
        c = np.concatenate((v,w))
        vnew = np.array([c[k] for k in a])
        wnew = np.array([c[k] for k in b])
        sumarr = np.add(vnew, wnew)
        for k in range(0,len(v)):
            R = random.uniform(0,1)
            vnew[k] = sumarr[k]*R
            wnew[k] = sumarr[k]*(1.-R)
        return(vnew,wnew)

def gini(w):
        denom = len(w)*np.sum(w)
        comb = w*np.arange(1,len(w)+1)
        num = 2.*np.sum(comb)
        gini = (num/denom) - (1. + (1./len(w)))
        return gini

def sim(N, T):
        gs = np.empty(T, dtype=float)
        v = np.full(N//2, 1.)
        w = np.full(N//2, 1.)
        for k in range(0,T):
                v,w = kinetic_exchange(v,w)
                z = np.concatenate((v,w))
                z = np.sort(z)
                gs[k] = gini(z)
        z = np.concatenate((v,w))
        return (z, gs)
		
def main():
        w,gs = sim(500000,30)
        fig = plt.figure()
        plt.plot(gs)
        fig.suptitle('Gini coefficient')
        plt.xlabel('timestep')
        fig.savefig('test.jpg')
        plt.show()	

if __name__ == "__main__":
	main()
