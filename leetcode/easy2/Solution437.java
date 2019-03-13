package interview.easy2;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by Administrator on 2018/7/7 0007.
 */
public class Solution437 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    // not need to be used
    public Vector<Integer> computePathList(TreeNode root){
        if(root == null){return new Vector<Integer>();}
        if((root.left == null) && (root.right == null)){
            return  new Vector<Integer>(){{add(root.val);}};
        }

        Vector<Integer> leftVector = computePathList(root.left);
        Vector<Integer> rightVector = computePathList(root.right);

        for(int i = 0; i < leftVector.size(); i++){
            leftVector.set(i, leftVector.get(i) + root.val);
        }

        for(int j = 0; j < rightVector.size(); j++){
            rightVector.set(j, rightVector.get(j) + root.val);
        }

        leftVector.addAll(rightVector);
        return leftVector;
    }

    //error
    public int pathSum(TreeNode root, int sum){
        if(root == null){return  0;}
        if((root.left == null) && (root.right == null)){
            if(root.val == sum){return  1;}
            else {return  0;}
        }

        TreeNode p = root;
        return 0;
    }


    //have bugs , error solution
    public  int pathSum1(TreeNode root, int sum){
        if(root == null){return  0;}
        if(root.val == sum){
            return  1;
        }
        return   pathSum1(root.left, sum - root.val) +  pathSum1(root.right, sum - root.val)
                +  pathSum1(root.left, sum) + pathSum1(root.right, sum) ;

    }

    //accepted ----------26ms
    public Vector<TreeNode> travelTree(TreeNode root){
        if(root == null){return  new Vector<TreeNode>();}
        if(root.left == null && root.right == null){
            return  new Vector<TreeNode>(){{add(root);}};
        }
        Vector<TreeNode> leftVector = travelTree(root.left);
        Vector<TreeNode> rightVector = travelTree(root.right);
        leftVector.add(root);
        leftVector.addAll(rightVector);
        return  leftVector;

    }
    public int computeOneNodeSum(TreeNode root, int sum){
        if(root == null){return  0;}
        if(root.val == sum){
            if(root.left != null || root.right != null){
                return  1 + computeOneNodeSum(root.left, 0) + computeOneNodeSum(root.right, 0);
            }else {
                return 1;
            }
        }
        return computeOneNodeSum(root.left, sum - root.val)
                + computeOneNodeSum(root.right, sum - root.val);
    }
    public  int pathSum2(TreeNode root, int sum){
        if(root == null){return 0;}
       Vector<TreeNode> vector = travelTree(root);
        int count = 0;
        for(int i = 0; i < vector.size(); i++){
            count += computeOneNodeSum(vector.get(i), sum);
        }
        return count;
    }


    @Test
    public void  test(){
        TreeNode l1 =  new TreeNode(1);
        TreeNode l21 =  new TreeNode(-2);
        TreeNode l22 =  new TreeNode(-3);
        TreeNode l31 =  new TreeNode(1);
        TreeNode l32 =  new TreeNode(3);
        TreeNode l33 = new TreeNode(-2);
       // TreeNode l34 =  new TreeNode(11);
        TreeNode l41 =  new TreeNode(-1);
        //TreeNode l42 =  new TreeNode(-2);
        //TreeNode l43 =  new TreeNode(1);
        //TreeNode l44 = new TreeNode(1);

        l1.left = l21;
        l1.right = l22;

        l21.left = l31;
        l21.right = l32;

        l22.left = l33;
        //l22.right = l34;

        l31.left = l41;
        //l31.right = l42;

        //l32.left = l43;
        //l33.right = l44;


      System.out.print(pathSum2(l1, -1));


    }
    /*
        test Vector can not add when you travel
     */
    @Test
    public  void test2(){
        Vector<Integer> v1 = new Vector<Integer>(){{add(1);
            add(2); add(3);}};
        for(int i = 0; i < v1.size(); i++){
            v1.add(i * 8);
        }
        for(int j = 0; j < v1.size(); j++){
            System.out.print(v1.get(j) + "  " );
        }

    }
}
