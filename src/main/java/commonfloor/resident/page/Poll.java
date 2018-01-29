package commonfloor.resident.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Poll {
	
	private WebDriver driver;
	private String title;
	private String description;
	private String option1;
	private String option2;
	private String option3;
	
	@FindBy(id="poll_about")
	private WebElement pollName;
	
	@FindBy(id="poll_description")
	private WebElement pollDescription;
	
	@FindBy(css="#options>.option_block:nth-child(1)>input")
	private WebElement pollOption1;
	
	@FindBy(css="#options>.option_block:nth-child(2)>input")
	private WebElement pollOption2;
	
	@FindBy(css="#options>.option_block:nth-child(3)>input")
	private WebElement pollOption3;
	
	@FindBy(css=".primary_btn")
	private WebElement pollBtn;
	
	@FindBy(css=".main_post>.main_postLeft h3")
	private WebElement loc_title;
	
	@FindBy(css=".main_post>.main_postLeft .poll-description>span")
	private WebElement loc_description;
	
	@FindBy(css=".voteOption_block>.voteLabel:nth-child(3)")
	private WebElement voteOption1;
	
	@FindBy(css=".voteOption_block>.voteLabel:nth-child(4)")
	private WebElement voteOption2;
	
	@FindBy(css=".voteOption_block>.voteLabel:nth-child(5)")
	private WebElement voteOption3;
	
	@FindBy(css=".primaryBtn>span")
	private WebElement voteBtn;
	
	
	public Poll(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Poll setTitle(String title) {
        this.title = title;
        return this;
	}
	
	public Poll setDescription(String description) {
        this.description = description;
        return this;
	}
	
	public Poll setOption1(String option) {
        this.option1 = option;
        return this;
	}
	
	public Poll setOption2(String option) {
        this.option2 = option;
        return this;
	}
	
	public Poll setOption3(String option) {
        this.option3 = option;
        return this;
	}
	
	public Poll createPoll(){
		pollName.sendKeys(title);
		pollDescription.sendKeys(description);
		pollOption1.sendKeys(option1);
		pollOption2.sendKeys(option2);
		pollOption3.sendKeys(option3);
		pollBtn.click();
		return this;
	}
	
	public String getTitle(){
		return loc_title.getText();
	}
	
	public String getDescription(){
		return loc_description.getText();
	}
	
	public String getOption1(){
		return voteOption1.getText();
	}
	
	public String getOption2(){
		return voteOption2.getText();
	}
	
	public String getOption3(){
		return voteOption3.getText();
	}

}
