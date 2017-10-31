package lab6;

/*

abstract class Shape {
    protected String color;
    protected boolean filled;
    
    public Shape() {
        this("red", true);
    }
    
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isFilled() {
        return this.filled;
    }
    
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
}

class Circle extends Shape {
	public double radius;
	
	public Circle ()
	{
		super();
		this.radius = 3;
	}
	
	public Circle (double radius)
	{
		super();
		this.radius = radius;
	}
	
	public Circle (double radius, String color, boolean filled)
	{
		super(color, filled);
		this.radius = radius;
	}
	
	public void setRadius (double radius)
	{
		this.radius = radius;
	}
	
	public double getRadius ()
	{
		return radius;
	}
	
	public double getArea()
	{
		double area = Math.PI * Math.pow(this.radius, 2);
		return area;
	}
	
	public double getPerimeter ()
	{
		double perimeter = 2 * Math.PI * this.radius;
		return perimeter;
	}
	
	public String toString ()
	{
		String result = "Circle with area of " + getArea() + " and perimeter of " + getPerimeter();
		return result;
	}
}

class Rectangle extends Shape {
	public double width, length;
	
	public Rectangle ()
	{
		super();
		this.width = 4;
		this.length = 6;
	}
	
	public Rectangle (double width, double length)
	{
		super();
		this.width = width;
		this.length = length;
	}
	
	public Rectangle (double width, double length, String color, boolean filled)
	{
		super(color, filled);
		this.width = width;
		this.length = length;
	}
	
	public void setWidth (double width)
	{
		this.width = width;
	}
	
	public double getWidth ()
	{
		return width;
	}
	
	public void setLength (double length)
	{
		this.length = length;
	}
	
	public double getLength ()
	{
		return length;
	}
	
	public double getArea()
	{
		double area = this.length * this.width;
		return area;
	}
	
	public double getPerimeter ()
	{
		double perimeter = 2 * (this.length + this.width);
		return perimeter;
	}
	
	public String toString ()
	{
		String result = "Rectangle with area of " + getArea() + " and perimeter of " + getPerimeter();
		return result;
	}
}

class Square extends Rectangle {
	
	public Square ()
	{
		super();
	}
	
	public Square (double side)
	{
		this.color = "red"; 
		this.filled = true;
		this.width = side;
		this.length = side;
	}
	
	public Square (double side, String color, boolean filled)
	{
		this.color = color; 
		this.filled = filled;
		this.width = side;
		this.length = side;
	}
	
	public void setWidth (double side)
	{
		this.width = side;
	}
	
	public void setLength (double side)
	{
		this.length = side;
	}
	
	public void setSide (double side)
	{
		this.length = side;
		this.width = side;
	}
	
	public double getSide ()
	{
		return length;
	}
	
	public String toString ()
	{
		String result = "Rectangle with area of " + getArea() + " and perimeter of " + getPerimeter();
		return result;
	}
	
} */

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Circle c1 = new Circle();
		Square sq; /* eroare de compilare
		if (c1 instanceof Square)
			sq = (Square) c1; */
		
		Rectangle r = new Rectangle (5.0,5.0);
		if (r instanceof Square)
			sq = (Square) r; //upcasting
		System.out.println("kek");
		sq = new Square(7.0);
		r = sq; //downcasting
	}

}
