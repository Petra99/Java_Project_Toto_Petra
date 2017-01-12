
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Toto_Project {

	public static void main(String[] args) {
		int arrLength = 6;
		int[] userNums = new int[arrLength];
		getUsersArr(userNums);
		System.out.println("Вашите числа са: " + Arrays.toString(userNums));
		int[] arrRand = new int[arrLength];
		getArrWithNoDuplicates(arrRand);
		System.out.println("Печелившите числа са: " + Arrays.toString(arrRand));
		checking(userNums, arrRand);
		if (checking(userNums, arrRand) == 1) {
			System.out.println("Вие имате " + checking(userNums, arrRand) + " съвпадениe.");
		} else {
			System.out.println("Вие имате " + checking(userNums, arrRand) + " съвпадения.");
		}
	}

	private static int checking(int[] userNums, int[] randNums) {
		int coincidence = 0;
		for (int i = 0; i < userNums.length; i++) {
			for (int k = 0; k < userNums.length; k++) {
				if (userNums[i] == randNums[k])
					coincidence++;
			}

		}
		return coincidence;
	}

	private static void getUsersArr(int[] arrUser) {
		Scanner input = new Scanner(System.in);
		System.out.println("Въведете вашите 6 числа:");
		for (int userNumCount = 0; userNumCount < arrUser.length; userNumCount++) {
			int userNum = input.nextInt();
			arrUser[userNumCount] = userNum;
		}

	}

	private static void getArrWithNoDuplicates(int[] arrNoDuplicates) {
		Random rand = new Random();
		int maxTotoNumber = 49;
		for (int randNumCount = 0; randNumCount < arrNoDuplicates.length; randNumCount++) {
			int randNum = rand.nextInt(maxTotoNumber) + 1;
			arrNoDuplicates[randNumCount] = randNum;
			for (int arrayIndex = 0; arrayIndex < randNumCount; arrayIndex++) {
				if (arrNoDuplicates[randNumCount] == arrNoDuplicates[arrayIndex]) {
					randNumCount--; // one step back
					break; // repeat the generation
				}
			}
		}

	}

}
