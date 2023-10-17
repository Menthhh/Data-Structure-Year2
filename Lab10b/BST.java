//Tonkla Pokaew 65011610


public class BST {
    TreeNode root;
    public BST() { root = null; }
    public TreeNode getRoot() {
        return root;
    }
    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null)
                        cur = cur.left;
                    else {
                        /*Your code 1 */
                        cur.left = new TreeNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                    } else { //! (d < p.data)
                        /*Your code 2 */
                    if (cur.right != null)
                        cur = cur.right;
                    else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                   
                }
            } //while
        }
    } //insert by iteration

    public void printPreOrder() {
        printPreOrderRecurse(root);
    }

    private void printPreOrderRecurse(TreeNode node) {
        /* your code 3*/
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);

    }

    public void printInOrder() {
        printInOrderRecurse(root);
    }

    private void printInOrderRecurse(TreeNode node) {
        /* your code 4*/
        if (node == null)
            return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
    }
    
    private void printPostOrderRecurse(TreeNode node) {
        /* your code 5*/
        if (node == null)
            return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.print(node.data + " ");
    }
    
    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
        }
        public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null) return null;
        if (d == n.data) return n;
         /* your code 7*/
        if (d < n.data) return searchRecurse(d, n.left);
        return searchRecurse(d, n.right);
    }

    public TreeNode searchIter(int key) { 
        if (root.data == key) 
        return root;
        TreeNode current = root;
        while (current != null) {
            if (key < current.data) { 
            if (current.left != null) 
                current = current.left;
            } else { 
                if (current.right != null) 
                    current = current.right;
            }
            if (current.data == key) 
                return current;
            /*your code 8 */
            else if (key < current.data) {
                // If key is less than current node's data, go left
                current = current.left;
            } else {
                // If key is greater than current node's data, go right
                current = current.right;
            }
        } //while 
        return null;
    }
       
    public int height() {
        return root == null ? 0 : height(root);
        }
        public int height(TreeNode node) {
        if (node == null)
        return 0;
        /* your code 9*/
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public TreeNode findMaxFrom(TreeNode subtreeHead) {
        /* your code 10 */
        TreeNode current = subtreeHead;
        while (current.right != null)
            current = current.right;
        return current;
    }

    public void delete(int d, TreeNode current) {
        if (current == null) return; // not found
        
        if (d < current.data)
            delete(d, current.left);
        else if (d > current.data)
            delete(d, current.right);
        else { // found ... time to delete
            if (current.left == null || current.right == null) { // 0 or 1 child
                TreeNode q = (current.left == null) ? current.right : current.left;
                if (current.parent == null) {
                    root = q; // Update the root if the current node is the root
                } else if (current.parent.left == current) {
                    current.parent.left = q; // this node is the left child
                } else {
                    current.parent.right = q;
                }
                if (q != null) q.parent = current.parent;
            } else { // two children
                TreeNode q = findMaxFrom(current.left);
                /* Your code 11 */
                current.data = q.data;
                delete(q.data, q);
            } // two children
        } // found
    }

    public static void demo1() {
        System.out.println("Demo 1");
        System.out.println("======");
        int [] data = {2,1,3,4,5,6,7,8,9};
        BST bst = new BST();
        for (int j = 0; j < data.length; j++)
        bst.insert(data[j]);
        
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        bst = new BST();
        for (int j = 0; j < dat.length; j++)
        bst.insert(dat[j]);
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());
    }

    public static void demo2() {
        System.out.println("Demo 2");
        System.out.println("======");
        int [] data = {2,1,3,4,5,6,7,8,9};
        BST bst_1 = new BST();
        for (int j = 0; j < data.length; j++){
            bst_1.insert(data[j]);
        }
        bst_1.printInOrder();
        System.out.println("Tree height = " + bst_1.height());
        System.out.println("node with max value " + bst_1.findMaxFrom(bst_1.getRoot()));

        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++){
            bst.insert(dat[j]);
        }
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());
        System.out.println("node with max value " + bst.findMaxFrom(bst.getRoot()));
    }

    public static void demo3() {
        System.out.println("Demo 3");
        System.out.println("======");
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++) {
            bst.insert(dat[j]);
        }
        
        bst.delete(12, bst.getRoot()); // Delete the node with value 12
        System.out.println(bst.search(20)); // Should print: 18<-20->25
        System.out.println(bst.search(25)); // Should print: null<-25->30
        System.out.println(bst.search(16)); // Should print: null<-16->null
        System.out.println(bst.search(10)); // Should print: 8<-10->null
        System.out.println(bst.search(12)); // Should print: not found
    }
    
    
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }
}