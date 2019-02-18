package com.ncu.validator;
import com.ncu.expections.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import java.io.File;
import org.apache.log4j.Logger;//to store value of the exceptions
import org.apache.log4j.PropertyConfigurator;
public class NameValidator{


public 	boolean nameValidator(String filename){
		System.out.println("File name is:"+filename);
     // String csvfilepath=("C:\\Users\\Anshu Pandey\\Desktop\\unguidedproject\\csvDatabase\\filename\\");
     
		Properties prop=new Properties();

		FileInputStream input =null;

         // to check if file name is not empty 
		boolean b;
        

		//logger
		Logger logger =Logger.getLogger(NameValidator.class);
        
		PropertyConfigurator.configure("C:\\Users\\Anshu Pandey\\Desktop\\project\\configs\\logger\\logger.properties\\");		
		try
		{
			input=new FileInputStream("C:\\Users\\Anshu Pandey\\Desktop\\project\\configs\\constants\\exceptions.properties\\");
			prop.load(input);//method loads the specified filename as a dynamic library.
			emptyFileName(filename);
            missingDot(filename);
            fileFormat(filename);
            csvOnly(filename);      
            fileExist(filename);

            return true;
         
         }
         




         catch(EmptyFileNameException e)//if file name is empty
         {   
           logger.error("\n \n "+e+prop.getProperty("emptyNameMessage")+"\n");
         	return false;
         }

          



          catch(MissingExtensionException e)
         {
            logger.error("\n \n "+e+prop.getProperty("extensionMessage")+"\n");
            return false;

         }
         



          catch(InvalidExtensionException e)
         {
            logger.error("\n \n "+e+prop.getProperty("invalidException")+"\n");
            return false;

         }
          


          catch(FileAlreadyExists e)
          {
          	logger.error("\n \n "+e+prop.getProperty("fileExistsMessage")+"\n");
          } 


       
         catch(Exception e)
         {
            System.out.println(e);
          
         }
        return true;
    }

    //**********************************************************************
    //methods.........

//1 method
    void emptyFileName(String filename) throws EmptyFileNameException
    {
		if(filename=="")
		{
		    throw new EmptyFileNameException("EmptyFileName");
		}
		 
	}

//2 method
	void  missingDot(String filename) throws MissingExtensionException
	{
		Pattern costPattern=Pattern.compile("[.]");//compile is a static method and class is pattern it will compile dot 
		Matcher costMatcher =costPattern.matcher(filename);//match the file name to check the dot
		boolean value=costMatcher.find();
		if(value==false)
		{
			throw new MissingExtensionException("MissingExtension");

		}
	}


 
		
//3 method
	 void  fileFormat(String filename) throws InvalidExtensionException
	 {
		String [] extn =filename.split("\\.");//to check the extention (csv) is there or not 
		if(extn.length<=1)// if the array length is 1 or less then 
		{
			
            throw new InvalidExtensionException("invalidException");
		}
	}
        
// 4 method
		private void csvOnly(String filename)throws InvalidExtensionException
		{
		
			String []name =filename.split("\\.");//to check the extension is csv or not
			if(name[1].equals("csv")==false)
        	{ 

        		throw new InvalidExtensionException("invalidException");
        	}
			 
		}

//5 method
	private void  fileExist(String filename) throws FileAlreadyExists
	{
		File f=new File("./"+filename);//
		if(f.exists()==true)
        {
            throw new  FileAlreadyExists ("fileExistsMessage");
            
        }
	}



}

//****************************************************************************************************************8








