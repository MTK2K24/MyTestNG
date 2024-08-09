package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagePagesPage;
import utilities.ExcelUtility;

public class ManagePagesTest extends Base {
	@Test(groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class, description = "This test case is to verify if an item can be deleted")
	public void verifyIfAnItemCanBeDeleted() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String managepageurl = ExcelUtility.getString(1, 0, "ManagePages");
		String sucesstext = ExcelUtility.getString(1, 1, "ManagePages");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
		loginpage.navigateToAdminPage(managepageurl);
		ManagePagesPage managepage = new ManagePagesPage(driver);
		managepage.navigatingToTheListPage(managepageurl).clickOnSearchIcon().enterTextInSearchField()
				.clickOnSearchButton();
		if (managepage.findingEnteredTextInTable()) {
			managepage.clickingDeleteIcon();
			boolean alertDeleteMessage = managepage.getDeleteMessage().contains(sucesstext);
			Assert.assertTrue(alertDeleteMessage, "Page Not Deleted Successfully");
		} else {
			Assert.fail("Page not found in table.");
		}
	}
}
