package lab6;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

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
	
}

public class Prob1 {
	
	public static Shape getShape (String shape)
	{
		if (shape.equalsIgnoreCase("shape"))
			return new Circle();
		else if (shape.equalsIgnoreCase("rectangle"))
			return new Rectangle();
		if (shape.equalsIgnoreCase("square"))
			return new Square();
		return null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ok = true;
        //Verificarea relatiilor de mostenire
        Shape obj1;
        obj1 = new Square();
        obj1 = new Rectangle();
        obj1 = new Circle();
        Rectangle obj3 = new Square();
        //Verificarea constructorilor
        Constructor[] allConstructors = Square.class.getDeclaredConstructors();
        if(allConstructors.length != 3) {
            System.out.println("Clasa Square NU are definiti toti constructorii!");
            ok = false;
        }
        Circle circle = new Circle(2.0, "green", true);
        Square square = new Square(5.0, "black", true);
        if(!Modifier.isAbstract(Shape.class.getModifiers())) {
            System.out.println("Clasa Shape NU este abstracta!");
            ok = false;
        }
        if(!Shape.class.isAssignableFrom(Square.class) && !Rectangle.class.isAssignableFrom(Square.class)) {
            System.out.println("Clasele NU respecta relatia de mostenire descrisa!");
            ok = false;
        }
        if(!circle.isFilled() || !circle.getColor().equals("green")) {
            System.out.println("Constructorul din clasa Circle NU este definit conform specificatiilor!");
            ok = false;
        } else if(!square.isFilled() || !square.getColor().equals("black") || square.getWidth() != square.getLength()) {
            System.out.println("Constructorul din clasa Square NU este definit conform specificatiilor!");
            ok = false;
        } else if(ok){
            System.out.println("Au trecut toate testele!");
        }

	}

}
