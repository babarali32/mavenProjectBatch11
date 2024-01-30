Feature: syntax workflow for HRM

  Background:
    Given a JWT Bearer token is generated

  @API-Scenario-02
  Scenario: create an employee via API work flow
    Given a request is prepared for generating employee
    When a POST call is made to create an employee
    Then status code to create an employee is 201
    And the created employee should contains as a key "Message" and value "Employee Created"
     And the employee id "Employee.employee_id" is stored as global variable to be used for other calls

  @API-Scenario-02
  Scenario: retrieving recently created employee
    Given a request is prepared to get the created employee by using api call
    When a get call is made to retrieve the created employees
    Then the status code for this employee is 200
    And the employee data we get having ID "employee.employee_id" this should be matched with globally stored employee id
    And the retrieved data at "employee" object matches the data used to create an employee with employee id "employee.employee_id"
    |emp_firstname|emp_middle_name|emp_lastname|emp_gender|emp_birthday|emp_status|emp_job_title|
    |sum          |som            |sim         |  Female       | 2020-01-30 |     bad  |      labor  |









