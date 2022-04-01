import java.util.*;
public class FF {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solve(new int[][] {{1,4},{3,8},{7,24}})));
		System.out.println(Arrays.toString(solve(new int[][] {{11,13},{5,17},{102,176}})));
		System.out.println(Arrays.toString(solve(new int[][] {{1,5},{2,10},{5,4}})));
	}

	// system of equations problem
	public static int[] solve(int[][] info) {
		//parse info
		int aWater = info[0][0]; int aLabor = info[0][1];
		int bWater = info[1][0]; int bLabor = info[1][1];
		int tWater = info[2][0]; int tLabor = info[2][1];

		try {
			int tDiff, tWaterP, tLaborP;

			//isolate a
			int aWaterP = aWater*bLabor; tWaterP = tWater*bLabor;
			int aLaborP = aLabor*bWater; tLaborP = tLabor*bWater;

			int aDiff = aWaterP-aLaborP; tDiff = tWaterP-tLaborP;
			int a = tDiff/aDiff;

			//isolate b
			int bWaterP = aLabor*bWater; tWaterP = tWater*aLabor;
			int bLaborP = bLabor*aWater; tLaborP = tLabor*aWater;

			int bDiff = bWaterP-bLaborP; tDiff = tWaterP-tLaborP;
			int b = tDiff/bDiff;

			return new int[] {a, b};
		} catch (ArithmeticException ex) {return new int[] {-1, -1};}

	}
}
