package com.processors;
import java.io.*;
import java.util.*;
import com.expections.*;
import org.apache.log4j.*;
import org.apache.log4j.PropertyConfigurator;
public class CreateDataBase
{
	public static boolean createDataBase(String folderpath)//boolean type method
	{
		Properties prop = new Properties();//prop is the properties object
		Logger logger = Logger.getLogger(CreateDataBase.class);//enter the class to have logger 
		PropertyConfigurator.configure("C:\\Users\\91805\\Desktop\\FINAL\\configs\\logger\\logger.properties");//enter the path of logger
		try
		{
			createBase(folderpath);//there is the method 
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
		success =directory.mkdir();
		if(!success) 
		{
			throw new InvaildDir("");
		}

	}
}