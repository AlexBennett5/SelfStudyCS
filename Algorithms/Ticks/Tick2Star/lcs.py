def table_topdown_recursive(s1, s2):
    tbl = [[None for j in range(len(s2) + 1)] for i in range(len(s1) + 1)]
    table_topdown_aux(s1, s2, tbl)
    return tbl

def table_topdown_aux(s1, s2, tbl):
    n, m = len(s1), len(s2)
    if tbl[n][m] is  None:
        if n == 0 or m == 0:
            tbl[n][m] = 0
        elif s1[n-1] == s2[m-1]:
            tbl[n][m] = 1 + table_topdown_aux(s1[:-1], s2[:-1], tbl)
        else:
            tbl[n][m] = max(table_topdown_aux(s1[:-1], s2, tbl), table_topdown_aux(s1, s2[:-1], tbl))
    return tbl[n][m]

def table_topdown_nonrecursive(s1, s2):
    tbl = [[None for j in range(len(s2) + 1)] for i in range(len(s1) + 1)]
    tbl[0][0] = 0
    STACK = []
    STACK.insert(0, ['CALL', len(s1), len(s2), 0, 0])

    while STACK:
        action, n, m, retn, retm = STACK.pop(0)
        if action == 'CALL':
            if n == 0 or m == 0:
                STACK.insert(0, ['RETURN', n, m, 0, 0])
            elif s1[n-1] == s2[m-1]:
                STACK.insert(0, ['RETURN_PLUS_ONE', n, m, n-1, m-1])
                STACK.insert(0, ['CALL', n-1, m-1, 0, 0])
            else:
                STACK.insert(0, ['MAX', n, m, 0, 0])
                STACK.insert(0, ['CALL', n-1, m, 0, 0])
                STACK.insert(0, ['CALL', n, m-1, 0, 0])
        elif action == 'MAX':
            if tbl[n-1][m] > tbl[n][m-1]:
                STACK.insert(0, ['RETURN', n, m, n-1, m])
            else:
                STACK.insert(0, ['RETURN', n, m, n, m-1])
        elif action == 'RETURN_PLUS_ONE':
            tbl[n][m] = 1 + tbl[retn][retm]
        elif action == 'RETURN':
            tbl[n][m] = tbl[retn][retm]
    return tbl

def match_length(tbl):
    return tbl[len(tbl) - 1][len(tbl[0]) - 1]

def match_string(s1, s2, tbl):
    i, j = len(s1), len(s2)
    res = ""
    while i > 0 and j > 0:
        if s1[i-1] == s2[j-1]:
            res = s1[i-1] + res
            i -= 1
            j -= 1
        elif tbl[i-1][j] > tbl[i][j-1]:
            i -= 1
        else:
            j -= 1
    return res

def main():
    a = "xaxbxcxd"
    b = "aabbccdd"
    tbl1 = table_topdown_recursive(a, b)
    print(match_length(tbl1))
    print(match_string(a, b, tbl1))
    tbl2 = table_topdown_nonrecursive(a, b)
    print(match_length(tbl2))
    print(match_string(a, b, tbl2))

if __name__ == "__main__":
    main()
