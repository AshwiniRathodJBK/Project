package com.jbk;

import com.jbk.StaticInnerClass.A;

public class Test6 {

	private static  class A
	{
		//static int a=10;
		int b=20;
		void display()	{
			System.out.println("I am in display :");
		}
		
		
		/*static void show()
		{
			System.out.println("I am in static method ");
		}
	}
	*/
	public static void main(String[] args) {
		
		A a=new A();
		a.display();
		//a.show();
	
}
}
}