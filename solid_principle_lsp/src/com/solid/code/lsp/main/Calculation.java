package com.solid.code.lsp.main;

import com.solid.code.lsp.not.follow.Rectangle;
import com.solid.code.lsp.not.follow.Square;

public class Calculation {

	public static void main(String[] args) {

		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(8);
		rectangle.setHeight(6);
		System.out.println(rectangle.calculateArea());
		
		Square square = new Square();
		square.setWidth(8);
		square.setHeight(6);
		System.out.println(square.calculateArea());
		
		
		
	}

}
