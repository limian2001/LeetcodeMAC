import java.util.*;

public class SimplifyPath {
	public static String simplifyPath(String path) {
        if(path == null||path.length() == 0)
            return "";
        String[] s = path.split("/");
        if(s.length == 0)
            return "/";
        Stack<String> stk = new Stack<String>();
        for(int i=0;i<s.length;i++){
        	if(s[i].equals(""))
        		continue;
            if(s[i].equals("..")){
            	if(!stk.empty())
            		stk.pop();
            	continue;	
            }
            if(s[i].equals("."))
                continue;
            stk.push(s[i]);
        }
        if(stk.empty())
            return "/";
        StringBuilder res = new StringBuilder();
        while(!stk.empty()){
            String str = stk.pop();
            res.insert(0,str);
            res.insert(0,"/");
        }
        
        return res.toString();
    }
	public static void main(String args[]){
		System.out.println(simplifyPath("/.."));
	}

}
