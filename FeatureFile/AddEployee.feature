Feature:
As a Admin user Validate Add employee Module
Scenario Outline:
Validate Add employee with multiple data
Given user navigates url in chrome browser
When user enter username as "Admin" and password as "Qedge123!@#"
When user click login button
When user click pim  and click add button
When user enter fname "<FirstName>"
When user enter mname "<MiddleName>"
When user Enter lname "<LastName>"
When user capture Eid Before
When user clicks save button
When user capture Eid after
Then user validates eid
Then user close browser
When user click logout button
Examples:
|FirstName|MiddleName|LastName| 
|geeta|testing|srinu|
|akhi|manual|suresh|
|manual|selenium|testing|
|qtp|selenium|manual|