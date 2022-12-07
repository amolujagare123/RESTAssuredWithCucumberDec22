Feature: all requests related to reqres.in

  @sampleCreateUser
  Scenario: to check the create user requests executes successfully
    Given Create user payload is created
    When user calls createUser request using POST method call
    Then Request should be successful with status code "201"
    And "job" should be "HR"

  @sampleUpdateUser
  Scenario: to check the update user requests executes successfully
    Given Update user payload is created
    When user calls updateUser request using PUT method call
    Then Request should be successful with status code "200"
    And "job" should be "zion resident"
    And "name" should be "AMOL"


  @sampleDeleteUser
  Scenario: to check the delete user requests executes successfully
    Given Delete user payload is created
    When user calls deleteUser request using DELETE method call
    Then Request should be successful with status code "204"

  @sampleGetAllUser
  Scenario: to check the delete user requests executes successfully
    Given Get All user payload is created
    When user calls getAllUser request using GET method call
    Then Request should be successful with status code "200"