package testscripts;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageNewsTest extends Base {
	@Test(groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class, description = "This test case is to verify if a news can be added")
	public void verifyIfANewsCanBeAdded() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String title = ExcelUtility.getString(1, 0, "ManageNewsPage");
		String url = ExcelUtility.getString(1, 1, "ManageNewsPage");
		String sucesstext = ExcelUtility.getString(1, 2, "ManageNewsPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.navigateToManageNewsPage(url).clickingNewButtonInManageNewsPage().enteringTextInNewsField(title)
				.clickingSaveButton();
		boolean sucessmessage = managenewspage.getSuccessMessage().contains(sucesstext);
		Assert.assertTrue(sucessmessage, "News Created not created succesfully");
	}
}