package com.techleads.app.junit.article;

import java.util.Arrays;
import java.util.List;

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	public double getAspectRatio() {
		return (double)width/height;
	}
	
	
	public boolean isSuare() {
		return width==height;
	}
	
	public int getArea() {
		return width*height;
	}
	

	public int[] getSides() {
		return new int[] { width, height};
	}
	
	public List<Integer> getSidesList(){
		return Arrays.asList(width, height);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	

}
