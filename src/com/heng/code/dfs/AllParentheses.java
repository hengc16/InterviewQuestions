package com.heng.code.dfs;

import java.util.ArrayList;
import java.util.List;

/*
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Assumptions

N > 0
Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 */
public class AllParentheses {
    public List<String> validParentheses(int n) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0,0,n,sb,res);
        return res;
    }
    private void helper(int left, int right, int n, StringBuilder sb, List<String> res) {
        //base case
        if(left == n && right == n){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append('(');
            helper(left + 1, right, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(')');
            helper(left, right + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

  /*
  来分析一下；
  有多少层，分多少叉， 每层干什么
  有n层， 分2个叉， 看是加左括号（ 还是右括号
                []
              /     \
            [(,]     [不能加右]
          /      \
        [(,(,]      [(,)]
        /  \      /  \
     [((]   [(()]    [()(]
          / \     /
           [(())]  [()()]
   */