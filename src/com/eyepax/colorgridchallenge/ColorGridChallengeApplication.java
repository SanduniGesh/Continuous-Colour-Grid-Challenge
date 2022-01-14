package com.eyepax.colorgridchallenge;

import com.eyepax.colorgridchallenge.model.ColorBlock;
import com.eyepax.colorgridchallenge.service.ColorGridService;

import java.util.Scanner;


public class ColorGridChallengeApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter WIDTH of grid: ");
		int width = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter HEIGHT of grid: ");
		int height = Integer.parseInt(scanner.nextLine());

		ColorGridService colorGridService = new ColorGridService();
		colorGridService.initializeGrid(width, height);
		System.out.println("color grid............");
		colorGridService.printGrid();

		ColorBlock colorBlock = colorGridService.getLargestBlock();
		System.out.println("color grid............");
		if (colorBlock != null) {
			System.out.println("large color block..............");
			colorGridService.printColorBlock(colorBlock);
		}
	}

}
