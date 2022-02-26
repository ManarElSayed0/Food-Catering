
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcatering;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.lang.Exception;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;




/**
 *
 * @author ghada
 */
/**This Class contain the main function*/
public class FoodCatering {

    /**
     * @param args the command line arguments
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException  {
        // TODO code application logic here
        System.out.println("\t\t\t\t\t\t Weclome Here We Have many Italian Food \n ");
       
        Menu m=new Menu();
        m.Display();
        
        Customer c[]=new Customer[4];
        c[0]=new Loyal();
        c[1]=new Guest();
        c[2]=new Guest();
        c[3]=new Loyal();      
        

       
                //FIRST ORDER
               ((Loyal)c[0]).CreateOrder(m.Drink[0]);
               ((Loyal)c[0]).CreateOrder(m.MainDish[2]);
               ((Loyal)c[0]).CreateOrder(m.Dessert[3]);
               ((Loyal)c[0]).O.setDeliveryAddress("Alexandria");
               ((Loyal)c[0]).CreateOrder(1);
               ((Loyal)c[0]).UpdateOrder(m.Drink[1]);
               ((Loyal)c[0]).UpdateOrder(5);
                ((Loyal)c[0]).O.DisplayOrder();   
               
                
                //SECOND ORDER
              
               ((Guest) c[1]).CreateOrder(m.Appetizer[2]);               
               ((Guest) c[1]).CreateOrder(m.Drink[2]);
               ((Guest) c[1]).AddToWishlist(m.MainDish[3]);
               ((Guest) c[1]).AddToWishlist(m.Dessert[3]);   
               ((Guest)c[1]).O.setDeliveryAddress("Cairo");
               ((Guest)c[1]).O.setDeliveryDate(1);
               ((Guest) c[1]).CreateOrder(2); 
               ((Guest)c[1]).O.DisplayOrder();
               
                //THIRD ORDER
                ((Guest)c[2]).CreateOrder(m.Appetizer[3]);
                ((Guest)c[2]).CreateOrder(m.Appetizer[2]);
                ((Guest)c[2]).CreateOrder(m.MainDish[0]);
                ((Guest)c[2]).CreateOrder(m.Drink[1]);
                ((Guest)c[2]).CreateOrder(3);
                ((Guest)c[2]).Delete(m.Appetizer[3]);
                ((Guest)c[2]).CancelOrder(1);
                ((Guest)c[2]).O.setDeliveryAddress("Obour");
                ((Guest)c[2]).O.setDeliveryDate(2);                               
                ((Guest)c[2]).O.DisplayOrder();
                
               
                //FOURTH ORDER
                ((Loyal)c[3]).CreateOrder(m.MainDish[2]);
                ((Loyal)c[3]).CreateOrder(m.Drink[2]);
                ((Loyal)c[3]).CreateOrder(m.Dessert[1]);
                ((Guest)c[2]).CreateOrder(4);
                ((Loyal)c[3]).O.setDeliveryAddress("10th of Ramadan City");
                ((Loyal)c[3]).O.setDeliveryDate(3);                
                ((Loyal)c[3]).ReportIssue("Pasta not found in the menu");
                ((Loyal)c[3]).O.DisplayOrder();
                
                
                
            }
                    
                
        }
    
/**this class contain all important data for the food item*/ 
  class Food{
    String Name;
    String Category;
    String Calories;
    double Price;
    int Portion;
    int ItemID;
    //static data member
     static int Counter=0;
        
    Food(){
        Name=Category=Calories="";
        Counter++;
        ItemID=Counter;
        
    }  
    Food(String Name,String Category,String Calories,int Portion,double Price){
        this.Name=Name;
        this.Category=Category;
        this.Calories=Calories;
        this.Portion=Portion;
        this.Price=Price;
    }
/**this is the setter of variable name*/
    public String getName() {
        return Name;
    }
/**this is getter of variable name*/
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getCalories() {
        return Calories;
    }

