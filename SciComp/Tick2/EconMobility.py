
import numpy as np
import random
from matplotlib import pyplot as plt

def pairs(n):
	arr = np.arange(n)
	np.random.shuffle(arr)
	m1 = np.array(arr[:n//2])
	m2 = np.array(arr[n//2:])
	return (m1, m2)

def kinetic_exchange(v, w):
        randarr = np.random.random([len(v)])
        vnew = randarr * (v + w)
        wnew = (np.ones(len(v)) - randarr) * (v + w)
        return vnew, wnew

def gini(w):
        w = np.sort(w)
        coeff = np.arange(1, len(w) + 1)
        return (2*(np.sum(coeff*w)))/(len(w)*np.sum(w)) - (1+(1/len(w)))

def sim(N, T):
        z = np.ones(N)
        gs = [gini(z)]
        for k in range(T):
            v, w = pairs(N)
            vnew = np.array([z[v[i]] for i in range(len(v))])
            wnew = np.array([z[w[i]] for i in range(len(w))])
            vnew, wnew = kinetic_exchange(vnew, wnew)
            z = np.concatenate((vnew, wnew))
            gs = gs + [gini(z)]
        return (z, np.array(gs))

def mobility(v,w):
	pct = [20,40,60,80]
	qv = np.array([np.percentile(v, k) for k in pct])
	qw = np.array([np.percentile(w, k) for k in pct])
	indv = np.digitize(v, qv)
	indw = np.digitize(w, qw)
	change = np.subtract(indw, indv)
	count = len(v) - np.count_nonzero(change==1) - np.count_nonzero(change==-1) - np.count_nonzero(change==0)
	return (count/len(v))


def stable_sim(N):
        z = np.ones(N)
        gs = [gini(z)]
        k = 1
        while True:
            if k > 1 and abs(gs[k-1] - gs[k-2]) < 0.001:
                return (z, k-1)
            else:
                v,w = pairs(N)
                vnew = np.array([z[v[i]] for i in range(len(v))])
                wnew = np.array([z[w[i]] for i in range(len(w))])
                vnew,wnew = kinetic_exchange(vnew, wnew)
                z = np.concatenate((vnew, wnew))
                gs = gs + [gini(z)]
                k += 1

def plust_sim(z, t):
        zt = [z]
        for k in range(t):
            v,w = pairs(len(z))
            vnew = np.array([z[v[i]] for i in range(len(v))])
            wnew = np.array([z[w[i]] for i in range(len(w))])
            vnew,wnew = kinetic_exchange(vnew, wnew)
            z = np.concatenate((vnew, wnew))
            zt = zt + [z]
        return zt

def main():
    z,T = stable_sim(500000)
    print("Stabilization time: " + str(T))
    fig = plt.figure()
    zt = plust_sim(z, 30)
    stab = np.array([mobility(z,zt[k]) for k in range(30)])
    plt.plot(stab)
    fig.suptitle('Proportion of those moving >1 quintile')
    plt.xlabel('timestep after gini coefficient stabilizes')
    fig.savefig('test2.jpg')
    plt.show()

if __name__ == "__main__":
	main()

