

//Q8: First common ancester
//Method I
TreeNode commonancester(TreeNode root, TreeNode p, TreeNode q){
	//check if the treenode p and treenode q exists.
	if(!check_exist(TreeNode root, TreeNode p) || !check_exist(TreeNode root, TreeNode q)){
		return null;
	}
	else{
		return findancesterhelper(root,p,q);
	}
}

TreeNode findancesterhelper(TreeNode root, TreeNode p, TreeNode q){
	if(root == null || root == p || root == q){
		return root;
	}
	boolean isponleft = check_exist(root.left,p);
	boolean isqonleft = check_exist(root.left,q);

	if (isponleft != isqonleft) return root;
	TreeNode childnode = isponleft ? root.left:root.right;
	return findancesterhelper(childnode,p,q);
}

boolean check_exist(TreeNode root, TreeNode p){
	if(root == null) return false;
	if(root == p) return true;

	return check_exist(root.left,p) || check_exist(root.right,p);
}
