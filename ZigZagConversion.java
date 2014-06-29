
public class ZigZagConversion {
	public static String convert(String s, int nRows) {
        if(nRows == 1)
            return s;
        StringBuilder str = new StringBuilder();
        //level 1
        for(int i=0;i<s.length();i+=2*nRows-2)
            str.append(s.charAt(i));
        //level2-Row-1    
        for(int k=1;k<nRows-1;k++){
             for(int q=k;q<s.length();q+=2*nRows-2){
                 str.append(s.charAt(q));
                 if(q+2*(nRows-(k+1)) < s.length())
                    str.append(s.charAt(q+2*(nRows-(k+1))));
             }
        }
        //level Row
        for(int i=nRows-1;i<s.length();i+=2*nRows-2)
            str.append(s.charAt(i));
        
        String t = str.toString();
        return t;
    }
	
	public static void main(String args[]){
		
		System.out.println(convert("ABCDEF", 3));
	}

}

