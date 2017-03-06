package TD1;
import java.util.Random;
public class RandomData {
	public static int[] generate1d(int nbVals, int min, int max){ 
		int[] res= new int[nbVals]; 
		Random generator = new Random(); 
		
		for(int i=0; i != nbVals; ++i){ 
			res[i]= (int)((Math.abs(generator.nextLong())% ((long)max-min))+min); 
			} 
		return res; 
		} 

	public RandomData() {
		// TODO Auto-generated constructor stub
	}
//this constructor you don't need to write it out
	
	 
}
