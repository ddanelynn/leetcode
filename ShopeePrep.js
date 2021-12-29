// parse string "[1, 2, 3, [4, 5], [6]]" to an array [1, 2, 3, [4, 5], [6]]
var stringToArray = function(numString) {
    const result = [];
    let index = 1;
    while (index < numString.length) {
        if (numString.charAt(index) === '[') {
            const newArr = [];
            index++;
            while (numString.charAt(index) !== ']') {
                if (numString.charAt(index) !== ',') {
                    newArr.push(parseInt(numString.charAt(index)));
                }
                index++;
            }
            result.push(newArr);
        } else if (numString.charAt(index) !== ']' && numString.charAt(index) !== ',') {
            result.push(parseInt(numString.charAt(index)));
        }
        index++;
    }
    return result;
}

console.log(stringToArray('[1,2,3,[4,5],[6]]'));
console.log(JSON.parse('[1,2,3,[4,5],[6]]'));


// construct a tree from an array
function TreeNode(val, left, right) {
    this.val = (val===undefined ? 0 : val);
    this.left = (left===undefined ? null : left);
    this.right = (right===undefined ? null : right);
}

var convertToTree = function(nums, root, i) {
    if (i < nums.length) {
        let temp = new TreeNode(arr[i]);
        root = temp;

        root.left = convertToTree(nums, root.left, 2 * i + 1);
        root.right = convertToTree(nums, root.right, 2 * i + 2);
    }
    return root;
}

let root;
let arr = [1, 2, 3, 4, 5, 6];
root = convertToTree(arr, root, 0);

var inOrder = function(root) {
    if (root != null) {
        inOrder(root.left);
        console.log(root.val);
        inOrder(root.right);
    }
}

inOrder(root);


// implement a function findString(str1, str2) which checks 
// if str2 is a substring of str1 and returns the index of the starting character, 
// otherwise return -1

var findString = function(str1, str2) {
    return str1.indexOf(str2);
}

console.log(findString('applepencil', 'pencidss'));

// iterate through array
const myArr = [1, 2, 3, 4];
for (const[index, element] of myArr.entries()) {
    console.log("index " + index + ": " + element);
}

// iterate through object
const myObj = {"apple": 1, "banana": 2};
for (const[key, value] of Object.entries(myObj)) {
    console.log("key " + key + ": " + value);
}