package utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class Utils {
    //Global Setup Variables
    public static String pathAll="http://services.groupkt.com/country/get/all";
    public static String pathSearchCountry="http://services.groupkt.com/country/get/iso2code/";
    public static String ssnPath;
    public static String jsonPathTerm;

    //Sets Base URI
    public static void setBaseURI (){
        RestAssured.baseURI = "https://qt3.valic.com";
    }

    //Sets base path
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    //Sets ContentType
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }

    //Sets Json path term
    public static void  setJsonPathTerm(String jsonPath){
        jsonPathTerm = jsonPath;
    }

    //Created search query path
    public static void  createSearchQueryPath(String searchTerm, String param, String paramValue) {
        //path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
    	//pathAll="http://services.groupkt.com/country/get/all";
        
    }
    
    public static void createPathSearchCountry(){
    	pathSearchCountry="http://services.groupkt.com/country/get/iso2code/{alpha2_code}";
    }
    
    
    public static void createPath(String SSN){
    	ssnPath=("https://qt3.valic.com/ParticipantAPI/api/navisys/getparticipantpolicies/" + SSN);
    }
    public static Response getParticipantPolicyResponse(){
    	
    	System.out.println(ssnPath);
    	
    	return get(ssnPath);
    }

    //Returns response
    public static Response getResponse() {
        //System.out.print("path: " + path +"\n");
        return get(pathAll);
    }

    public static Response getResponsefromURL(){
    	//System.out.println(pathAll);
    	return get(pathAll);
    	
    }
    
    public static Response getResponseSearchCountry(String alpha2_code){
    	System.out.println(pathSearchCountry);
    	String FullPath =pathSearchCountry+alpha2_code;
    	System.out.println(FullPath);
    	return get(FullPath);
    	
    }
    
    public static Response getResponseSearchCountry3Character(String alpha3_code){
    	System.out.println(pathSearchCountry);
    	String FullPath ="http://services.groupkt.com/country/get/iso3code/"+alpha3_code;
    	System.out.println(FullPath);
    	return get(FullPath);
    	
    }
    public static Response getResponseSearchAnyText(String InputText){
    	System.out.println(pathSearchCountry);
    	String FullPath ="http://services.groupkt.com/country/search?text="+InputText;
    	System.out.println(FullPath);
    	return get(FullPath);
    	
    } 
    
    //Returns JsonPath object
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
       // System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }
}
