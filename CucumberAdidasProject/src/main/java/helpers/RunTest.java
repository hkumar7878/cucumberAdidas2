package helpers;

import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/**
 * @author Hitesh -latest committed on 02/23/2017
 *
 */

// Uncomment @RunWith if you are using Junit to run Test 
// @RunWith(Cucumber.class)

@CucumberOptions(features={"classpath:Adidasfeatures"}  
//Cucumber will automatically find all the �.features� extension files in the folder. 
//@CucumberOptions(features={"classpath:Adidasfeatures/Men Basketball Search Result Count Verification.feature"}
					//,glue={"src/main/java/stepDefinitions/Verify_Women_TShirt_Checkout_Process","Hook"}
//,glue={"src/main/java/stepDefinitions/Verify_Women_TShirt_Checkout_Process","Hook"}
					//it's working fine
					,glue={"helpers","classpath:stepDefinitions","Hook"} //it looks for a Step Definition inside all the files present in the folder mentioned in Glue Option.
					//,glue={"helpers","/src/main/java/stepDefinitions/Adidas_Verify_Search_Criteria_Price_Low_To_High"}
					//,glue={"helpers","classpath:stepDefinitions/Adidas_Mens_Basketball_Search_Count_Validation"}
					,plugin = {"pretty", "html:target/cucumber"}
					//, tags ={"@web"},	
					, tags ={"~@RegressionTest1","~@RegressionTest2","@RegressionTest3"},
					//, tags ={"@RegressionTest","@FunctionalTest"}, 
					dryRun=false
					,monochrome = false
		)
@Test
public class RunTest extends AbstractTestNGCucumberTests{
 
}

















//Some tag example/rules				
//if tags ={"@FunctionalTest"}, It is tagged at feature file level and all the scenarios defined in the feature file will be executed
// if tags=	{"@FunctionalTest,@RegressionTest"} , here comma seperated ',' works as and operator and all the scenarios tagged with @functional
				// and RegressionTest from the feature file will be executed
// if tags=	{"@FunctionalTest","@RegressionTest"} , here comma seperated ',' and scenarios written inside "" works as OR operator and either of the scenarios tagged with @functional
				// and RegressionTest from the feature file will be executed
// skipping scenarios:
// Special Character ~ is used to skip the tags. e.g  tags ={"@RegressionTest","~@SmokeTest"}, here SmnokeTest will be skipped
//// Cucumber supports hooks, which are blocks of code that run before or after each scenario. You can define them anywhere in your project or step definition layers, using the methods @Before and @After.	