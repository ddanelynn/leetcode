var groupAnagrams = function(strs) {
    const result = [];
    
    const map = new Map();
    for (let i = 0; i < strs.length; i++) {
        const currStr = strs[i];
        const count = new Array(26);
        count.fill(0);
        for (let j = 0; j < currStr.length; j++) {
            const intA = 'a'.charCodeAt(0);
            count[currStr.charAt(j).charCodeAt(0) - intA]++;
        }

        const mapKey = JSON.stringify(count);

        if (map.has(mapKey)) {
            map.get(mapKey).push(currStr);
        } else {
            map.set(mapKey, [currStr]);
        }
    }

    map.forEach((value) => {
        result.push(value);
    })

    return result;
};

console.log(groupAnagrams(["eat","tea","tan","ate","nat","bat"]));