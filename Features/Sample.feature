Feature: all requests related to reqres.in

  @sampleCreateUser @switch
  Scenario: to check the create user requests executes successfully
    Given Create user payload is created
   # When user calls createUser request using POST method call
    When user calls "createUser" request using "POST" method call
    Then Request should be successful with status code "201"
   # And "job" should be "HR"


  @sampleCreateUserDataProvider
  Scenario Outline: to check the create user requests executes successfully
    Given Create user payload is created with <name> and <job>
    When user calls createUser request using POST method call
    Then Request should be successful with status code "201"
   # And "job" should be "HR"
    Examples:
      | name       | job          |
      | Amol       | HR           |
      | Pradeep    | Test Lead    |
      | Vivekanand | Manager      |
      | Rajesh     | Tech Support |

  @sampleUpdateUser  @switch
  Scenario: to check the update user requests executes successfully
    Given Update user payload is created
   # When user calls updateUser request using PUT method call
    When user calls "updateUser" request using "PUT" method call
    Then Request should be successful with status code "200"
  #  And "job" should be "zion resident"
   # And "name" should be "AMOL"


  @sampleDeleteUser @switch
  Scenario: to check the delete user requests executes successfully
    Given Delete user payload is created
    #When user calls deleteUser request using DELETE method call
    When user calls "deleteUser" request using "DELETE" method call
    Then Request should be successful with status code "204"

  @sampleGetAllUser @switch
  Scenario: to check the get all user requests executes successfully
    Given Get All user payload is created
   # When user calls getAllUser request using GET method call
    When user calls "getAllUsers" request using "GET" method call
    Then Request should be successful with status code "200"

  @sampleSingleUser @switch
  Scenario: to check the get Single user requests executes successfully
    Given Get single user payload is created
   # When user calls getAllUser request using GET method call
    When user calls "getSingleUser" request using "GET" method call
    Then Request should be successful with status code "200"