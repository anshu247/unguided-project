package com.validator;
import com.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import java.io.File;
import org.apache.log4j.Logger;//to store value
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
        
		PropertyConfigurator.configure("C:\\Users\\91805\\Desktop\\FINAL\\configs\\logger\\logger.properties\\");		
		try
		{
			input=new FileInputStream("C:\\Users\\91805\\Desktop\\FINAL\\configs\\constants\\exceptions.properties\\");
			prop.load(input);
			emptyFileName(filename);
            missingDot(filename);
            fileFormat(filename);
                   
            fileExist(filename);
         
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

       
         

          catch(Exception e)
         {
            System.out.println(e);
          
         }
        return true;
    }

    void emptyFileName(String filename) throws EmptyFileNameException {
		if(filename=="")
		{
		 throw new EmptyFileNameException("EmptyFileName");
		}
		 
	}


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


 
		

	 void  fileFormat(String filename) throws InvalidExtensionException{
		String [] extn =filename.split("\\.");//to check the extention (csv) is there or not 
		if(extn.length<=1)// if the array length is 1 or less then 
		{
			
            throw new InvalidExtensionException("invalidException");
		}}
        
	 
	





    /* private void specialCharacter(String filename) throws SpecialCharacterException{
		filename =filename.split("\\.")[0];
		Pattern patternGet=Pattern.compile("[@#$%^&(,)_]");
		Matcher check =patternGet.matcher(filename);
		boolean finalValue=check.find();
		if(finalValue ==true)
        { 
            throw new SpecialCharacterException("specialcharacterMessage");
           }
			
	}
*/
    private void csvOnly(String filename)throws InvalidExtensionException{
		String []name =filename.split("\\.");//to check the extension is csv or not
		if(name[1].equals("csv")==false)
        { throw new InvalidExtensionException("invalidException");


        }
			 
	}


	private void  fileExist(String filename) throws FileAlreadyExists{
		File f=new File("./"+filename);//
		if(f.exists()==true)
        {
            throw new  FileAlreadyExists ("fileExistsMessage");
            
        }
}
}

//****************************************************************************************************************8








