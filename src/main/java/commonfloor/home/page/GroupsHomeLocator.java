package commonfloor.home.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupsHomeLocator {

	@FindBy(id="login_link")
	public static WebElement loginLink;
	
	@FindBy(id="email")
	public static WebElement email;
	
	@FindBy(xpath="//*[@id='groupsJoinUser']/iframe")
	public static WebElement authForm;
	
	@FindBy(id="lbutton_new")
	public static WebElement loginButton;
	
	@FindBy(id="pwd")
	public static WebElement password;
	
	@FindBy(css=".switch-to-option>button")
	public static WebElement view;
}
