package steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utility.RestAssuredExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import java.util.HashMap;
import java.util.List;

import org.hamcrest.core.Is;

public class GetPostTests {
	private static ResponseOptions<Response> response ;
	
	public  GetPostTests()
	{
		new RestAssuredExtension();
	}
	@Given("^i perform GET operation for \"([^\"]*)\"$")
	public void i_perform_GET_operation_for(String url) throws Throwable {
	   response = RestAssuredExtension.GetOps(url);
	}

	@Then("^I should see the author name as \"([^\"]*)\"$")
	public void i_should_see_the_author_name_as(String authorName) throws Throwable {
	    
		assertThat(response.getBody().jsonPath().get("author"),hasItem(authorName));
	}

	@Then("^i should see the author names$")
	public void i_should_see_the_author_name() {
		BDDStyledMethod.PerformContainsCollection();
	}
	@Then("^i should see verify GET paramters$")
	public void i_should_see_verify_GET_paramters(String arg0) {
	    // Write code here that turns the phrase above into concrete actions
		BDDStyledMethod.PerformQueryParamter();
	}
	@Given("^i perform Post operation for \"([^\"]*)\"$")
	public void i_perform_Post_operation_for(String arg0) {
	    // Write code here that turns the phrase above into concrete actions
		BDDStyledMethod.PerformPostWithBodyParamter();
	}
	@Given("^I Perform POST operation for \"([^\"]*)\" with body$")
	public void i_perform_post_operation_for_with_body(String url, DataTable table) throws Throwable {
	    List<List<String>> data = table.asLists();
	    //set the body 
	    HashMap<String, String> body= new HashMap<>();
	    body.put("name", data.get(1).get(0));
	  //Path Parameters
	    HashMap<String, String> pathParam= new HashMap<>();
	    pathParam.put("profileNo", data.get(1).get(1));
	    // perform post operation 
	    response=RestAssuredExtension.PostOpsWithBodyAndPathParams(url, pathParam, body);   
	}

	@Then("^I should see the body has name as \"([^\"]*)\"$")
	public void i_should_see_the_body_has_name_as(String name) {
	   assertThat(response.getBody().jsonPath().get("name"),Is.is(name));
	}
}
