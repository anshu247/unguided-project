package com.processors;
import java.io.*;
import java.util.*;
public class DeleteFileJava 
{
    public DeleteFileJava(String add,String filename)
    {
        Scanner scan = new Scanner(System.in);
        File file = new File(add+"\\"+filename);
        if(file.delete())
        {
            System.out.println(add+filename+" File deleted");
        }
        else 
            System.out.println("File "+add+filename+"doesn't exists");
    }
}