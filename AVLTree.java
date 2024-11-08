public class AVLTree {
    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getInfo()) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value > node.getInfo()) {
            node.setRight(insertRecursive(node.getRight(), value));
        }

        return balance(node); // AVL Balancing
    }

    public void remove(int value) {
        root = removeRecursive(root, value);
    }

    private Node removeRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.getInfo()) {
            node.setLeft(removeRecursive(node.getLeft(), value));
        } else if (value > node.getInfo()) {
            node.setRight(removeRecursive(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Replace the value being removed with the smallest value on the right
            Node smallestValueRight = findSmallest(node.getRight()); // Find the smallest value
            node.setInfo(smallestValueRight.getInfo()); // Replace the removed value with the smallest one

            // Remove the old position of the smallest value
            node.setRight(removeRecursive(node.getRight(), smallestValueRight.getInfo()));
        }

        return balance(node); // AVL Balancing
    }

    private Node findSmallest(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.getInfo()) {
            return true;
        }
        if (value < node.getInfo()) {
            return searchRec(node.getLeft(), value);
        } else {
            return searchRec(node.getRight(), value);
        }
    }

    // AVL Tree Helper Methods

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node balance(Node node) {
        int bf = balanceFactor(node);

        if (bf > 1) { // Left imbalance
            if (balanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft())); // Left-right rotation (double right)
            }
            return rotateRight(node);
        }

        if (bf < -1) { // Right imbalance
            if (balanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight())); // Right-left rotation (double left)
            }
            return rotateLeft(node);
        }

        return node;
    }

    private Node rotateRight(Node grandparent) {
        Node parent = grandparent.getLeft();
        Node temp = parent.getRight();

        parent.setRight(grandparent);
        grandparent.setLeft(temp);

        return parent;
    }

    private Node rotateLeft(Node parent) {
        Node grandparent = parent.getRight();
        Node temp = grandparent.getLeft();

        grandparent.setLeft(parent);
        parent.setRight(temp);

        return grandparent;
    }

    public static void printTree(Node node, String prefix) {
        if (node == null) {
            return;
        }

        // Display right nodes
        printTree(node.getRight(), prefix + "    ");

        // Display the current node
        System.out.println(prefix + node.getInfo());

        // Display left nodes
        printTree(node.getLeft(), prefix + "    ");
    }
}
