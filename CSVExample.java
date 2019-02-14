 import com.opencsv.CSVWriter;;
import java.io.*;
import java.util.*;
 
 class  Createtable {
 
    public static void main(String[] args) throws Exception {
        System.out.println("enter the file name");
        Scanner scan=new Scanner(System.in);
        String filename=scan.nextLine();


        CSVWriter csvWriter = new CSVWriter(new FileWriter(filename));// not stored at the contiguous location
      
 




        List<String[]> rows = new LinkedList<String[]>();
        rows.add(new String[]{"id", "name", "classname", "section"});
      
        csvWriter.writeAll(rows);
 
        csvWriter.close();
    }
}
