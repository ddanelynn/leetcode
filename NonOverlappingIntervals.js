var eraseOverlapIntervals = function(intervals) {
    intervals.sort((a, b) => {
        if (a[0] === b[0]) {
            return a[1] - b[1];
        } else {
            return a[0] - b[0];
        }
    }) 
    
    var res = 0;
    var preEnd = intervals[0][1];
    for (var i = 1; i < intervals.length; i++) {
        if (intervals[i][0] >= preEnd) {
            preEnd = intervals[i][1];
        } else {
            res++;
            preEnd = Math.min(preEnd, intervals[i][1]);
        }
    }
    return res;
};