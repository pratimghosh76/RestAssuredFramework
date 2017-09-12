package ApiTests;

import  com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class HelperTestMethods {
    //Verify the http response status returned. Check Status Code is 200?
    public void checkStatusIs200 (Response res) {
        assertEquals("Status Check Failed!", 200, res.getStatusCode());
    }

    //Get Video Ids (For use case-1)
    public ArrayList getVideoIdList (JsonPath jp) {
        ArrayList videoIdList = jp.get("items.id");
        return videoIdList;
    }
// Get Country Lists
    public ArrayList getCountryLists (JsonPath jp) {
        ArrayList CountryList = jp.get("RestResponse.result.name");
        return CountryList;
    }
 
    

 

    //Merge videoIdList and relatedVideoIdList as mergedVideoList
    public ArrayList mergeLists (ArrayList videoList, ArrayList relatedVideoList){
        ArrayList mergedVideoList = new ArrayList(videoList);
        mergedVideoList.addAll(relatedVideoList);
        return mergedVideoList;
    }

    //Find Duplicate Videos
   

// Find Duplicate Countries
    public boolean findDuplicateCountries (List<Integer> CountryList) {
    	 for (int i=0; i< CountryList.size(); i++) {
             if(Collections.frequency(CountryList, CountryList.get(i)) > 1){
                 System.out.println("This Country is duplicated: " + CountryList.get(i));
                 return false;
                 
                 
           }
       }
     System.out.println("Testcase Passed No country was dupicated");
       return true;
      
   }

public ArrayList getCountryDetails(JsonPath jp){
ArrayList CountryDetails=jp.get("RestResponse.result.name");
//System.out.println("jjjjjj" + CountryDetails.size());
return CountryDetails;
}

public ArrayList getSearchResult(JsonPath jp){
ArrayList SearchResult=jp.get("RestResponse.result.name");

return SearchResult;
}


public ArrayList getSearchResultMessage(JsonPath jp){
ArrayList SearchResultMessage=jp.get("RestResponse.messages");

return SearchResultMessage;
}

}