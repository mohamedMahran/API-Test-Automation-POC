package steps;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import org.hamcrest.core.Is;

public class BDDStyledMethod {


    public static void SimpleGETPost(String postNumber){
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().body("author", is("Karthik kk"));
    }
    public static void PerformContainsCollection(){
        given()
        	.contentType(ContentType.JSON).
        when()
        	.get(String.format("http://localhost:3000/posts"))
        .then()
        	.body("author", contains("Karthik kk","Karthik kk",null)).statusCode(200);
    }
    /* function that test rest API using path parameter */
    public static void PerformPathParamter(){
        given()
        	.contentType(ContentType.JSON).
        with()
        	.pathParam("post",1)
        .when()
    		.get("http://localhost:3000/posts/{post}").
    	then()
        	.body("author", containsString("Karthik kk"));
    }
    public static void PerformQueryParamter(){
        given()
        	.contentType(ContentType.JSON)
        	.queryParam("id",1)
        .when()
    		.get("http://localhost:3000/posts").
    	then()
        	.body("author", hasItem("Karthik kk"));
    }
    public static void PerformPostWithBodyParamter()
    {
    	HashMap<String,String> postContent = new HashMap<>();
    	postContent.put("id","5" );
    	postContent.put("title","Robotium Course" );
    	postContent.put("author","Execute Automation" );
    	
    	given()
      		.contentType(ContentType.JSON).
      	with()
      		.body(postContent).
      	when()
  			.get("http://localhost:3000/posts").
  		then()
      		.body("author", Is.is("Execute Automation"));
    	
    }
}