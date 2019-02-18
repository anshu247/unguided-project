package com.ncu.processors;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;
import com.ncu.expections.*;
import org.apache.log4j.*;
import com.ncu.processors.*;
import com.ncu.validator.*;
public class Createtable
{
    public static void createtable(String folderpath)
    {
          boolean b=false;
            System.out.println("enter the file name");//enter the name of the file which do not exist
            Scanner scan=new Scanner(System.in);

            String filename;//scanning the file name 
            filename = scan.nextLine();
            try
            {
            NameValidator obj=new NameValidator();//namevalidator object has been created so to cheak the validated of the filename
             b=obj.nameValidator(filename);
             //if(b==)
            }
            catch(Exception e)
           {
            System.out.println(e);
           }

       try
       {
            if(b==true)
            {
                File file =new File(folderpath+"\\"+filename);//of valid filename and folderpath
        
           CSVWriter csvWriter = new CSVWriter(new FileWriter(file));// object of csvwriter using file to write data into it
            ArrayList<String[]> rows = new ArrayList<String[]>();//row is the object of ArrayList
            rows.add(new String[]{"id", "name", "classname", "section"});
            System.out.println("enter the number of student for which deltails to be added");
            int count=scan.nextInt();
            if(count <0||count>'a'&&count<'z'||count>'A'&&count<'Z')
            {
                System.out.println("invailed input");
            }
            else 
            {
               for(int i=0;i<count;i++)
                {
                    Student s=new Student();
                    System.out.print("enter the id .");
                    scan.nextLine();
                    s.id=scan.nextLine();
                    System.out.println("enter the name.");
                    s.name=scan.nextLine();
                    System.out.println("enter the clname .");
                    s.clname=scan.nextLine();
                    System.out.println("enter the section .");
                    s.section=scan.nextLine();
                    rows.add(new String[]{s.id,s.name,s.clname,s.section});
                }
                csvWriter.writeAll(rows);
                csvWriter.close();
            }
        }
    
    
    
    else
    {
        System.out.println("\n\nSOORY!.....you have entered the wrong filename so the program has to  be restart . ");
        System.out.println("to restart press y or Y .");
        System.out.println("ThankYou");
   

    
    }
}
     catch(Exception e)
        {
            System.out.println(e);
        }
}
}