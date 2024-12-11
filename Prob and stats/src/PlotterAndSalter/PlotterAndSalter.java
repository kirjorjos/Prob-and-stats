package PlotterAndSalter;

import java.io.FileNotFoundException;

public class PlotterAndSalter {
	public static void main(String[] args) throws FileNotFoundException {
		final int startX = 0;
		final int endX = 10000;
		final int stepSize = 1;
		
		final int saltVarienceMax = 10;
		
		Plotter.run(startX, endX, stepSize);
		Salter.run(saltVarienceMax);
		Smoother.run(3, "salted_coordiantes.csv", "smoothed_data.csv");
	}
}
