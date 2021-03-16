//********************************************************************
// File Name : Shape.java 
// Author    : Laras Rasdiyani
// 
//********************************************************************
public abstract class Shape {
    private String shapeName;
    
    public Shape(String name){
        shapeName = name;
    }
    
    public abstract double area();
    
    public String toString(){
        return this.shapeName;
    }
}