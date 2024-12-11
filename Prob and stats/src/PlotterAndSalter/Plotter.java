package PlotterAndSalter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plotter {

	private static ArrayList<double[]> plot(double startX, int endX, double stepSize) {
		ArrayList<double[]> coords = new ArrayList<double[]>();
		for (double i = startX; i < endX; i+=stepSize) {
			double y = Math.pow(i, 2)+3*i+4;
			double[] coord = {i, y};
			coords.add(coord);
		}
		return coords;
	}

	public static void run(int startX, int endX, int stepSize) throws FileNotFoundException {
		File file = new File("coordiantes.csv");
		PrintWriter writer = new PrintWriter(file);
		String line = "";
		ArrayList<double[]> coords = plot(startX, endX, stepSize);
		
		for (double[] coord : coords) {
			line += coord[0] + ", " + coord[1] + "\n";
		}
		
		writer.write(line);
		writer.flush();
		writer.close();
	}
	
}
