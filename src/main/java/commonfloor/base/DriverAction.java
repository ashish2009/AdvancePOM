package commonfloor.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverAction {

	private WebDriver driver;
	
	public DriverAction(WebDriver driver){
		
	}
	
	public void getIframe(String id) {
	    final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	    for (WebElement iframe : iframes) {
	        if (iframe.getAttribute("id").equals(id)) {
	        // TODO your stuff.
	        }
	    }
	}
	
	public void getAllIframe() {
	    final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	    System.out.println("Id of all iframe");
	    for (WebElement iframe : iframes) {
	        System.out.println(iframe.getAttribute("id"));
	    }
	    
	    System.out.println("Text of all iframe");
	    for (WebElement iframe : iframes) {
	        System.out.println(iframe.getText());
	    }
	    
	}
}
