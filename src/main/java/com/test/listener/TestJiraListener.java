package com.test.listener;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.test.helper.JiraPolicy;
import com.test.helper.JiraServiceProvider;

public class TestJiraListener implements ITestNGListener{
	
	
	public void onTestFailure(ITestResult result) {
		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		if(isTicketReady) {
			//raise jira ticket
			System.out.println("is Ticket ready for jira:" +isTicketReady);
			JiraServiceProvider jiraSp = new JiraServiceProvider("http://jira123.se-fi.com", "apotla@se-fi.com", 
					"lookatSTAR514$", "SCS");
			String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + "got failed due to some assertation";
		String issueDescription = result.getThrowable().getMessage() + "\n";
		issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
		jiraSp.createJiraTicket("Defect", issueSummary, issueDescription, "Anil");
		}
	}

}