    public void setCalories(String Calories) {
        this.Calories = Calories;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getPortion() {
        return Portion;
    }

    public void setPortion(int Portion) {
        this.Portion = Portion;
    }      
    
    
   
}
/**This is Class Contains all food item that the customer can choose from to make order*/
  class Menu{
     Food[]Appetizer=new Food[4];
     Food[]MainDish=new Food[4];
     Food[] Dessert=new Food[4];
     Food[] Drink=new Food[4];
    
    public Menu(){
        PopulateMenu();
    }
    //Final Method
    /**Final Method that Contain array items*/
    public final void PopulateMenu(){        
        //Name,Category,Calories,Portion,Price
    	
        //appetizers
    	Food f1=new Food("Minestrone e Francobolli","Appetizer","20-30 ",3,0);
    	Appetizer[0]=f1;
    	Food f2= new Food("Spicy Kobe Meatballs","Appetizer","15-30 ",3,0);
    	Appetizer[1]=f2;
    	Food f3=new Food("Callimari ai Ferri","Appetizer","10-20 ",1,100);
    	Appetizer[2]=f3;
    	Food f4=new Food("Carpacio di piemontese","Appetizer","10-20 ",2,70);
    	Appetizer[3]=f4;   
       
         
        //MainDishs
    	Food f5=new Food("Margarita                ","Main Dish","60-70 ",1,70);
    	MainDish[0]=f5; 
    	Food f6=new Food("Pizza                    ","Main Dish","30-40 ",3,90);
    	MainDish[1]=f6;
    	Food f7=new Food("Chicken Marsala          ","Main Dish","40-50 ",2,50);
    	MainDish[2]=f7; 
    	Food f8=new Food("Calzone                  ","Main Dish","70-80 ",1,30);
    	MainDish[3]=f8;        
                
        //Dessrt
    	Food f9=new Food("Cannoli               ","Dessert","5-10 ",2,10);
    	Dessert[0]=f9;
    	Food f10=new Food("Zeppoli               ","Dessert","5-10 ",1,15);
    	Dessert[1]=f10;
    	Food f11=new Food("Ice Cream             ","Dessert","5-10 ",1,5);
    	Dessert[2]=f11;
    	Food f12=new Food("pudding               ","Dessert","5-10 ",1,10);
    	Dessert[3]=f12;      
        
         
        //Drink
    	Food f13=new Food("Espresso                 ","Drink","5-10 ",1,0);
    	Drink[0]=f13;
    	Food f14=new Food("Latte                    ","Drink","5-10 ",1,25);
    	Drink[1]=f14;
    	Food f15=new Food("Italian Soda             ","Drink","5-10 ",1,10);
    	Drink[2]=f15;
    	Food f16=new Food("Lemonade                 ","Drink","5-10 ",1,30);
         Drink[3]=f16;
    }
    /**this function display Food items in menu*/
    public  void Display() {
    	System.out.println("\t\t\t\t\t\t Appetizers");
        System.out.println("\t\t\t\t\t\t ----------\n"); 
    	for(int i=0;i<Appetizer.length;++i) {
    		System.out.println("Name: "+Appetizer[i].Name+"\tCategory: "+Appetizer[i].Category
    				+"\tCalories: "+Appetizer[i].Calories+"cal "+"\tPortion: "+Appetizer[i].Portion+"\tprice: "+Appetizer[i].Price+" $");    		
    		if(Appetizer[i]==null)
    			break;
    	}
    	System.out.println("============================================================================================================================");
    	System.out.println("\t\t\t\t\t\t MainDish");
        System.out.println("\t\t\t\t\t\t --------\n");
    	for(int i=0;i<MainDish.length;++i) {    		
    		System.out.println("Name: "+MainDish[i].Name+"\tCategory: "+MainDish[i].Category
    				+"\tCalories: "+MainDish[i].Calories+"cal "+"\tPortion: "+MainDish[i].Portion+"\tprice: "+MainDish[i].Price+" $");
    		if(MainDish[i]==null)
    			break;
    	}
    	System.out.println("============================================================================================================================");
    	 System.out.println("\t\t\t\t\t\t Dessert");
         System.out.println("\t\t\t\t\t\t -------\n");
    	for(int i=0;i<Dessert.length;++i) {    		
    		System.out.println("Name: "+Dessert[i].Name+"\tCategory: "+Dessert[i].Category
    				+"\tCalories: "+Dessert[i].Calories+"cal "+"\tPortion: "+Dessert[i].Portion+"\tprice: "+Dessert[i].Price+" $");
    		if(Dessert[i]==null)
    			break;
    	}
    	System.out.println("============================================================================================================================");
    	System.out.println("\t\t\t\t\t\t Drink");
        System.out.println("\t\t\t\t\t\t -----\n");
    	for(int i=0;i<Drink.length;++i) {    		
    		System.out.println("Name: "+Drink[i].Name+"\tCategory: "+Drink[i].Category
    				+"\t\tCalories: "+Drink[i].Calories+"cal "+"\tPortion: "+Drink[i].Portion+"\tprice: "+Drink[i].Price+" $");
    		if(Drink[i]==null)
    			break;
    	}
    	System.out.println("============================================================================================================================");
    }  
}  

/**this class contains all data about the order*/
class Order{
    //Static Data Member
      static int OrderID;
     Date OrderDate;
     String DeliveryAddress;
     Date DeliveryDate;
      ArrayList<Food> order;
      Menu M;
     protected double TotalPrice;
     //Static Data Member
     static int Counter=0;     
     
