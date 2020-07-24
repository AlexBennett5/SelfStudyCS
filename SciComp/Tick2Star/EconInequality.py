
import numpy as np
import random
from matplotlib import pyplot as plt

def pairs(n):
    arr = np.arange(n)
    np.random.shuffle(arr)
    m1 = np.array(arr[:n//2])
    m2 = np.array(arr[n//2:])
    return (m1, m2)

#Update functions

def kinetic_exchange(v, w):
    randarr = np.random.random([len(v)])
    vnew = randarr * (v + w)
    wnew = (np.ones(len(v)) - randarr) * (v + w)
    return vnew, wnew

def slow_exchange(v, w):
    randarr = np.random.uniform(low=-1.0, high=1.0, size=len(v))
    vnew = v + randarr*np.minimum(v,w)
    wnew = w - randarr*np.minimum(v,w)
    return vnew, wnew

# Metric functions

def gini(w):
    w = np.sort(w)
    coeff = np.arange(1, len(w) + 1)
    return (2*(np.sum(coeff*w)))/(len(w)*np.sum(w)) - (1+(1/len(w)))

def topk(w, p):
    q = np.percentile(w, p)
    top = np.array([w[i] for i in range(len(w)) if w[i] >= q])
    return np.sum(top)/np.sum(w)

#####

def sim(w0, T, update, metrics):
    if isinstance(w0, int):
        w = np.ones(w0)
    else:
        w = w0
    res = [[metrics[k](w) for k in range(len(metrics))]]
    for k in range(T):
        a,b = pairs(len(w))
        anew = np.array([w[a[i]] for i in range(len(a))])
        bnew = np.array([w[b[i]] for i in range(len(b))])
        anew,bnew = update(anew, bnew)
        w = np.concatenate((anew,bnew))
        res = res + [[metrics[k](w) for k in range(len(metrics))]]
    return (w, res)

def tax(N, T, pct):
    z = np.ones(N)
    for k in range(T):
        v,w = pairs(N)
        vnew = np.array([z[v[i]] for i in range(len(v))])
        wnew = np.array([z[w[i]] for i in range(len(w))])
        vnew, wnew = slow_exchange(vnew, wnew)
        z = np.concatenate((vnew,wnew))
        tax = z * pct
        z -= tax
        rev = np.sum(tax)/len(z)
        z += rev
    return z

def main():
    w, res = sim(500000, 30, slow_exchange, [gini])
    print("W/out taxes top 1% owns: " + str(topk(w, 1)))
    w = tax(500000, 30, 0.4)
    print("W/ 40% tax the top 1% owns: " + str(topk(w,1)))

if __name__ == "__main__":
    main()

