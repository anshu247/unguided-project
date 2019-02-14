import java.io.*;
import java.util.*;
public class DeleteBase{
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("enter the filename to be deleted if not in desktop so enter the directory");
		String dir=scan.nextLine();

		File file =new File(dir);
		file.delete();
		System.out.println(" the file has been deleted");

	}
}