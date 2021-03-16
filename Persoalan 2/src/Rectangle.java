//********************************************************************
// File Name : Rectangle.java 
// Author    : Laras Rasdiyani
// 
//********************************************************************
public class Rectangle extends Shape{
    private double length;
    private double width;

    //----------------------------------
    // Constructor: Sets up the sphere.
    //----------------------------------
    public Rectangle(double lengthRectangle, double widthRectangle) {
        super("Rectangle");
        length = lengthRectangle;
        width  = widthRectangle;
    }
    //-----------------------------------------
    // Returns the surface area of the sphere.
    //-----------------------------------------
    public double area() {
        return length*width;
    }
    //-----------------------------------
    // Returns the sphere as a String.
    //-----------------------------------
    public String toString() {
        return super.toString() + " length is " + length + " and width is " + width;
    }
}