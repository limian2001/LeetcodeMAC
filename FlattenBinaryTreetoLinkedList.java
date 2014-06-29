/*Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
             */
public class FlattenBinaryTreetoLinkedList {
	public static void flatten(TreeNode root) {
        TreeNode head = new TreeNode(0);  //head is for new tree with linked list 
        TreeNode prehead = head;
        preorder(head,root);
        root = prehead.right;
    }
    //transfer root tree to head list
    public static void preorder(TreeNode head,TreeNode root){
        if(root == null){
            return;
        }
        head.left = null;
        head.right = root;
        
        preorder(head.right,root.left);
        
        preorder(head.right,root.right);
        
    }
    
    public static void main(String args[]){
    	TreeNode node = new TreeNode(1);
    	node.left = new TreeNode(2);
    	node.left.left = new TreeNode(3);
    	flatten(node);
    	while(node != null){
    		System.out.println(node.val);
    		node = node.right;
    	}
    	
    	
    }

}
