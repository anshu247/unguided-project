package com.ncu.processors;
import java.io.*;
import java.util.*;//Properties class is also in this package
import com.ncu.expections.*;//custom exceptions package 
import org.apache.log4j.*;
public class CreateDataBase
{
	public static boolean createDataBase(String folderpath)//boolean return type method .folderpath is the argument pass in  hte method 
	{
		Properties prop = new Properties();//Properties object contains a key and a value pair.The Properties class provides methods to get data from the properties file
		Logger logger = Logger.getLogger(CreateDataBase.class);//enter the class to have logger .
		PropertyConfigurator.configure("C:\\Users\\Anshu Pandey\\Desktop\\project\\configs\\logger\\logger.properties");//enter the path of logger
		try
		{
			createBase(folderpath);//there is the method 
		    System.out.println("the directory has been created");
		}
		catch(InvaildDir e)
		{//if the dir typed by the user is wrong then catch the error
			logger.error("\n\n"+e+prop.getProperty("invalidDir"+"\n\n"));
			return false;
		}
		return true;
	}
		public static void createBase(String folderpath) throws InvaildDir
	{  
		boolean success=false;
		File directory =new File(folderpath);
		success =directory.mkdir();//inbuild function,In java.io.file package.

		if(!success) 
		{
			throw new InvaildDir("");
		}

	}
} 