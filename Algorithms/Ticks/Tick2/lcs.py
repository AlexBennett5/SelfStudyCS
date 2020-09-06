def table(s1, s2):
    tbl = [[None for j in range(len(s2) + 1)] for i in range(len(s1) + 1)]
    for i in range(len(s1) + 1):
        for j in range(len(s2) + 1):
            if i == 0 or j == 0:
                tbl[i][j] = 0
            elif s1[i-1] == s2[j-1]:
                tbl[i][j] = 1 + tbl[i-1][j-1]
            else:
                tbl[i][j] = max(tbl[i-1][j], tbl[i][j-1])
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
    tbl = table(a, b)
    print(match_length(tbl))
    print(match_string(a, b, tbl))

if __name__ == "__main__":
    main()

