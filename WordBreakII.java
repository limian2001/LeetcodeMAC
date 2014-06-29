import java.util.*;

public class WordBreakII {
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        if(s.equals(null))
            return res;
            
        //from work break I, has a DP array record T/F in index, here, we DP from end to head (reverse order)
        boolean A[] = new boolean[s.length()];
        
        if(dict.contains(s.substring(s.length()-1)))
            A[s.length()-1] = true;
        else
            A[s.length()-1] = false;
            
        for(int i=s.length()-2;i>=0;i--){
            if(dict.contains(s.substring(i))){
                A[i] = true;
                continue;
            }
            int k = 0;
            for(k=s.length()-1;k>i;k--){
                if(A[k]){
                    if(dict.contains(s.substring(i,k))){
                        A[i] = true;
                        break;
                    }
                    else
                        continue;
                }
            }
        }
        //if last DP array is false, this string can't be broken, return
        if(!A[0])
            return res;
        
        dfs(res,tmp,s,dict,A);
        
        return res;
        
    }
    
    public static void dfs(ArrayList<String> res, StringBuilder tmp, String s, Set<String> dict, boolean[] A){

        if(dict.contains(s)){
                tmp.append(s);
                String k = tmp.toString();
                res.add(k);
                tmp.delete(tmp.length()-s.length(),tmp.length());  //recover tmp to last status is important
                //here, can't insert "return", since the situation: "a aaaa" can be "a a a a a", we should goto next for loop
        }
           
        for(int i=0;i<s.length();i++){
                //use DP array, if the reminder (i+1 to end) is false, it doesn't make sense to continue;
                if(dict.contains(s.substring(0,i)) && A[A.length-(s.length()-i)]){
                    String tmp2 = tmp.toString();
                    tmp.append(s.substring(0,i));
                    tmp.append(" ");
                    dfs(res,tmp,s.substring(i),dict,A);
                    ////recover tmp to last status is important
                    tmp.delete(0,tmp.length());
                    tmp.append(tmp2);
                }
            
        }
    }
    public static void main(String args[])
    {
    Set<String>	dict = new HashSet<String>();
    String t = "";
    
    	dict.add("a");dict.add("aa");dict.add("aaaa");//dict.add("sand");dict.add("dog");
  	  
     System.out.println(wordBreak("aaaaaaa",dict));
     }

}
