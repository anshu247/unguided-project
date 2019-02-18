package com.ncu.processors;
class Student{
	
	String id;
	String name;
	String clname;
	String section;

	public Student()
	{
		this.id=null;
		this.name=null;
		this.clname=null;
		this.section=null;

	}
	public Student(String id,String name,String clname ,String section)
	{
		this.id=id;
		this.name=name;
		this.clname=clname;
		this.section=section;

	}
}