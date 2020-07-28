
#This file is slightly different from the maxheap.py in Tick 1

def cmp_simple(x,y):
    return -1 if x<y else (1 if x>y else 0)

def heapify(x, cmp=cmp_simple):
    for k in range(len(x)//2, -1, -1):
        maxheapify(x, k, cmp)

def maxheapify(x, ind, cmp=cmp_simple):
    l = leftchild(ind)
    r = rightchild(ind)
    largest = ind

    if l < len(x) and cmp(x[l], x[ind]) == 1:
        largest = l

    if r < len(x) and cmp(x[r], x[largest]) == 1:
        largest = r

    if largest != ind:
        x[largest], x[ind] = x[ind], x[largest]
        maxheapify(x, largest)

def push(x, e, cmp=cmp_simple):
    return heapify(x + [e], cmp)

def popmax(x, cmp=cmp_simple):
    if len(x) is 0:
        raise IndexError()
    else:
        head = x[0]
        x[0], x[len(x)-1] = x[len(x)-1], x[0]
        del x[-1]
        heapify(x, cmp)
        return head

def popmax_bu(x, cmp=cmp_simple):
    if len(x) is 0:
        raise IndexError()
    else:
        head = x[0]
        x[0], x[len(x)-1] = x[len(x)-1], x[0]
        del x[-1]
        siftdown(x, 0, cmp)

def leafsearch(x, ind, cmp=cmp_simple):
    j = ind
    while rightchild(j) < len(x):
        if cmp(x[rightchild(j)], x[leftchild(j)]) is 1:
            j = rightchild(j)
        else:
            j = leftchild(j)
    if leftchild(j) < len(x):
        j = leftchild(j)
    return j

def siftdown(x, ind, cmp=cmp_simple):
    j = leafsearch(x, ind)
    while cmp(x[ind], x[j]) is 1:
        j = parent(j)
    k = x[j]
    x[j] = x[ind]
    while j > ind:
        k, x[parent(j)] = x[parent(j)], k
        j = parent(j)

def parent(j):
    return (j-1)//2

def leftchild(j):
    return 2*j + 1

def rightchild(j):
    return 2*j + 2

def main():
    a = [1,2,3,2,6,8,5,124,72,234,712,55,42]
    b = [1,2,3,2,6,8,5,124,72,234,712,55,42]
    heapify(a)
    heapify(b)
    popmax(a)
    popmax_bu(b)
    print("Top-down extraction: " + ' '.join(str(e) for e in a))
    print("Bottom-up extraction: " + ' '.join(str(e) for e in b))

if __name__ == "__main__":
    main()

