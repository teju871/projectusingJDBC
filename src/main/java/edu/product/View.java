package edu.product;

import java.sql.SQLException;
import java.util.Scanner;

public class View {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Controller con=new Controller();
		
		Scanner sc=new Scanner(System.in);
		
		boolean flag=true;
		
		while(flag)
		{
			System.out.println("Enter 1 to insert\n 2 to update\n  3 to delete\n  4 to  fetchbyid\n 5 to exit ");
			
			int option=sc.nextInt();
			
			
			switch (option) {
			case 1:
			{
				System.out.println("Enter the id: ");
				int id=sc.nextInt();
				System.out.println("Enter the Name: ");
				String name=sc.next();
				System.out.println("Enter the description: ");
				String desc=sc.next();
				System.out.println("Enter the price: ");
				int price=sc.nextInt();
				
				Product product=new Product(id,name,desc,price);
				
				int count=con.Insert(product);
				
				if(count>0)
				{
					
					System.out.println("data inserted successfully...");
					
				}else
				{
					
					System.out.println("data not inserted....");
				}
				
				break;
			}
			case 2:{
				
				System.out.println("Enter the id you need to update:");
				int id=sc.nextInt();
				System.out.println("Enter the name you need to update");
				String name=sc.next();
				int count=con.update(id, name);
				if(count>0)
				{
					
					System.out.println("name updated succesfully");
					
					
				}else
				{
					
					System.out.println("data not updated");
				}
				break;
				
			}
			
			case 3:{
				
				System.out.println("Enter the id:");
				int id=sc.nextInt();
				int count=con.deletebyId(id);
				if(count>0)
				{
					
					System.out.println("data deleted succesfully");
					
					
				}else
				{
					
					System.out.println("data not deleted");
				}
				break;
				
			}
			
			case 4:{
				
				System.out.println("Enter the id:");
				int id=sc.nextInt();
				Product product=con.fetchbyId(id);
				
				System.out.println(product);
				
				break;		
			}
			
			case 5:{
				
				flag=false;
				System.out.println("Thank you");
				break;
			}
			
			default:
				break;
			}	
		}	
	}
}
