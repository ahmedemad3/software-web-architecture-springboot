package com.solid.code.lsp.not.follow;

public class Square extends Rectangle {

	public void setWidth(int width) {
		this.width = width;
		this.height = width;
	}

	public void setHeight(int height) {
		this.height = height;
		this.width = height;
	}
}
