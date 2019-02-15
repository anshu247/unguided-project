package com.processors;
import java.io.*;
import java.util.*;
public class DeleteBase
{
	public DeleteBase(String dir)
	{
		File file =new File(dir);//if dir is wrong
		file.delete();
		System.out.println("The Database has been deleted");
	}
}