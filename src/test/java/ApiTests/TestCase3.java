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
public class TestCase3 {

    private Response res = null; //Response
    private Response res2=null;
    private JsonPath jp = null; //JsonPath
    public JsonPath jp2=null;

    //Instantiate a Helper Test Methods (htm) Object
    HelperTestMethods htm = new HelperTestMethods();

    @Before
    public void setup () throws InterruptedException{
        //Test Setup
    	System.out.println("*******************Starting Test Case 3***********************");
        Utils.setBaseURI(); //Setup Base URI
       // Utils.setBasePath("http://services.groupkt.com/country/get/all"); //Setup Base Path
        Utils.setContentType(ContentType.JSON); //Setup Content Type
        //Utils.setJsonPathTerm("videos.json"); //Setup Json Path Term
       
       
       
       res = Utils.getResponseSearchCountry3Character("IND"); //Get response
       String json= res.asString();
     JsonPath  jp = Utils.getJsonPath(res);
        
        //Set JsonPath
       //JsonPath  jp=new JsonPath(json);
       // System.out.println(res2.getBody().asString());
        //System.out.println(jp2);
     ValidateSearch (jp,"IND"); /// this is to validate Negative Serach
     
     System.out.println("*****************Ending Test Case 3******************************");
    }

    /* @Test
    public void T01_StatusCodeTest() {
        //Verify the http response status returned. Check Status Code is 200?
        htm.getCountryDetails(jp);
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
        
        	 
             for(int i=0; i <htm.getSearchResultMessage(jp).size(); i++ ) {
             
             
                System.out.println("Messages: " + jp.get("RestResponse.messages[" + i + "]"));
           
            System.out.print("\n");
            System.out.println("Country found matching code [" +CountryCode+ "].");
            String Message=jp.get("RestResponse.messages[" + i + "]");
            String TobeSearched="Country found matching code [" +CountryCode+ "].";
            String NegativeMessage="No matching country found for requested code [" +CountryCode+ "].";
          
            
            if (Message.contains(NegativeMessage)) {
           	 System.out.println("Search by Country by its 3 character alphanumeric Negative Testcase Passed and the value is :" + jp.get("RestResponse.messages[" + i + "]"));
           	 
           }
        }
    }

 
    
}

