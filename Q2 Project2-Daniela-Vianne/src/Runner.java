import java.lang.reflect.Array;

public class Runner {
	
public static void main(String[] args) {
	int x=20;
	int y=30;
	String a="a";
	double[] scores= new double[10];
		scores[0]=10;//first element
		scores [9]=13;//last element
		scores[scores.length -1]=13;// only do if don't know length of array
		
		int []results = new int[31];
		for (int i = 0; i < results.length; i++) {
			results[i]=(int)(Math.random()*50034);
		}
		
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
}
}