     Order(){
         OrderDate=new Date();        
         order=new ArrayList<Food>();//take items the create a meal            
        TotalPrice=0;
        Counter++;
        OrderID=Counter;  
        DeliveryDate=new Date(); 
        DeliveryAddress="";
     }       

    public static int getOrderID() {
        return OrderID;
    }
    //Static Method
    public static void setOrderID(int OrderID) {
        Order.OrderID = OrderID;
    }
    
     
    //Calculated Data Member
    public double getTotalPrice() {
         TotalPrice=0;
       for(Food item :order){
            TotalPrice+=item.Price;
        }    
        return TotalPrice;
             
    }

    public void setTotalPrice(double TotalPrice) {
      this.TotalPrice = TotalPrice;
    }

    
    /**get item from order*/
    public Food GetItem(int index){
        return order.get(index);
    }
    /**clear order*/
    public void ClearOrder(){
        order.clear();
    }
    /**remove item from order*/
    public void RemoveItem(int i){
        order.remove(i);
    }
    /**get number of items in the order*/
    public int NumItems(){
        return order.size();
    }
    /**get order number*/
    public int GetOrderNum(){
        return OrderID;
    } 
    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String DeliveryAddress) {
        this.DeliveryAddress = DeliveryAddress;
    }

    public Date getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(int day) {
        Date d=new Date();
        DeliveryDate.setDate(OrderDate.getDate()+day);
    }
    
    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate=OrderDate;
    }

     
    /**Display Order displays items in order*/
    public  void DisplayOrder(){
        
    	System.out.print("OrderID: "+OrderID);
    	System.out.print("\tOrder Date: "+OrderDate.toString());
        System.out.print("\tDelivery Date: "+DeliveryDate.toString());
        System.out.println("\tDeliveryAddress: "+DeliveryAddress);
        System.out.println("The Order:"); 
        
        for(Food item:order) {
        	System.out.println("Name: "+item.Name+"\tCategory: "+item.Category+"\tCalories: "+item.Calories+" cal"
        			+"\tPortion: "+item.Portion+"\tPrice: "+item.Price);
        	
        }
        
        
         getTotalPrice();
        System.out.println("\n The Total Price: "+TotalPrice+"$");
        System.out.println("============================================================================================================================");
              
    }
    
   
}

//Interface
/**This interface contain all the functions that will be used*/
interface Functions{
	public void CancelOrder(int Choice);
	public void UpdateOrder(int day);
	public void AddToWishlist(Food item);
	public void UpdateOrder(Food item);	
	 public void Delete(Food item);
	 public void ReportIssue(String issue);
	 
	
}
/**
 * interface represent system transportation
 * <ahref="https://www.geeksforgeeks.org/g-fact-32-user-defined-custom-exception-in-java/">The Reference</a>
 * <ahref="https://www.geeksforgeeks.org/interfaces-in-java/">The Reference</a>
 * 
 * @author ghada
 *
 */

