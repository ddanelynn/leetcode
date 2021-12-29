// var isValid = function(s) {
//     let stack = [];
//     for (var i = 0; i < s.length; i++) {
//         stack.push(s.charAt(i));
//     }
//     let temp = [];
//     temp.push(stack.pop());
//     while (stack.length) {
//         if (isPair(stack[stack.length - 1], temp[temp.length - 1])) {
//             temp.pop();
//             stack.pop();
//         } else {
//             temp.push(stack.pop());
//         }
//     }
//     if (temp.length) {
//         return false;
//     } else {
//         return true;
//     }
// };

// function isPair(l, r) {
//     if (l === '(' && r === ')') {
//         return true;
//     } else if (l === '[' && r === ']') {
//         return true;
//     } else if (l === '{' && r === '}') {
//         return true;
//     } else {
//         return false;
//     }
// }

var isValid = function(s) {
    const stack = [];
    
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) === '(' || s.charAt(i) === '[' || s.charAt(i) === '{') {
            stack.push(s.charAt(i));
        } else if (s.charAt(i) === ')') {
            if (stack[stack.length - 1] === '(') {
                stack.pop();
            } else {
                return false;
            }
        } else if (s.charAt(i) === ']') {
            if (stack[stack.length - 1] === '[') {
                stack.pop();
            } else {
                return false;
            }
        } else if (s.charAt(i) === '}') {
            if (stack[stack.length - 1] === '{') {
                stack.pop();
            } else {
                return false;
            }
        }
    }

    if (stack.length === 0) {
        return true;
    }
    return false;
};

isValid("(){}[]");
