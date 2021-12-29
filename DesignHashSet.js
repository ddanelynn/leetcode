/**
 * Initialize your data structure here.
 */
 var MyHashSet = function() {
    this.MyHashSet = [];
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
    for (var i = 0; i < this.MyHashSet.length; i++) {
        if (this.MyHashSet[i] === key) {
            return;
        }
    }
    this.MyHashSet.push(key);
    
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
    for (var i = 0; i < this.MyHashSet.length; i++) {
       if (this.MyHashSet[i] === key) {
           this.MyHashSet.splice(i, 1);
       }
    }
};

/**
 * Returns true if this set contains the specified element 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
    var isHere = false;
    for (var i = 0; i < this.MyHashSet.length; i++) {
        if (this.MyHashSet[i] === key) {
            isHere = true;
        }
    }
    return isHere;
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */

let hs = new MyHashSet();

console.log(hs.add(1));
console.log(hs.add(2));
console.log(hs.contains(1));
console.log(hs.contains(3));
console.log(hs.remove(1));
console.log(hs.contains(2));
