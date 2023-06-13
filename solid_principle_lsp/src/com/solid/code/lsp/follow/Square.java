package com.solid.code.lsp.follow;

public class Square implements Shape {

    protected int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public int calculateArea() {
        return sideLength * sideLength;
    }
}
