import java.util.*;

public class MinWindow {
	public static String minWindow(String S, String T) {
        int left = S.length();
        int right = S.length();
        HashSet<Character> set = new HashSet<Character>();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        String res = "";
        
        for(int i=0;i<T.length();i++){
            set.add(T.charAt(i));
            map.put(T.charAt(i),null);
        }
        
        
        for(int i=0;i<S.length();i++){
            if(map.containsKey(S.charAt(i))){
                left = Math.min(left,i);
                int k = 0;
                if(map.get(S.charAt(i)) != null){
                    k = map.get(S.charAt(i));
                }
                map.put(S.charAt(i),i);
                if(k == left)
                    left = getmin(map);
                right = i;
                    
                if(!set.isEmpty()){
                    set.remove(S.charAt(i));
                }
                //already find a window
                else{
                	System.out.println(left);
                	System.out.println(right);
                	System.out.println(S.substring(left,right));
                    if(res.equals(""))
                        res = S.substring(left,right+1);
                    else{
                        if(right - left + 1 < res.length())
                            res = S.substring(left,right+1);
                    }
                }
            }
            
                
        }
        return res;
    }
    
    public static int getmin(HashMap<Character,Integer> map){
        int min = Integer.MAX_VALUE;
        for(char c: map.keySet()){
            if(map.get(c) != null)
                min = Math.min(min,map.get(c));
        }
        return min;
    }
    public static void main(String args[]){
    	System.out.println(minWindow("bdab","ab"));
    }

}
