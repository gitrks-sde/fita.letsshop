package fita.tests;

import org.testng.annotations.Test;

public class Test002 {

	@Test(groups= {"smoke"})
	public void method1()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(1*i);
		}
	}
	@Test(enabled=false)
	public void method2()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(2*i);
		}
	}
	@Test
	public void method3()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(3*i);
		}
	}
	@Test
	public void method5()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(5*i);
		}
	}
	@Test(groups= {"smoke"})
	public void method6()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(6*i);
		}
	}
	
}
