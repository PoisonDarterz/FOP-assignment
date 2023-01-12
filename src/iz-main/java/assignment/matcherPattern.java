/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;
class matcherPattern {

    public static void main(String[]args){
      HashSet <String> s = new HashSet<String>();
      
      s.add("a");
      s.add("a");
      s.add("b");
      s.add("b");
      
      System.out.println(s);
      
      
      // .   -> Any character
      // \\w -> Word character (a-z, A-Z, 0-9)
      // \\W -> Not a word character
      // \\s -> whitespace character
      // \\S -> Non-whitespace
      // \\d -> Any digits same as to [0-9]
      // \\D -> Non digits
      
 
      String re = "\\W\\W\\W";
      String text = "ada";
      
      Pattern pt = Pattern.compile(re);
      Matcher mt = pt.matcher(text);
      
      boolean result  = mt.matches();
      
      //Alternative method
      boolean result2 = Pattern.matches("\\w\\w","ab");
      
      System.out.println(result);
      System.out.println(result2);
      
    }
}
