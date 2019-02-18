package com.ncu.driver;
import com.ncu.expections.*;
import com.ncu.processors.*;
import java.util.*;
import java.io.*;
class Main
{
	public static void main(String[] args) 
	{
		
		int ch;
		char  choice;
		do{
		Scanner scan = new Scanner(System.in);
		System.out.println("************************************");//meun
		System.out.println("\n\t   ENTER THE CHOICE \n");
		System.out.println("\n\t 1. TO CREATE DATABASE");
		System.out.println("\n\t 2. TO DELETE DATABASE");
		System.out.println("\n\t 3. TO CREATE TABLE");
		System.out.println("\n\t 4. TO DELETE TABLE");
		System.out.println("************************************");
		ch=scan.nextInt();
		switch(ch)
		{
			case 1 :System.out.println("Enter the folder path");
					String folderpath;
					scan.nextLine();
					folderpath=scan.nextLine();
					CreateDataBase cdb = new CreateDataBase();//object is created of class CreateDataBase() 
					cdb.createDataBase(folderpath);//on the object we are invoking the method and passsing folderpath into it
					break;

			case 2 :System.out.println("Enter the directory to be deleted :");
					String dir;
					scan.nextLine();
					dir=scan.nextLine();
					
					DeleteBase c = new DeleteBase();//creating the object
				    c.BaseDelete(dir);//invoking the method on to it and passing the string path into it 
							
					break;		
				
			case 3 :System.out.println("Enter the folderpath:");
					String fp;
					scan.nextLine();
					fp=scan.nextLine();
					File file = new File(fp);//
					boolean result;
					result=file.exists();//method of type boolean if path exist return true else false
					if(result)
					{
						Createtable ct = new Createtable();//object made of class Createtable
						ct.createtable(fp);//method invoked
					}
					else //if path don't exist
					{
						System.out.println("Enter the valid folderpath");
						scan.nextLine();
						folderpath=scan.nextLine();
						Createtable ct = new Createtable();
						ct.createtable(fp);
					}
					break;

					
			case 4 :String add;
					System.out.print("Enter the File Path: ");
					scan.nextLine();
      				add=scan.nextLine();
       				String filename;
       				System.out.print("\nEnter the filename: ");
      				filename=scan.nextLine();
      				DeleteFileJava dfj = new DeleteFileJava(add,filename);
      				break;
      		default:System.out.println("Wrong Choice");
      		 
            }
      		 System.out.println("Continue(Y/N)");
             
           choice=scan.next().charAt(0);
         
		}while(choice=='Y'|| choice=='y');
	


	}
}