//Abstract Class
/**this is abstract class customer that implement interface function*/
abstract class Customer implements Functions{
    //Different Access Modifiers
    protected String Issue;
    public Order O;//the last order the customer made    
    ArrayList<Food> Wishlist;//store out meal (array of array)       
    public Menu M;       
    
    public Customer(){
     Issue="";
     O=new Order(); 
     
     Wishlist=new ArrayList<Food>();          
     M=new Menu();
    }
    /**this abstract function create order by taking order id*/
    public abstract void CreateOrder(int ID);//, Date deliveryDate,String Address);
    
    @Override
    /**this function Cancel order by taking the order id*/
    public void CancelOrder(int choice){//choice is id order
    	Calendar c=Calendar.getInstance();
    	Calendar ca=Calendar.getInstance();
    	ca.setTime(O.DeliveryDate);
    	int a=c.get(Calendar.DAY_OF_MONTH);
    	int b=ca.get(Calendar.DAY_OF_MONTH);
        //User Defined Exception
    	try {    	
    	if(a-b>1) {
    		O.RemoveItem(choice);
    		System.out.println("The order has been cancelled successfully");
    	}else {
    		throw new InvalidTime("The order can not be cancelled, The order has already been sent");
    	}
    	}catch(InvalidTime e){
            System.out.println("Error! "+e.getMessage());
        } 
    	}
    	
    
    @Override
    /**AddToWishList add desired item in the wishList*/
    public  void AddToWishlist(Food item){    	
    	Wishlist.add(item);
        System.out.println("Your item is added to the Wishlist");
        
    	}
    
    
    //Polymorphism & overloading 
    @Override
    /**this function update the order by adding extra item*/
    public void UpdateOrder(Food item) {
    	O.order.add(item);    	
    	System.out.println("Item is updated and Added Successfully ");
    }
    //Extend Delivery Date
    
    //Polymorphism & overloading 
    @Override
    /**this fun Extend Delivery Date */
    public void UpdateOrder(int day) {
    	O.setDeliveryDate(day);
    	System.out.println("Delivery Date is Extended "+day+" Days");
    }
    //Remove item
    @Override
    /**this function delete desired item from order*/
    public void Delete(Food item) {
    	for(int i=0;i<O.order.size();++i) {
    		if(O.order.get(i).Name.equals(item.Name)) {
    			O.order.remove(i);
    			break;
    		}
    	}
    	System.out.println("Item is Removed from Order");
    }
    @Override
    /**it takes Customer Complain about the food*/
    public final void ReportIssue(String issue){
        this.Issue=issue;
        System.out.println("Your Report Has Been Sent Successfully,Thank You for your Opinion");
        
    }    
}

/**this is subclass that inherit class customer */
 class Loyal extends Customer{
    Loyal(){};
    //Polymorphism & overloading 
    public void CreateOrder(Food item) {    	
    		O.order.add(item);
                    	
    }
    
    //Polymorphism & overloading 
    @Override
    public void CreateOrder(int ID) {
    	try {
    		for(Food item:O.order) {
    			if(ID==item.ItemID) {
    				O.order.add(item);
    				System.out.println("your Order: "+item);
    				break;
    			}
    		}
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
        O.OrderID=ID;
        
        O.order.add(M.Appetizer[0]);
    	O.order.add(M.Appetizer[1]);
    	O.order.add(M.Drink[0]);
      
                 	
         
    }    
    
}
    
/**this is a subclass that inherit class customer*/
 class Guest extends Customer{    
    Guest(){}
    //Polymorphism & overloading 
    public void CreateOrder(Food item) {    	
		O.order.add(item);	
}
@Override
//Polymorphism & overloading 
public void CreateOrder(int ID) {
	//Java Exception
	try {
		for(Food item:O.order) {
			if(ID==item.ItemID) {
				O.order.add(item);
				System.out.println("your Order: "+item);
				break;
			}
		}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
    O.OrderID=ID;
     	
     
}    
}

//User Defined Exception
/**this is a user defined exception*/
 class InvalidTime extends Exception{
    public InvalidTime(String Messege){
        super(Messege);
    }    
}

