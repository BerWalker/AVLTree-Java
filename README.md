# AVLTree-Java
A Java implementation of an AVL Tree, created as a university exercise for the Data Structures course, a self-balancing binary search tree that automatically maintains height balance during insertion and deletion operations. This project provides an efficient and robust data structure for applications that require dynamic data management with balanced performance.

## Features

- **Insertion**: Adds nodes while maintaining AVL tree balance.
- **Deletion**: Removes nodes and rebalances the tree.
- **Automatic Balancing**: Ensures the height difference between subtrees remains within a defined limit, optimizing search times.
- **Rotations**: Includes necessary single and double rotations (LL, RR, LR, RL) to maintain balance.

### Code Overview

- **`AVLTree.java`**: Contains the core AVL tree implementation, including methods for insertion, deletion, and automatic balancing.
- **`Node.java`**: Defines the structure of a tree node, including properties for value, height, and links to child nodes.
- **`Main.java`**: Provides example usage of the AVL tree functions, demonstrating insertion and deletion with automatic balancing.

