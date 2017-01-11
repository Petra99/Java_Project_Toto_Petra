import java.util.Arrays;
import java.util.Random;

public class Toto_Project {

	public static void main(String[] args) {
		int[] arrRand = new int[6];
		Random rand = new Random();
		// creating an array with no duplicates
		for (int arrayRandNumGenerator = 0; arrayRandNumGenerator < arrRand.length; arrayRandNumGenerator++) {
			int randNum = rand.nextInt(49) + 1; // 7x7
			arrRand[arrayRandNumGenerator] = randNum;
			for (int duplicateCorrector = 0; duplicateCorrector < arrayRandNumGenerator; duplicateCorrector++) {
				if (arrRand[arrayRandNumGenerator] == arrRand[duplicateCorrector]) {
					arrayRandNumGenerator--; // one step back
					break; // repeat the generation
				}
			}
		}
		System.out.println(Arrays.toString(arrRand));
	}

}
