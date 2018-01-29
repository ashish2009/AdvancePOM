package commonfloor.resident.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsFeed {

	private WebDriver driver;

	@FindBy(id = "discussion")
	private WebElement discussionWidget;

	@FindBy(id = "icon_newpoll1")
	private WebElement pollWidget;

	@FindBy(id = "icon_newissue1")
	private WebElement complaintWidget;

	@FindBy(id = "icon_newevent1")
	private WebElement eventWidget;

	public NewsFeed(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getDiscussionWidgetText() {
		return discussionWidget.getText();
	}

	public String getPollWidgetText() {
		return pollWidget.getText();
	}

	public String getComplaintWidgetText() {
		return complaintWidget.getText();
	}

	public String getEventWidgetText() {
		return eventWidget.getText();
	}

	public Discussion getDisussionInstatce(){
		discussionWidget.click();
		return new Discussion(driver);
	}

	public Poll getPollInstance() {
		pollWidget.click();
        return new Poll(driver);
	}
	
	public static void getNewsFeedPage(WebDriver driver){
		driver.get("https://stage4.commonfloor.com/home");
	}
}
