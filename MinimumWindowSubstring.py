def minWindow(s, t):
    """
    :type s: str
    :type t: str
    :rtype: str
    """

    needMap = {}
    for c in t:
        if c in needMap:
            needMap[c] += 1
        else:
            needMap[c] = 1
    
    needMapSize = len(needMap)

    haveMap = {}
    for c in t:
        haveMap[c] = 0
    
    minSubstring = None
    start = 0
    end = 0
    haveCharCount = 0

    while end < len(s):
        currChar = s[end]
        if currChar in haveMap:
            haveMap[currChar] += 1
            if needMap[currChar] == haveMap[currChar]:
                haveCharCount += 1
        while haveCharCount == needMapSize:
            subS = s[start : end + 1]
            if not minSubstring or len(subS) < len(minSubstring):
                minSubstring = subS
            leftChar = s[start]
            if leftChar in haveMap:
                haveMap[leftChar] -= 1
                if haveMap[leftChar] < needMap[leftChar]:
                    haveCharCount -= 1
            start += 1
        end += 1

    if not minSubstring:
        return ""
    return minSubstring

def main():
    s = "ADOBECODEBANC"
    t = "ABC"
    minWindow(s, t)

if __name__ == "__main__":
    main()