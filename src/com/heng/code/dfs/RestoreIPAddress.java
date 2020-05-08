package com.heng.code.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by retiring all possible valid IP address combinations.
 * <p>
 * Input:  ”25525511135”
 * <p>
 * Output: [“255.255.11.135”, “255.255.111.35”]
 */
public class RestoreIPAddress {
    public List<String> Restore(String ip) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if (ip == null || ip.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(ip.toCharArray(), 0, 0, sb, res);
        return res;
    }

    private void helper(char[] ip, int level, int offset, StringBuilder sb, List<String> res) {
        if (level == 4) { //4段都处理过了， 看一下长多是否一致， return
            // 因为我们每一段都是valid， 那如果长度一致， 那4段也一定都是valid， +4 是指 4个‘.’ between each 段。
            if (sb.length() == ip.length + 4) {
                res.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        if (offset < ip.length) {  //0 - 9 case
            sb.append(ip[offset]);
            sb.append('.');
            helper(ip, level + 1, offset + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (offset + 1 < ip.length) {  // 10 - 99 case
            char a = ip[offset];
            char b = ip[offset + 1];
            if (a != '0') {
                sb.append(a);
                sb.append(b);
                sb.append('.');
                helper(ip, level + 1, offset + 2, sb, res);
                sb.delete(sb.length() - 3, sb.length()); //删除后3位  吐
            }
        }
        if (offset + 2 < ip.length) {  // 100 - 255 case;
            char a = ip[offset];    //a 只能是1 或者2
            char b = ip[offset + 1]; // b 只能是 [0 4]  except 250- 255
            char c = ip[offset + 2]; // c can be [0 9] except 250 - 255.
            if (a == '1' || a == '2' && b >= '0' && b <= '4' || a == '2' && b == '5' && c >= '0' && c <= '5') {
                sb.append(a).append(b).append(c).append('.');
                helper(ip, level + 1, offset + 3, sb, res);
                sb.delete(sb.length() - 4, sb.length());
            }
        }
    }
}
/*
a valid ip has four integer range from zero to 255.
output all the valid ip combination from the input string.

recursion tree 有多少层，
每层有多少种state

总共有4层， 每层是the range of integer。
每层有多少状态， 3个状态，
  1个digit， 0 - 9
  2个digit， 10 - 99   10位数不能为0
  3个digit。 100 - 255  百位数只能是 0或1， 十位数通常是0-4   个位数通常是0-9， 除了 250 - 255 这个特殊情况。
*/