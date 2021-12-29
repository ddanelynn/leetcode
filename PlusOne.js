var plusOne = function(digits) {
    var index = digits.length - 1;
    while (digits[index] === 9) {
        
        if (index === 0) {
            digits[index] = 0;
            digits.splice(0, 0, 1);
            return digits;
        }
        digits[index] = 0;
        index--;
    }

    digits[index]++;
    return digits;
    
};

console.log(plusOne([1, 2, 3]))