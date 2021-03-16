//********************************************************************
// File Name : Cylinder.java 
// Author    : Laras Rasdiyani
// 
//********************************************************************
public class Cylinder extends Shape{
    private double height;
    private double radius;
    
    public Cylinder(double radiusCylinder, double heightCylinder){
        super("Cylinder");
        radius = radiusCylinder;
        height = heightCylinder;
    }

    public double area() {
        return Math.PI*radius*radius*height;
    }
    
    public String toString(){
        return super.toString() + " of radius is " + radius +" and height is "+ height;
    }
}
