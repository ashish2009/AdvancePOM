package commonfloor.home.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static commonfloor.home.page.GroupsHomeLocator.*;
import commonfloor.resident.page.NewsFeed;

public class GroupsHome {
	
	WebDriver driver = null;
	
	public GroupsHome(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, new GroupsHomeLocator());
	}
	
	public Object login(String mail,String pwd,String page){
		loginLink.click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(authForm));
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginButton.click();
		return getPostLoginPage(page);
	}
	
	public Object getPostLoginPage(String page){
		(new WebDriverWait(driver, 5000)).until(ExpectedConditions.visibilityOf(view));
		if(page.contains("resident")){
			if(view.getText().contains("Resident")){
				view.click();	
			}
			return new NewsFeed(driver);
		}else{
			if(view.getText().contains("Admin")){
				view.click();	
			}
			return null;
		}
	}
}
