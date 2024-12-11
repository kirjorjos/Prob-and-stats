package PlotterAndSalter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Smoother {
	public static void run(int windowValue, String inputFileName, String outputFileName) throws FileNotFoundException {
		File rawData = new File(inputFileName);
		Scanner coordsFile = new Scanner(rawData);
		String smoothedData = "";
		ArrayList<double[]> coords = new ArrayList<double[]>();
		while (coordsFile.hasNextLine()) {
			String line = coordsFile.nextLine();
			String[] coordStrings = line.split(", ");
			double[] coord = {Double.parseDouble(coordStrings[0]), Double.parseDouble(coordStrings[1])};
			coords.add(coord);
		}
		coordsFile.close();
		
		PrintWriter writer = new PrintWriter(new File("salted_coordinates.csv"));
		writer.write(smoothedData);
		writer.flush();
		writer.close();
	}
}
