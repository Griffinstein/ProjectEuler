/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

/**
 *
 * @author Ed
 */
public class TreeNode {
    private TreeNode left = null;
    private TreeNode right = null;
    private TreeNode parent = null;
    private int value;
    private int sumValue = 0;
    private int level;
    
    public TreeNode(){
        level = 0;
    }
    
    public TreeNode(int x){
        value = x;
    }

    public TreeNode(int x, TreeNode p, int l){
        value = x;
        parent = p;
        level = l + 1;
    }
    
    public void SetLeft(TreeNode l){
        left = l;
    }
    
    public void SetRight(TreeNode r){
        right = r;
    }

    public void SetValue(int x){
        value = x;
    }
    
    public int GetValue(){
        return value;
    }
    
    public int GetSumValue(){
        return sumValue;
    }
    
    public void SetSumValue(int x){
        sumValue = x;
    }

    public void InsertTreeValue(int x){
        if (left == null && right == null)
            InsertLeft(x);
        else if (left != null && right == null)
            InsertRight(x);
    }
    
    public void InsertLeft(int x){
        left = new TreeNode(x, this, level);
    }
    
    public void InsertRight(int x){
        right = new TreeNode(x, this, level);
    }
}
