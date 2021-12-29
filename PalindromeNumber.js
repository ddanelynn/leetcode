var isPalindrome = function(x) {
    if (x >= 0) {
        x = x.toString();
        for (var i = 0; i < x.length/2; i++) {
            if (x.charAt(i) !== x.charAt(x.length - i - 1)) {
                return false;
            }
        }
        return true;
    } else {
        return false;
    }
    
}

isPalindrome(121)