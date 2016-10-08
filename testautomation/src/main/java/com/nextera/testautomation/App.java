package com.nextera.testautomation;

import org.hibernate.Session;

public class App 
{
    public static void main( String[] args )
    {
      //  System.out.println( "Hello World!" );
      //  Utilities util=new Utilities();
    //    AutomationConstants ac=new AutomationConstants();
    //    String path=ac.Json_File_Path;
        
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Stock stock = new Stock();

        stock.setStockCode("4715");
        stock.setStockName("GENM");

        session.save(stock);
        session.getTransaction().commit();
    }
    
       // Person p=util.JSonToJava(new Person(),path);
 }


/*class People{
	private Person[] listOfPeople;
	
	public void print(){
		for(Person p: listOfPeople){
		System.out.println(p);		
		}
	}
}

*/
class Person{
	private String FirstName;
	private String LastName;
	private Address addr;
	
	public String toString() {
	        return FirstName + "  " + LastName+ "\n"+ addr;
	    }
}

class Address{
	private String Street1;
	private String Street2;
	private String City;
	
	 public String toString() {
	        return Street1 + " , " + Street2 +"\n "+City;
	    }
}