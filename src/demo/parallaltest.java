package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pckg1.Gfeed;

public class parallaltest extends GoogleFeed_valid{
	

	public static void main(String[] args) throws Throwable 
	{
		
		readexcelsheet1incollection();
		readexcelsheet2incollection();
		//add to a list
		   List<Callable<Void>> taskList = new ArrayList<Callable<Void>>();
		   taskList.add(callable1);
		   taskList.add(callable2);
		   
		   //create a pool executor with 3 threads
		   ExecutorService executor = Executors.newFixedThreadPool(2);
		   
		   try
		   {
		      //start the threads and wait for them to finish
		      executor.invokeAll(taskList);
		   }
		   catch (InterruptedException ie)
		   {
		      //do something if you care about interruption;
		   }

		   
		
		
	}

}

