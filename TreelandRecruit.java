public class TreelandRecruit {
    public static class Node {
        int value;
        int maxValue;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
            this.maxValue = value;
            this.leftChild = null;
            this.rightChild = null;

        }
    }

    public static void memorize(Node node) {
        if (node.leftChild != null && node.rightChild != null) {
            if (node.value > node.leftChild.maxValue + node.rightChild.maxValue) {
                if (node.leftChild.leftChild != null && node.leftChild.rightChild != null) {
                    node.maxValue += node.leftChild.leftChild.maxValue +
                            node.leftChild.rightChild.maxValue;
                } else if (node.leftChild.leftChild == null && node.leftChild.rightChild != null) {
                    node.maxValue += node.leftChild.rightChild.maxValue;
                } else if (node.leftChild.rightChild == null && node.leftChild.leftChild != null) {
                    node.maxValue += node.leftChild.leftChild.maxValue;
                }
                if (node.rightChild.leftChild != null && node.rightChild.rightChild != null) {
                    node.maxValue += node.rightChild.leftChild.maxValue +
                            node.rightChild.rightChild.maxValue;
                } else if (node.rightChild.leftChild == null) {
                    node.maxValue += node.rightChild.rightChild.maxValue;
                } else if (node.rightChild.rightChild == null) {
                    node.maxValue += node.rightChild.leftChild.maxValue;
                }
            } else {
                node.maxValue = node.leftChild.maxValue + node.rightChild.maxValue;
            }
        } else if (node.rightChild != null && node.leftChild == null) {
            if (node.value > node.rightChild.maxValue) {
                if (node.rightChild.leftChild != null && node.rightChild.rightChild != null) {
                    node.maxValue += node.rightChild.leftChild.maxValue + node.rightChild.rightChild.maxValue;
                } else if (node.rightChild.leftChild == null && node.rightChild.rightChild != null) {
                    node.maxValue += node.rightChild.rightChild.maxValue;
                } else if (node.rightChild.rightChild == null && node.rightChild.leftChild != null) {
                    node.maxValue += node.rightChild.leftChild.maxValue;
                }
            } else {
                node.maxValue = node.rightChild.maxValue;
            }
        } else if (node.leftChild != null & node.rightChild == null) {
            if (node.value > node.leftChild.maxValue) {
                if (node.leftChild.leftChild != null && node.leftChild.rightChild != null) {
                    node.maxValue += node.leftChild.leftChild.maxValue + node.leftChild.rightChild.maxValue;
                } else if (node.leftChild.leftChild == null && node.leftChild.rightChild != null) {
                    node.maxValue += node.leftChild.rightChild.maxValue;
                } else if (node.leftChild.rightChild == null && node.leftChild.leftChild != null) {
                    node.maxValue += node.leftChild.leftChild.maxValue;
                }
            } else {
                node.maxValue = node.leftChild.maxValue;
            }
        }
    }

    public static void traverse(Node node) {
        if (node == null) {
            return;
        }
        if (node.leftChild != null && node.rightChild != null) {
            traverse(node.leftChild);
            traverse(node.rightChild);
        } else if (node.leftChild == null && node.rightChild != null) {
            traverse(node.rightChild);
        } else if (node.rightChild == null && node.leftChild != null) {
            traverse(node.leftChild);
        }
        memorize(node);
    }

    public static void main(String[] args) {
        Node thirty = new Node(30);
        Node forty = new Node(40);
        Node twentyFour = new Node(24);
        Node four = new Node(4);
        Node twentyOne = new Node(21);
        Node nine = new Node(9);
        Node thirtyTwo = new Node(32);
        Node eight = new Node(8);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);

        thirty.leftChild = forty;
        thirty.rightChild = twentyFour;

        forty.leftChild = four;
        forty.rightChild = twentyOne;

        twentyOne.leftChild = nine;

        twentyFour.leftChild = thirtyTwo;
        twentyFour.rightChild = eight;

        thirtyTwo.leftChild = ten;
        thirtyTwo.rightChild = eleven;

        eleven.leftChild = twelve;

        traverse(thirty);
        System.out.println(thirty.maxValue);
    }
}
