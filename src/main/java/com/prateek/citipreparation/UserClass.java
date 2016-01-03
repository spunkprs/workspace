package com.prateek.citipreparation;

import com.prateek.citipreparation1.Child;

public class UserClass {

	public static void main(final String ar[]) {
		Parent parent = new Child();
		parent.print();
		
		/*
		 * Note :: print() being default method inside parent class in that case 
		 * print() of Parent class will get called not the child because no overriding 
		 * would be there in that case default ---> protected won't work across packages
		 * so after calling print() method run time polymorphism won't come in to picture, 
		 * hence print() method of parent version will get called. 
		 * */
	}
}
