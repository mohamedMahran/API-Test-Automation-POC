$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/GetPostSteps.feature");
formatter.feature({
  "name": "",
  "description": "  Verify different GET operations using REST Assured",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify Post operation for profile",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PostOperationWithBody"
    }
  ]
});
formatter.step({
  "name": "I Perform POST operation for \"/posts/{profileNo}/profile\" with body",
  "rows": [
    {
      "cells": [
        "name",
        "profile"
      ]
    },
    {
      "cells": [
        "Sams",
        "2"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "GetPostTests.i_perform_post_operation_for_with_body(String,DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the body has name as \"Sams\"",
  "keyword": "Then "
});
formatter.match({
  "location": "GetPostTests.i_should_see_the_body_has_name_as(String)"
});
formatter.result({
  "status": "passed"
});
});