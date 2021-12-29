var minWindow = function(s, t) {
    const needMap = new Map();
    for (let i = 0; i < t.length; i++) {
        if (needMap.has(t.charAt(i))) {
            needMap.set(t.charAt(i), needMap.get(t.charAt(i)) + 1);
        } else {
            needMap.set(t.charAt(i), 1);
        }
    }

    const needMapCount = needMap.size;
    
    const haveMap = new Map();
    for (let i = 0; i < t.length; i++) {
        haveMap.set(t.charAt(i), 0);
    }
    var minWindowSubstring = null;
    var start = 0;
    var end = 0;
    var hasCharCount = 0;

    while (end < s.length) {
        const currChar = s.charAt(end);
        if (haveMap.has(currChar)) {
            haveMap.set(currChar, haveMap.get(currChar) + 1);
            if (haveMap.get(currChar) === needMap.get(currChar)) {
                hasCharCount++;
            }
        }

        while (hasCharCount === needMapCount) {
            const substr = s.substring(start, end + 1);

            if (minWindowSubstring === null || substr.length < minWindowSubstring.length) {
                minWindowSubstring = substr;
            }

            const leftChar = s.charAt(start);
            if (haveMap.has(leftChar)) {
                haveMap.set(leftChar, haveMap.get(leftChar) - 1);
                if (haveMap.get(leftChar) < needMap.get(leftChar)) {
                    hasCharCount--;
                }
            }
            start++;
        }
        end++;
    }
    return minWindowSubstring ?? "";
};

console.log(minWindow("abc", "ab"));