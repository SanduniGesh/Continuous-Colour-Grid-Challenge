package com.eyepax.colorgridchallenge;

import com.eyepax.colorgridchallenge.model.ColorBlock;
import com.eyepax.colorgridchallenge.service.ColorGridService;

import java.util.Scanner;


public class ColorGridChallengeApplication {

	/**
	 * The Main Method of the Application
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Width of grid: ");
		int widthOfGrid = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter Height of grid: ");
		int heightOfGrid = Integer.parseInt(scanner.nextLine());

		ColorGridService colorGridService = new ColorGridService();
		colorGridService.getInitializedGrid(widthOfGrid, heightOfGrid);
		System.out.println("");
		System.out.println("***************** Random Color Grid ******************");
		colorGridService.printGrid();

		ColorBlock colorBlock = colorGridService.getLargestBlock();
		if (colorBlock != null) {
			System.out.println("");
			System.out.println("***************** The Largest Color Grid ******************");
			colorGridService.printColorBlock(colorBlock);
		}
	}

}
