package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.LocatorType;
import driver.MobileDriver;
import junit.framework.Assert;

public class AssignmentSteps {
	
	MobileDriver mdriver = null;
    
    @Given("^Launch BookMyShow application$")				
    public void launchApp() throws Throwable {		
    	mdriver = new MobileDriver();
    	mdriver.launchDriver();
    }		

    @And("^Select Prod Environment$")					
    public void selectProdEnv() throws Throwable{
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("prod.env.xpath"));
    }		

    @When("^Tap On Search Icon$")					
    public void tapSearchIcon() throws Throwable {
    	Thread.sleep(5000);
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("search.icon.xpath"));
    }
    
    @And("^Enter movie title in the Search box$")					
    public void searchMovie() throws Throwable {  
    	mdriver.setText(LocatorType.XPATH, mdriver.prop.getProperty("search.text.box.xpath"), "Dilwale Dulhania Le Jayenge");
    }
    
    @And("^Select searched movie$")					
    public void selectMovie() throws Throwable {  
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("searched.movie.xpath"));
    }
    
    @And("^Tap on Book Tickets Button$")					
    public void TapBook() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("book.ticket.xpath"));
    }
    
    @And("^Select Date$")					
    public void selectDate() throws Throwable {
    	mdriver.waitForElementToClickable(LocatorType.XPATH, mdriver.prop.getProperty("movie.date.xpath"));
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("movie.date.xpath"));
    }
    
    @And("^Select Show time$")					
    public void selectShowTime() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("movie.time.xpath"));
    }
    
    @And("^Accept Term & Conditions$")					
    public void acceptTnC() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("accept.tnc.xpath"));
    }
    
    @And("^Select seat count$")					
    public void selectSeatCount() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("seat.count.xpath"));
    }
    
    @And("^Tap on Select Seats Button$")					
    public void selectSeatButton() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("select.seat.xpath"));
    }
    
    @And("^Select seats$")					
    public void selectSeat() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("seats.xpath"));
    }
    
    @And("^Tap on Pay Button$")					
    public void tapPayButton() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("pay.button.xpath"));
    }
    
    @And("^Select Net Banking$")					
    public void selectNetbanking() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("netbanking.tab.xpath"));
    }
    
    @And("^Select HDFC Bank$")					
    public void selectBank() throws Throwable {
    	mdriver.click(LocatorType.XPATH, mdriver.prop.getProperty("hdfc.bank.xpath"));
    }
    
    @Then("^Validate User is on HDFC Netbanking page$")					
    public void validateBank() throws Throwable {
    	mdriver.waitForElementPresence(LocatorType.XPATH, mdriver.prop.getProperty("hdfc.bank.title.xpath"), "Welcome to HDFC Bank Direct Pay");
    	String text = mdriver.getText(LocatorType.XPATH, mdriver.prop.getProperty("hdfc.bank.title.xpath"));
    	Assert.assertEquals("User is on HDFC netbanking page", true, text.contains("Welcome to HDFC Bank Direct Pay"));
    	mdriver.closeApp();
    }
}