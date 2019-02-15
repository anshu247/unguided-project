package com.processors;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;
import com.expections.*;
import org.apache.log4j.*;
import com.processors.*;
import com.validator.*;
public class Createtable
{
    public static void createtable()
    {
        try
        {  
            System.out.println("enter the file name");//enter the name of the file which do not exist
            Scanner scan=new Scanner(System.in);
            String filename;
            filename = scan.nextLine();
            NameValidator obj=new NameValidator();
            obj.nameValidator(filename);
            File file =new File(filename);
            CSVWriter csvWriter = new CSVWriter(new FileWriter(file));// not stored at the contiguous location
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
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}