
public class Sqrtx extends CloneGraph {
	//ALSO can be solved by Newton Law
    public int sqrt(int x) {
        double min = 0;
        double max = x;
        
        while((int)min < (int)max){
            double mid = (min + max)/2;
            if(mid*mid == x)
                return (int)mid;
            else if(mid*mid < x)
                min = mid;
            else
                max = mid;
        }
        
        return (int)min;
    }

}
