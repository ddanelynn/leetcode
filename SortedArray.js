var sortArray = function(arr) {
    var flatArr = arr.flat();
    flatArr.sort((a, b) => a - b);
    return flatArr;
}

arr = [[1, 2], [1, 3]];
console.log(sortArray(arr));