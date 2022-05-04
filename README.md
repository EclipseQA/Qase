# Qase Test Cases

id  	      | Priority     | Preconditions  | Feature		| Name			 | Steps| Expected Result| 
------------- | -------------|-------------|--------------------|------------------------|-----|-----|
1	      | 1 (Smoke)    |Windows 10, Google Chrome browser	   |Login Functionality |Login with *Valid* data |1. User is on Login page | Login page opens |
 	      |               |	 	   |	 		|	 		 |2. Input valid data into **EMAIL** field | Field contains inputted data |
 	      |              |	 	   |	 		| 			 |3. Input valid data into **PASSWORD** field | Field contains data's chars converted into ** |
 	      |               |	 	   |	 		|	 		 |4. Click on 'Login' button | Projects page opens |      
2	      | 1 (Smoke)    |Windows 10, Google Chrome browser	   |Login Functionality |Login with *Invalid* data |1. User is on Login page | Login page opens |
 	      |               |	 	   |	 		|	 		 |2. Input invalid data into **EMAIL** field | Field contains inputted data |
 	      |              |	 	   |	 		| 			 |3. Input invalid data into **PASSWORD** field | Field contains data's chars converted into * |
 	      |               |	 	   |	 		|	 		 |4. Click on 'Login' button | 'These credentials does not match' message is shown |
3	      | 1 (Smoke)    |Windows 10, Google Chrome browser	   |Login Functionality | Login with *Empty* **EMAIL** field |1. User is on Login page | Login page loads  |
 	      |               |	 	   |	 		|	 		 |2. Leave **EMAIL** field empty| 'Email address' message is in field |
 	      |              |	 	   |	 		| 			 |3. Input VALID data into **PASSWORD** field | Field contains data's chars converted into * |
 	      |               |	 	   |	 		|	 		 |4. Click on 'Login' button | 'Заполните это поле.' message is shown under Email field |
4	      | 1 (Smoke)    |Windows 10, Google Chrome browser	   |Login Functionality | Login with *Empty* **PASSWORD** field |1. User is on Login page | Login page loads  |
 	      |               |	 	   |	 		|	 		 |2. Input VALID data into **EMAIL** field| Field contains inputted data |
 	      |              |	 	   |	 		| 			 |3. Leave **PASSWORD** field empty | 'Password' message is in field |
 	      |               |	 	   |	 		|	 		 |4. Click on 'Login' button | 'Заполните это поле.' message is shown under Email field |
5	      | 1 (Smoke)    |Windows 10, Google Chrome browser	|Login Functionality    | Login with *Empty* **PASSWORD and EMAIL** fields |1. User is on Login page | Login page opens |
 	      |               |	 	   			|	 		|	 		 	        |2. Leave **EMAIL** field empty| 'Email address' message is in field |
 	      |              |	 	   			|	 		| 			                |3. Leave **PASSWORD** field empty | 'Password' message is in field |
 	      |               |	 	   			|	 		|	 		 		|4. Click on 'Login' button | 'Заполните это поле.' message is shown under Email field |
6	      | 1 (Smoke)    |Windows 10, Google Chrome browser	|Project Creation    | Create Project **without inputting** data in **Project Code** field |1. User is on Projects page | Projects page opens |
 	      |               |	 	   			|	 		|	 		 	        |2. Click on 'Create new project'| New Project page-form opens |
 	      |              |	 	   			|	 		| 			                |3. Input 'Test' into 'Project name' field | Field contains inputted data |
 	      |               |	 	   			|	 		|	 		 		|4. Leave 'Project code' field | 'TEST' is in field | 
 	      |               |	 	   			|	 		|	 		 		|5. Click on 'Private' option in 'Access type' | 'Private' option is selected |
 	      |               |	 	   			|	 		|	 		 		|6. Click on 'Add all members' option in 'Members access' | 'Members access' option is selected |
 	      |               |	 	   			|	 		|	 		 		|7. Click on 'Create project' button | Project repository opens, message 'Project "test" was created successfully!' is shown |
 	      |               |	 	   			|	 		|	 		 		|8. Click on 'Projects' tabs| Projects pageopens, 'Test' project presents on page |
7	      | 1 (Smoke)    |Windows 10, Google Chrome browser	|Project Creation    | Create Project with an existing project name |1. User is on Projects page | Projects page opens |
 	      |               |	 	   			|	 		|	 		 	        |2. Click on 'Create new project'| New Project page-form opens |
 	      |              |	 	   			|	 		| 			                |3. Input 'Test' into 'Project name' field | Field contains inputted data |
 	      |               |	 	   			|	 		|	 		 		|4. Click on 'Create project' button | 'Project with the same code already exists.' message is shown|
