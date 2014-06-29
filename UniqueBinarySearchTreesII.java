import java.util.*;

public class UniqueBinarySearchTreesII {
	private static int x = 1;
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> tmp = new LinkedList<TreeNode>();
        LinkedList<LinkedList<TreeNode>> res = new LinkedList<LinkedList<TreeNode>>();
        tmp.add(null);
        res.add(new LinkedList<TreeNode>(tmp));
        tmp.clear();
        if(n == 0)
            return res.get(0);
        tmp.add(new TreeNode(1));
        res.add(new LinkedList<TreeNode>(tmp));
        tmp.clear();
        if(n == 1)
            return res.get(1);
        for(int i=2;i<=n;i++){
            for(int k=0;k<=i-1;k++){
                for(int j=0;j<res.get(k).size();j++)
                    for(int t=0;t<res.get(i-1-k).size();t++){
                        TreeNode p = new TreeNode(0);
                        p.left = bincopy(res.get(k).get(j));
                        p.right = bincopy(res.get(i-1-k).get(t));
                        binfillnum(p);
                        x = 1;
                        tmp.add(p);
                    }
            }
            res.add(new LinkedList<TreeNode>(tmp));
            tmp.clear();
        }
        return res.get(n);
        
    }
    public static TreeNode bincopy(TreeNode q){
    	if(q == null)
    		return null;
    	TreeNode l = new TreeNode(q.val);
    	l.left = bincopy(q.left);
    	l.right = bincopy(q.right);
    	return l;
    }
    
    
    public static void binfillnum(TreeNode p){
        if(p == null)
            return;
        
        binfillnum(p.left);
        p.val = x++;
        //System.out.print(p.val);
        binfillnum(p.right);
        
            
    }
    public static void main(String args[]){
    	List<TreeNode> ret = generateTrees(12);  
        for (TreeNode treeNode : ret) {  
            preorder(treeNode);  
            System.out.println();  
        }  
    	
    }
    public static void preorder(TreeNode c){
    	if(c == null)return;
    	System.out.print(c.val);
    	preorder(c.left);
    	preorder(c.right);
    }

}
