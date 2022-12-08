Feature: all requests related to Chat server

  @createChatUser
  Scenario: To check the create chat user executes successfully or not
    Given create chat user payload is created
    When user calls createChatUser request using POST method call
    Then Chat user Request should be successful with status code "200"
    Then "result.username" should be "anuja";


  @updateChatUser
  Scenario: To check the update chat user executes successfully or not
    Given update chat user payload is created
    When user calls updateChatUser request using PUT method call with user id "211"
    Then Chat user Request should be successful with status code "200"
    Then "result.username" should be "anu1234";

  @deleteChatUser
  Scenario: To check the update chat user executes successfully or not
    Given delete chat user payload is created
    When user calls deleteChatUser request using DELETE method call with user id "207"
    Then Chat user Request should be successful with status code "200"
    Then "error" should be a boolean value "false";
    Then "result" should be a boolean value "true";


  @GetSingleChatUser
  Scenario: To check the update chat user executes successfully or not
    Given getSingle chat user payload is created
    When user calls getSingleChatUser request using get method call with user id "196"
    Then Chat user Request should be successful with status code "200"
    Then "error" should be a boolean value "false";
    Then "result.id" should be a Integer value "196";