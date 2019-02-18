package com.ncu.processors;
import java.io.*;
import java.util.*;
import com.ncu.expections.*;
import org.apache.log4j.*;
import org.apache.log4j.PropertyConfigurator;
public class DeleteBase
{
    
   public static boolean BaseDelete(String dir)
   {
   	Properties prop = new Properties();//prop is the properties object
		Logger logger = Logger.getLogger(DeleteBase.class);//enter the class to have logger 
		PropertyConfigurator.configure("C:\\Users\\Anshu Pandey\\Desktop\\project\\configs\\logger\\logger.properties");
      try
		{
			deleteBase(dir);//there is the method 
		}
		catch(InvaildDir e)
		{//if the dir typed by the user is wrong then catch the error
			logger.error("\n\n"+e+prop.getProperty("invalidDir"+"\n\n"));
			return false;
		}
		return true;
	}


	


	public static void  deleteBase(String dir) throws InvaildDir
	{
		File file =new File(dir);
		//check if the file is a directory

        boolean result=true;
        result= file.isDirectory();//method of file class.find wheather path exist or notof type boolean 

		if(!result)
		{
			throw new InvaildDir("");
		}

		else if(file.delete())
		{
					System.out.println("The Database has been deleted");
	    }
	    else
	    {
	    	System.out.println("you need to delete the csv file first only the database will be deleted");
	        System.out.println("enter y to delete the files and no for not deleting it");
	        Scanner scan=new Scanner(System.in);
	        char answer;
	        answer=scan.next().charAt(0);
	        String[] myFiles;
	        if(result)
	        	if(answer=='y'||answer=='Y'){
	        { 
	        	myFiles=file.list();
	        	for(int i=0;i<myFiles.length;i++)

	        	{
	        		 File myFile =new File(file,myFiles[i]);
	        		myFile.delete();

	        	}

	        } 
	        file.delete();
	        System.out.println("the database is deleted");
	    }







	       /* System.out.println("enter the name of the csv file to be deleted");
	        Scanner scan=new Scanner(System.in);

	        String filename=scan.nextLine();
            DeleteFileJava fd=new DeleteFileJava(dir,filename);*/
	    }

	}
}

