
def heapify(x):
    for k in range(len(x)//2, -1, -1):
        maxheapify(x, k)

def maxheapify(x, ind): 
    
    l = 2*ind + 1
    r = 2*ind + 2
    largest = ind
        
    if l < len(x) and x[l] > x[ind]:
        largest = l

    if r < len(x) and x[r] > x[largest]:
        largest = r

    if largest != ind:
        x[largest], x[ind] = x[ind], x[largest]
        maxheapify(x, largest)     
        
def push (x, e):
    return heapify(x + [e])

def popmax(x):
    if len(x) is 0:
        raise IndexError()
    else:
        head = x.pop(0)
        heapify(x)
        return head

def main():
    test = [1,12,23,56,2,3,2,7,9,8,6,4,2,31,5,3,4]
    print("Pre-heapify: " + ' '.join(str(e) for e in test))
    heapify(test)
    print("Post-heapify: " + ' '.join(str(e) for e in test))
    push(test, 5)
    print("Push 5: " + ' '.join(str(e) for e in test))
    popmax(test)
    print("Remove max: " + ' '.join(str(e) for e in test))

if __name__ == "__main__":
    main()
