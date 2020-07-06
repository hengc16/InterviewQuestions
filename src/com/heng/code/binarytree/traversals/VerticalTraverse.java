package com.heng.code.binarytree.traversals;

import com.heng.code.binarytree.TreeNode;

import java.util.*;

public class VerticalTraverse {
    public List<Integer> verticalOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        dfs(root, 0, map);
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            res.addAll(entry.getValue());
        }
        return res;
    }
    private void dfs(TreeNode root, int hd, Map<Integer, List<Integer>> map){
        if(root == null) {
            return;
        }
        //get the current hd list
        List<Integer> list = map.get(hd);
        if(list == null) {
            list = new ArrayList<>();
            list.add(root.val);
        }else{
            list.add(root.val);
        }
        //update the current list.
        map.put(hd, list);
        dfs(root.left, hd -1, map);
        dfs(root.right, hd+1, map);
    }

}


/*
*  horizontal distance (hd) from root.
*  left child  has -1 hd from root
*  right child has +1 hd from root
*
*  use map <hd, list<treenode>>  to record all node that has the same hd from original root
*
*
*
* */