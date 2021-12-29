var mySqrt = function(x) {
    if (x === 0) {
        return 0;
    } else if (x < 2) {
        return 1;
    } else {
        var start = 0;
        var end = x/2;

        for (var i = start; i <= end; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                return i;
            } else if ((i + 1) * (i + 1) === x) {
                return i + 1;
            }
        }
    }
};


var mySqrt2 = function(x) {

    if (x === 0 || x === 1) {
        return x;
    }

    let start = 0;
    let end = x;
    let mid = 0;

    while (start + 1 < end) { 
        mid = start + Math.floor((end - start)/2);
        if (mid * mid === x) {
            return mid;
        } 
        
        if (mid * mid > x) {
            end = mid;
        } else {
            start = mid;
        }
    }

    return start;
    

}

console.log(mySqrt2(10));