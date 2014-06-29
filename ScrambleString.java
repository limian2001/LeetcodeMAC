import java.util.*;

public class ScrambleString {
	
	    public static boolean isScramble(String s1, String s2) {
	        if(s1 == null||s2 == null)
	            return false;
	        if(s1.length() != s2.length())
	            return false;
	        if(s1.length() == 1){
	            if(s1.equals(s2))
	                return true;
	            else
	                return false;
	        }
	            
	        char[] a = s1.toCharArray();
	        char[] b = s2.toCharArray();
	        Arrays.sort(a);
	        Arrays.sort(b);
	        System.out.println(String.valueOf(a));
	        System.out.println(String.valueOf(b));
	        
	        if(!String.valueOf(a).equals(String.valueOf(b)))
	            return false;
	        
	        for(int i=1;i<s1.length();i++){
	            if(isScramble(s1.substring(0,i),s2.substring(0,i)) &&  isScramble(s1.substring(i),s2.substring(i)))
	                return true;
	            if(isScramble(s1.substring(0,i),s2.substring(s2.length() - i)) && isScramble(s1.substring(i),s2.substring(0,s2.length() - i)))
	                return true;
	        }
	        return false;
	        
	        
	    }
	    public static void main(String args[]){
	    	System.out.println(isScramble("aa","aa"));
	    }

}
