package com.solid.code.lsp.main;

import com.solid.code.lsp.follow.Rectangle;
import com.solid.code.lsp.follow.Square;

public class Calculation_Refactor {

	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle(8 , 6);
		System.out.println(rectangle.calculateArea());
		
		Square square = new Square(8);
		System.out.println(square.calculateArea());

	}

}
