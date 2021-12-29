var maxProfit = function(prices) {
    var maxProfit = 0;
    var currProfit = 0;
    var start = prices[0];
    
    for (var i = 0; i < prices.length; i++) {
        if (prices[i] < start) {
            start = prices[i];
        } else {
            currProfit = prices[i] - start;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        
    }
    
    return maxProfit;
};