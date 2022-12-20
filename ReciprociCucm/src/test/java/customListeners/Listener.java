package customListeners;


import java.lang.reflect.Method;

import org.testng.IExecutionListener;
import org.testng.IInvokedMethodListener;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reciproci.base.Base;

public class Listener implements IExecutionListener, IInvokedMethodListener, ISuiteListener, ITestListener{
	
	
	public void onExecutionStart(Method method) {
		System.out.println(method.getName()+" -- Hello Welcome to the Automation");
	}
	
	
	public void onExecutionFinish(Method method) {
		System.out.println(method.getName()+" -- Thanks for Patient");
	}
	
	
	public void onStart(Method method) {
		
	}
	
	public void onFinish(Method method) {
		
	}
	
	
	public void beforeInvocation(Method method) {
		
	}
	
	
	public void afterInvocation(Method method) {
		
	}
	
	
	public void onTestStart(ITestResult result) {		
		System.out.println("Test case started "+result.getName());
	}
	
	
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+" Test case skipped");
	}
	

	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed Test - "+result.getName());
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed Test -- "+result.getName());
		try {
			Base.getScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
//	public void onStart(ITestContext context) {
//		System.out.println(context.getName());
//		
//	}
//	
//
//	public void onFinish(ITestContext context) {
//		System.out.println(context.getName());
//		
//	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	


}
