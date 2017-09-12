package ApiTests;

import utils.Utils;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //For Ascending order test execution
public class TestCase5 {

    private Response res = null; //Response
    private Response res2=null;
    private JsonPath jp = null; //JsonPath
    public JsonPath jp2=null;

    //Instantiate a Helper Test Methods (htm) Object
    HelperTestMethods htm = new HelperTestMethods();

    @Before
    public void setup () throws InterruptedException{
        //Test Setup
    	System.out.println("*******************Starting Test Case 5***********************");
        Utils.setBaseURI(); //Setup Base URI
       Utils.setBasePath("http://services.groupkt.com/country/get/all"); //Setup Base Path
        Utils.setContentType(ContentType.JSON); //Setup Content Type
        //Utils.setJsonPathTerm("videos.json"); //Setup Json Path Term
       
       
       
       res = Utils.getResponseSearchAnyText("UN"); //Get response
       String json= res.asString();
     JsonPath  jp = Utils.getJsonPath(res);
        
        //Set JsonPath
       //JsonPath  jp=new JsonPath(json);
       // System.out.println(res2.getBody().asString());
        //System.out.println(jp2);
     ValidateSearch (jp,"UN"); /// this is to validate positive search
     System.out.println("*******************Ending Test Case 5***********************");
     
    }

    /* @Test
    public void T01_StatusCodeTest() {
        //Verify the http response status returned. Check Status Code is 200?
        htm.getCountryDetails(jp);
    }

    @Test
    public void T02_SearchTermTest() {
        //Verify the title is correct
        Assert.assertEquals("Title is wrong!", ("Search results for \"paris hilton\""), jp.get("api-info.title"));
    }

    @Test
    public void T03_verifyOnlyFiveVideosReturned() {
        //Verify that only 5 video entries were returned
        Assert.assertEquals("Video Size is not equal to 5", 5, htm.getVideoIdList(jp).size());
    }

    @Test
    public void T04_duplicateVideoVerification() {
        //Verify that there is no duplicate video
        assertTrue("Duplicate videos exist!", htm.findDuplicateVideos(htm.getVideoIdList(jp)));
    }

    @Test
    public void T05_printAttributes() {
        //Print video title, pubDate & duration
        printTitlePubDateDuration(jp);
    }
*/
   
    @Test
    public void T01_printAttributes() {
        //Print video title, pubDate & duration
   
    }

    
    @After
    public void afterTest (){
        //Reset Values
        Utils.resetBaseURI();
        Utils.resetBasePath();
    }

    //*******************
    //***Local Methods***
    //*******************
    //Prints Attributes
  /*  private void printTitlePubDateDuration (JsonPath jp) {
        for(int i=0; i <htm.getVideoIdList(jp).size(); i++ ) {
            System.out.println("Title: " + jp.get("items.title[" + i + "]"));
            System.out.println("pubDate: " + jp.get("items.pubDate[" + i + "]"));
            System.out.println("duration: " + jp.get("items.duration[" + i + "]"));
            System.out.print("\n");
        }
    }*/

    public void ValidateSearch (JsonPath jp,String CountryCode) {
        
    	for(int i=0; i <htm.getCountryDetails(jp).size(); i++ ) {
            System.out.println("Title: " + jp.get("RestResponse.result.name[" + i + "]"));
            System.out.println("pubDate: " + jp.get("RestResponse.result.alpha2_code[" + i + "]"));
            System.out.println("duration: " + jp.get("RestResponse.result.alpha3_code[" + i + "]"));
            System.out.print("\n");
            
        }
        	 
             for(int i=0; i <htm.getSearchResultMessage(jp).size(); i++ ) {
             
             
                System.out.println("Messages: " + jp.get("RestResponse.messages[" + i + "]"));
           
            System.out.print("\n");
            
            String Message=jp.get("RestResponse.messages[" + i + "]");
            String TobeSearched="Total ["+htm.getCountryDetails(jp).size()+ "] records found.";
            String NegativeMessage="No matching country found for requested code [" +CountryCode+ "].";
            if (Message.contains(TobeSearched)) {
            	 System.out.println("Search by Country by Apha Numeric 2 or 3 or CountryName Testcase Passed and the message is :" + jp.get("RestResponse.messages[" + i + "]"));
            	 
            }
            
           
        }
    }

 
    
}

