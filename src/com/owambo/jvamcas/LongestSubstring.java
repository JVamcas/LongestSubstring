package com.owambo.jvamcas;

/***
 * Solution to LeetCode problem:
 *Given a string, print the longest substring without repeating characters.
 *
 * Solution makes use of a sliding window to look for longest substring with no repeated character
 */
public class LongestSubstring {

    public int longestSubstring(String s){
        int i = 0, j = 0, ans = 0;
        StringBuilder builder = new StringBuilder();
        while(j < s.length()){
            if(builder.toString().contains(s.substring(j,j+1))){//check if char is duplicate
                ans = Math.max(ans, j - i);//obtain length of substring before duplicate char
                i++; //advance window by single step
                j = i;//move sweeper back to start of window
                builder = new StringBuilder(s.substring(i,i + 1));
            }else {
                builder.append(s, j, j+1);
            }
            j++;
        }ans = Math.max(ans,j - i);
        return ans;
    }
}
