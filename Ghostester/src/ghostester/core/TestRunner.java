package ghostester.core;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Class that will be run when you export and execute your jar file.
 * Also, you can run it on Eclipse IDE and get the output in Eclipse's console tab.
 * @author Christian Cardozo
 */
public class TestRunner {

	/*
	 * You can put here some constants of your application.
	 * I advise you, if you need that, initialize this constants with the arguments of your main function through parseParameters method.
	 * 
	 */
	
	public static void main(String args[]){
		parseParameters(args);
		
		Result resultTests = JUnitCore.runClasses(GhostesterSuite.class);
		
		if(resultTests.wasSuccessful()){
			// You can put another message here.
			System.out.println("All tests passed without fail");
		}
		else{
			// You can put another message here.
			System.out.println("Some tests failed. Here comes the Failure Trace:");
			
			for(Failure failure : resultTests.getFailures())
				System.out.println(failure.toString());
		}
	}
	
	/**
	 * Use this method to parse the parameters and initialize your constants
	 * @param params Passed parameters through command line 
	 */
	public static void parseParameters(String params[]){
		
	}
}