8	      | 1 (Smoke)    |Windows 10, Google Chrome browser	|Test Case Creation    | Create Test Case with all fields filled in |1. User is on Projects page | Projects page opens |
 	      |               |	 	   			|	 		|	 		 	        |2. Click on 'Test' project name| 'Test' repository page opens |
 	      |              |	 	   			|	 		| 			                |3. Click on '+Case' button | 'Create test case' form opens  |
 	      |               |	 	   			|	 		|	 		 		|4. Input 'My case' into Title field| 'My case' is in field | 
 	      |               |	 	   			|	 		|	 		 		|5. Input 'Test description' into Description field | 'Test description' is in field |
 	      |               |	 	   			|	 		|	 		 		|6. Choose 'Minor' option in Severity dropdown | 'Minor' option is selected |
 	      |               |	 	   			|	 		|	 		 		|7. Choose 'Medium' option in Priority dropdown | 'Medium' option is selected |
 	      |               |	 	   			|	 		|	 		 		|8. Choose 'Smoke' option in Type dropdown | 'Smoke' option is selected |
 	      |               |	 	   			|	 		|	 		 		|9. Choose 'E2E' option in Layer dropdown | 'E2E' option is selected |
 	      |               |	 	   			|	 		|	 		 		|10. Choose 'Positive' option in Behavior dropdown | 'Positive' option is selected |
 	      |               |	 	   			|	 		|	 		 		|11. Choose 'E2E' option in Layer dropdown | 'E2E' option is selected |
 	      |               |	 	   			|	 		|	 		 		|12. Choose 'Automated' option in Automation status dropdown | 'Automated' option is selected |
 	      |               |	 	   			|	 		|	 		 		|13. Input 'Win 10, Chrome v.100' into Pre-conditions field | 'Win 10, Chrome v.100' is in field |
 	      |               |	 	   			|	 		|	 		 		|14. Input 'Test postCond' into Post-conditions field | 'Test postCond' is in field |
 	      |               |	 	   			|	 		|	 		 		|15. Click 'Add attachment' button | Upload image form opens |
 	      |               |	 	   			|	 		|	 		 		|16. Click 'Drop files here to upload' button | OS window opens |
 	      |               |	 	   			|	 		|	 		 		|17. Choose 'image' to upload | Image presents in attachments section |
 	      |               |	 	   			|	 		|	 		 		|18. Choose 'Classic' option in Test Case Steps | 'Classic' is selected |
 	      |               |	 	   			|	 		|	 		 		|19. Click **twice** 'Add step' button | Two rows of steps are shown |
 	      |               |	 	   			|	 		|	 		 		|20. Input 'First' in first row 'Action' field | 'First' is in field |
 	      |               |	 	   			|	 		|	 		 		|21. Input 'Second' in first row 'Action' field | 'Second' is in field |
 	      |               |	 	   			|	 		|	 		 		|22. Click 'Save' button| 'Test' repository opens, 'Test case was created successfully!' message is shown, 'My case' test case presents on Page|
9	      | 1 (Smoke)    |Windows 10, Google Chrome browser	|Test Case Creation    | Verify all fields of created test case and actual result  |1. User is on 'Test' repository page | 'Test' repository page opens |
 	      |               |	 	   			|	 		|	 		 	        |2. Click on 'TEST-1' button| 'TEST-1' case form opens |
 	      |              |	 	   			|	 		| 			                |3. Verify 'General' fields | Title = 'My case', Description = 'Test description', Pre-conditions = 'Win 10, Chrome v.100', Post-conditions = 'Test postCond', Chrome v.100',  Severity = 'Minor', Priority ='Medium', Type ='Smoke', Layer ='E2E', Behavior ='Positive', Automation ='Automated', Steps = '1 - First', '2 - Second'|
10	      | 1 (Smoke)    |Windows 10, Google Chrome browser	|Removal of project    | Remove created project with test case |1. User is on Projects page | Projects page opens |
 	      |               |	 	   			|	 		|	 		 	        |2. Click on 'Settings' of 'Test' project dropdown| Dropdown options are displayed|
 	      |              |	 	   			|	 		| 			                |3. Choose 'Delete' option | Delete project page opens |
 	      |               |	 	   			|	 		|	 		 		|4. Click on 'Delete project' button | Projects page opens, 'Test' project doesn't present on page | 


