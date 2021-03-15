//********************************************************************
// File Name : Commission.java 
// Author    : Laras Rasdiyani
// 
//********************************************************************
public class Commission extends Hourly{
    double totalSales;
    double commRate;
    
    public Commission(String eName, String eAddress, String ePhone,String socSecNumber, double rate, double commisionRate){
        super(eName,eAddress,ePhone,socSecNumber,rate);
        commRate = commisionRate;
    }
    
    public void addSales(double totSales){
        totalSales = totSales;
    }
    
    public double pay(){
        double payment = super.pay();
        payment += (totalSales*commRate);
        totalSales = 0;
        return payment;
    }
    
    public String toString(){
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}