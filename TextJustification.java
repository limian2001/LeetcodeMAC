import java.util.*;


public class TextJustification {
	public static List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        int i = 0;
		int count = L;
		StringBuilder str = new StringBuilder();
		while(i<words.length){
			count = L;
			str.delete(0,str.length());
			while(i<words.length){
				if(words[i].length() <= count){
					str.append(words[i] + " ");
					count -= words[i].length() + 1;
				}
				else{
					res.add(buildline(str,L));
					break;
				}
				i++;
			}
		}
		//last line, delete the last space
		//String k = str.delete(str.length()-1,str.length());
		res.add(str.delete(str.length()-1,str.length()).toString());

		return res;
    }
	
	public static String buildline(StringBuilder s,int L){
		s.delete(s.length()-1,s.length());
		//check whether only one word
				for(int i=0;i<s.length();i++){
				    if(s.charAt(i) == ' ' )
				        break;
				    if(i == s.length() - 1){
				        while(s.length() < L)
				            s.append(" ");
				        return s.toString();
				    }
				
				}
		
		
		while(s.length() < L){
		    for(int i=1;i<s.length() && s.length() < L;i++){
		        if(s.charAt(i) != ' ' && s.charAt(i-1) == ' '){
		            s.insert(i," ");
		            i++;
		        }
		    }
		}
		return s.toString();
		
	
    }
	public static void main(String args[]){
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		System.out.println(fullJustify(words,6));
	}

}
