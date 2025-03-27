Feature: Data driven test with DataTable

@TasksDataTable
Scenario: Testing the To-Do app
  Given user is on the To-Do list page
  When User enters the following tasks
    | task1 |
    | task2 |
    | task3 |
  Then Verify results