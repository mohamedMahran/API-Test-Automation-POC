Feature: 
  Verify different GET operations using REST Assured

	  @SinglePost
	Scenario: Verify one author of the post
    Given i perform GET operation for "/posts"
    Then  I should see the author name as "Karthik kk"
    @AuthorsCollections
   Scenario: Verify collection of authors in the post
    Given i perform GET operation for "/posts"
    Then i should see the author names 
    @GetParamters
   Scenario: Verify Paramters of Get
    Given i perform GET operation for "/post"
    Then i should see verify GET paramters 
    
    @PostParamters
   Scenario: Verify Post operation
    Given i perform Post operation for "/post"
    
    @PostOperationWithBody
    Scenario: Verify Post operation for profile
    Given I Perform POST operation for "/posts/{profileNo}/profile" with body
      | name              |profile|
      | Sams 							| 2 		|
    Then I should see the body has name as "Sams"
    
     
    