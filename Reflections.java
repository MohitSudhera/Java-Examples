package newe;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.rmi.RemoteException;
import java.sql.Ref;

public  class Reflections implements Serializable,Cloneable
{
	//variables
	 static String f_name = "Mohit";
	 static int age = 24;
	
	//Constructors
	public Reflections(int no) throws ClassCastException{}
	public Reflections(int no, String l_name) throws RemoteException, ArithmeticException{}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//method
	public void display(String i)
	{
		int number = 9;
		System.out.println(number);
	}


	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException 
	{
		Class c1 = Reflections.class;

		System.out.println("***Class Level operations:***");

		//Class level operation
		System.out.println("Class Name: "+c1.getName());
		System.out.println("Super Class is "+c1.getSuperclass().getName());

		Class[] intList = c1.getInterfaces(); // to get info about interfaces

		for(Class c2:intList)
		{
			System.out.println("Interface is "+c2.getName());
		}

		int AccessModi = c1.getModifiers(); // to get info about access modifiers
		System.out.println("Access Modifiers: "+ Modifier.toString(AccessModi));

		System.out.println("************************************************************************");

		//Field operations

		System.out.println("***Field Level operations:***");

		Field[] field1 = c1.getFields();
		Field[] field2 = c1.getDeclaredFields();



		for(Field fields:field2) //iterating through number of fields
		{
			System.out.println("Varible name is:"+ fields.getName());
			System.out.println("Variable type is:"+ fields.getType());
			System.out.println("Value of the variable:"+ fields.get(age));
			System.out.println();
			System.out.println("*************");
			System.out.println();
		}
		

		System.out.println("************************************************************************");
		//Method level operations
		System.out.println("***Method Level operations:***");
		Method[] me = c1.getDeclaredMethods();

		for(Method method: me) //Iterating through methods
		{
			System.out.println("Method name is: "+method.getName());  //name of method
			System.out.println("Method return type is: "+method.getReturnType()); //return type of method

			int modi = method.getModifiers();//get modifier for method
			System.out.println("Method Modifier is: "+Modifier.toString(modi)); //converting modifier to string

			Class[] param = method.getParameterTypes();

			for(Class nparam:param)
			{
				System.out.println("Method paramater type is: "+nparam.getName()); //fetches param types
			}

			Class[] excep = method.getExceptionTypes();

			for (Class excep1:excep)
			{

				System.out.println("Exception thrown by method is: "+excep1.getName()); //fetches Exception type
			}
			System.out.println();
			System.out.println("*************");
			System.out.println();

		}	
		
	      System.out.println("************************************************************************");

	      //Constructor Level Operations
	      
			System.out.println("***Constructor Level operations:***");
			
			Constructor[] cons = c1.getConstructors();
			
			for(Constructor cons1:cons)
			{
				System.out.println("Constructor name: "+cons1.getName());
				
				int consModi = cons1.getModifiers();
				System.out.println("Constructor Modifier is: "+Modifier.toString(consModi));
				
				Class[] consParam = cons1.getParameterTypes();
				for(Class consParam1:consParam)
				{
					System.out.println("Constructor Paramter type is: "+consParam1.getName());
				}
				
				Class[] consExcep = cons1.getExceptionTypes();
				for(Class consExcep1:consExcep)
				{
					System.out.println("Exception Thrown by Constructor: "+consExcep1.getName());
				}
				
				System.out.println();
				System.out.println("*************");
				System.out.println();
			
			}
			
			


	}
}


