package com.driver;
import com.expections.*;
import com.processors.*;
import java.util.*;
import java.io.*;
class Main
{
	public static void main(String[] args) 
	{
		int ch;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("1. TO CREATE DATABASE");
		System.out.println("2. TO DELETE DATABASE");
		System.out.println("3. TO CREATE TABLE");
		System.out.println("4. TO DELETE TABLE");
		ch=scan.nextInt();
		switch(ch)
		{
			case 1 :System.out.println("Enter the folder path");
					String folderpath;
					scan.nextLine();
					folderpath=scan.nextLine();
					CreateDataBase cdb = new CreateDataBase();
					cdb.createDataBase(folderpath);
					break;

			case 2 :System.out.println("Enter the filename to be deleted if not in desktop so enter the directory");
					String dir;
					scan.nextLine();
					dir=scan.nextLine();
					DeleteBase db = new DeleteBase(dir);
					break;		
			case 3 :System.out.println("Enter the folderpath:");
					String fp;
					scan.nextLine();
					fp=scan.nextLine();
					File file = new File(fp);
					boolean result;
					result=file.exists();
					if(result)
					{
						Createtable ct = new Createtable();
						ct.createtable();
					}
					else 
					{
						System.out.println("Enter the valid folderpath");
						scan.nextLine();
						folderpath=scan.nextLine();
						Createtable ct = new Createtable();
						ct.createtable();
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

	}
}