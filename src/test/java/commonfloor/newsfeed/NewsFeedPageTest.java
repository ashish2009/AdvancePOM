package commonfloor.newsfeed;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonfloor.base.DriverEngine;
import commonfloor.home.page.GroupsHome;
import commonfloor.resident.page.Discussion;
import commonfloor.resident.page.NewsFeed;
import commonfloor.resident.page.Poll;

public class NewsFeedPageTest {
	WebDriver driver;
	NewsFeed feed;
	Discussion discussion;
	Poll poll;
	
	@BeforeClass
	public void setup(){
	    driver = DriverEngine.getDriver();
	    feed = (NewsFeed)new GroupsHome(driver).login("harish.cs@commonfloor.com", "groupstest","resident");
	}
	
	@Test
	public void verifyWidget(){
		Assert.assertEquals(feed.getDiscussionWidgetText().trim(), "Start a Discussion");
		Assert.assertEquals(feed.getPollWidgetText().trim(), "Start a Poll");
		Assert.assertEquals(feed.getComplaintWidgetText().trim(), "Raise a Complaint");
		Assert.assertEquals(feed.getEventWidgetText().trim(), "Create an Event");
	}
	
	@Test
	public void verifyStartDiscussion(){
		discussion = feed.getDisussionInstatce()
		                 .setTitle("Discussion create by Automation")
		                 .setBody("Discussion body create by Automation")
		                 .PostDiscussion();
		Assert.assertEquals(discussion.getTitle().trim(), "Discussion create by Automation");
		Assert.assertEquals(discussion.getDescription().trim(), "Discussion body create by Automation");
		NewsFeed.getNewsFeedPage(driver);
	}
	
	@Test
	public void verifyPollCreated(){
		poll = feed.getPollInstance()
				   .setTitle("Poll create by Automation")
				   .setDescription("Poll body create by Automation")
				   .setOption1("Yes")
				   .setOption2("No")
				   .setOption3("Cant Say")
				   .createPoll();
		Assert.assertEquals(poll.getTitle().trim(), "Poll create by Automation");
		Assert.assertEquals(poll.getDescription().trim(), "Poll body create by Automation");
		NewsFeed.getNewsFeedPage(driver);		   
	}
	
	@AfterClass
	public void cleanup(){
		driver.quit();
	}

}
