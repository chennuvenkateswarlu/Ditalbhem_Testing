package Section1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Digitalbhem_Testing 
{

	public static void main(String[] args) throws Exception
	{
		//Set the path to the location of the ChromeDriver
 	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\91701\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
 	 //Initialize Chrome browser
 	       ChromeOptions option=new ChromeOptions();
			   option.addArguments("--remote-allow-origins=*");
			   WebDriver driver=new ChromeDriver(option);
	       //Open the website
	           driver.get("https://www.digitalbhem.com/");
	       //To perform maximize the window
	           driver.manage().window().maximize();
	           Thread.sleep(3000);
	           
	      //Check for the logo
	       try 
	       {
	    	   Thread.sleep(2000);
	    	   WebElement logo=driver.findElement(By.id("logo"));
	    	   if(logo.isDisplayed())
	    	   {
	    		   System.out.println("Logo found");
	       }
	       }
	       catch(Exception e)
	       {
	    	   System.out.println("Logo not found");	   
	       }
	         //Check for elements on different pages
	       String[]pages= {"About","Services","Careers","Blog","Contact","Affiliates"};
	           for(String page:pages)
	           {
	        	   try
	        	   { 
	        		   Thread.sleep(2000);
	        		   WebElement element= driver.findElement(By.linkText(page));
	        		      element.click();
	        		      System.out.println("Navigated to" + page +" page");
	               //You can add further tests or verification for each page here
	        	   //For instance verifying the presence of specific elements on each page
	        	   //Example Check for an element with ID example_element on each page
	        		      try
	        		      {
	        		    	  Thread.sleep(2000);
	        		    	  WebElement exampleElement=driver.findElement(By.id("example_element"));
	        		    	  if(exampleElement.isDisplayed())
	        		    	  {
	        		    		  System.out.println("Element example_element found on the " + page +" page");
	        		    	  }
	        		      }
	        		      catch(Exception ex)
	        		      {
	        		    	  System.out.println("Element example_element not found on the" + page +" page");
	        		    	  }
	        		      }
	        	   catch(Exception ex)
	        	   {
	        		   System.out.println("Failed to navigate to"+ page +" page");
	        	   }
	           }
	           //Close the browser window
	          
	            Thread.sleep(3000);
	           driver.quit();
	}
}
