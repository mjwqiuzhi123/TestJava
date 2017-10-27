/**
 * matches()和lookingAt()的区别
 */
package com.mjw.worm.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;
 
    public static void main( String args[] ){
       pattern = Pattern.compile(REGEX);
       matcher = pattern.matcher(INPUT);
 
       System.out.println("Current REGEX is: "+REGEX);
       System.out.println("Current INPUT is: "+INPUT);
 
       System.out.println("lookingAt(): "+matcher.lookingAt());//匹配子字符串！
       System.out.println("matches(): "+matcher.matches());//完全匹配！
   }
}