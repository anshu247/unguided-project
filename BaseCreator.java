import java.util.*;
import java.io.File;
import java.io.IOException;

class BaseCreator{
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		boolean success=false;// a variable used type boolean
		System.out.println("enter the directory:");
		String dir =scan.nextLine();
		File directory =new File(dir);
		if(directory.exists()){
			System.out.println("directory already exist..");

		}
		else{
			System.out.println("directory not exists");
			success =directory.mkdir();//used to create the directory and its type is boolean
			if(success){
				System.out.println("successfully created new directory");

			}else{
				System.out.println("Failed to create new directory");

			}
		}

		System.out.println("enter the file name to be created");
		String filename =scan.nextLine();

		File f=new File(filename);
		if(f.exists()){
			System.out.println("File already exist");

		}
		else{
			System.out.println("no file exist");
			//createNewFile() method atomically creates a new file named by this abstract path name.
			try
			{success=f.createNewFile();
			if(success){
				System.out.println("successfully created new file");

			}
			
			else
			{
				System.out.println("Failed to be made");
			}
		}catch(Exception e)
			{
				System.out.println(e);
			}

		}
		scan.close();

	}
}