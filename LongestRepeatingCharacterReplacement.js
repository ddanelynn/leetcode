var characterReplacement = function(s, k) {
    var maxFrequency = 0;
    var result = 0;
    const count = new Map();
    var left = 0;
    for (let i = 0; i < s.length; i++) {
        if (count.has(s.charAt(i))) {
            count.set(s.charAt(i), count.get(s.charAt(i)) + 1);
        } else {
            count.set(s.charAt(i), 1);
        }

        if (count.get(s.charAt(i)) > maxFrequency) {
            maxFrequency = count.get(s.charAt(i));
        }

        while ((i + 1 - left) - maxFrequency > k) {
            count.set(s.charAt(left), count.get(s.charAt(left)) - 1);
            left++;
        } 
        result = Math.max(result, i + 1 - left);
    }
    return result;
};