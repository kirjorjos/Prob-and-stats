package PlotterAndSalter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Salter {
	
	private static Random rand = new Random();

	public static void run(int saltVarienceMax) throws FileNotFoundException {
		File rawData = new File("coordiantes.csv");
		Scanner coordsFile = new Scanner(rawData);
		String saltedData = "";
		while (coordsFile.hasNextLine()) {
			String line = coordsFile.nextLine();
			String[] coordStrings = line.split(", ");
			Double[] coords = {Double.parseDouble(coordStrings[0]), Double.parseDouble(coordStrings[1])};
			double saltValue = rand.nextDouble(saltVarienceMax);
			if (rand.nextInt(2) == 0) {	// 50/50 chance for it to be negative
				saltValue*=-1;
			}
			coords[1]+=saltValue;
			line = coords[0] + ", " + coords[1] + "\n";
			saltedData += line;
		}
		coordsFile.close();
		
		PrintWriter writer = new PrintWriter(new File("salted_coordinates.csv"));
		writer.write(saltedData);
		writer.flush();
		writer.close();
	}
	
}
