var LRUCache = function(capacity) {
    this.capacity = capacity;
    this.map = new Map();
    this.head = new Node();
    this.tail = new Node();
    this.head.next = this.tail;
    this.tail.prev = this.head;
};


LRUCache.prototype.get = function(key) {
    if (!this.map.has(key)) {
        return -1;
    }
    const node = this.map.get(key)
    this.remove(node);
    this.insert(node);
    return node.val;
};


LRUCache.prototype.put = function(key, value) {
    if (this.map.has(key)) {
        var node = this.map.get(key);
        this.remove(node);
        node.val = value;
        this.insert(node);
    } else {
        if (this.map.size === this.capacity) {
            this.map.delete(this.tail.prev.key);
            this.remove(this.tail.prev);
        }
        const node = new Node(key, value);
        this.map.set(key, node);
        this.insert(node);
    }
};

LRUCache.prototype.insert = function(node) {
    const headNext = this.head.next;
    this.head.next = node;
    node.prev = this.head;
    node.next = headNext;
    headNext.prev = node;
}

LRUCache.prototype.remove = function(node) {
    const nodeNext = node.next;
    const nodePrev = node.prev;
    nodePrev.next = nodeNext;
    nodeNext.prev = nodePrev;
}

function Node(key, val, next, prev) {
    this.key = (key===undefined ? null : key);
    this.val = (val===undefined ? null : val);
    this.next = (next===undefined ? null : next);
    this.prev = (prev===undefined ? null : prev);
}

const cache = new LRUCache(2);
cache.put(1, 1);
cache.put(2, 2);
cache.put(3, 3);


