package com.heng.code.recursion;

/**
 * Word “book” can be abbreviated to 4, b3, b2k, etc.
 * Given a string and an abbreviation, return if the string matches the abbreviation.
 * example:
 * pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
 */
public class AbbrevationMatching {
    public boolean match(String input, String pattern) {
        // Write your solution here
        if (input == null || pattern == null) {
            return false;
        }
        return helper(input, pattern, 0, 0);
    }

    private boolean helper(String s, String p, int sIndex, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        if (sIndex >= s.length() || pIndex >= p.length()) {
            return false;
        }
        //case 1 , if p i is not digit
        if (p.charAt(pIndex) < '0' || p.charAt(pIndex) > '9') {
            if (s.charAt(sIndex) == p.charAt(pIndex)) {
                return helper(s, p, sIndex + 1, pIndex + 1);
            }
            return false;
        }
        // case 2, if p i is a digit
        int number = 0;
        while (pIndex < p.length() && p.charAt(pIndex) >= '0' && p.charAt(pIndex) <= '9') {
            number = number * 10 + (p.charAt(pIndex) - '0');
            pIndex++;
        }
        return helper(s, p, sIndex + number, pIndex);
    }

    public static void main(String[] args) {
        AbbrevationMatching abbrevationMatching = new AbbrevationMatching();
        boolean test1 = abbrevationMatching.match("sophisticated","s11d");
        boolean test2 = abbrevationMatching.match("dotdog","2d2d");
        System.out.println(test1);
        System.out.println(test2);
    }

}
/*
base case:
if sIndex = s.length  && pIndex == p.length
return true;
if either one's index >= its length
return false;

recursion rule:
 what we do at this level;
 if the p i is not a number
 we compare with the s i  ? do the recursion : return false;

 if the p i is a number
 we need to read the continuous numbers until reach a digit or out of bounds

*/