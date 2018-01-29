package commonfloor.resident.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Discussion {

	private WebDriver driver;
	private String dtitle;
	private String body;

	@FindBy(css = ".create_discussion_wrap>h2")
	private WebElement title;

	@FindBy(id = "topic")
	private WebElement discussionTitle;
	
	@FindBy(xpath="//*[@id='cke_1_contents']/iframe")
	private WebElement discussionBodyFrame;
	

	@FindBy(xpath = "//*[@id='cke_14']/span[1]")
	private WebElement discussionBody;

	@FindBy(id = "post_discussion_btn")
	private WebElement postDiscussion;
	
	@FindBy(xpath="//*[@id='all_discussion_div']/div[1]/div[2]/div[1]/a")
	private WebElement postedDiscussionTitle;
	
	@FindBy(xpath="//*[@id='all_discussion_div']/div[1]/div[2]/div[2]/div[1]/p/strong")
	private WebElement postedDiscussionDescription;

	public Discussion(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Discussion setTitle(String title) {
        this.dtitle = title;
        return this;
	}

	public Discussion setBody(String body) {
        this.body = body;
        return this;
	}

	public Discussion PostDiscussion() {
		discussionTitle.sendKeys(dtitle);
		discussionBody.click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(discussionBodyFrame));
		new Actions(driver).sendKeys(body).perform();
		driver.switchTo().defaultContent();
		postDiscussion.click();
		return this;
	}
	
	public String getTitle(){
		return postedDiscussionTitle.getText();
	}
	
	public String getDescription(){
		return postedDiscussionDescription.getText();
	}
}
