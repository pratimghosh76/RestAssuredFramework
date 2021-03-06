package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ApiTests.HelperTestMethods;
import ApiTests.TestCase1;
import ApiTests.TestCase2;
import ApiTests.TestCase3;
import ApiTests.TestCase4;
import ApiTests.TestCase5;
import ApiTests.TestCase6;




@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestCase1.class,// REST web-service to get a list of all Countries
	TestCase2.class,// This testcase is to Validate REST web-service to search country by 2 character alphanumeric ISO code
	TestCase3.class,//This testcase is to Validate REST web-service to search country by 3 character alphanumeric ISO code
	TestCase4.class,//This testcase is to Validate REST web-service to search country by 3 character alphanumeric ISO code Negative Testcase
	TestCase5.class,//This TestCase is to Validate REST web-service to search country by 3 character ISO code or 2 character ISO code or country name 
	TestCase6.class,// This tetscase is to validate REST web-service to search country by 3 character ISO code or 2 character ISO code or country name Negative Testcase
})
public class AllApiTest {
}