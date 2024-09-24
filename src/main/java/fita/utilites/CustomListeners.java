package fita.utilites;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import stepDefinitions.StepDefinition;

public class CustomListeners extends StepDefinition implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " " + result.getStatus());
		test.log(Status.PASS,"");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " " + result.getStatus());
		try {
			capturScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath("C:\\Users\\karth\\eclipse-workspace\\fita.letsshop\\testScreenshots\\testss.png");

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
