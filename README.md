# Gitstaticdriver
This project is createdd to automate all type of API's (SOAP And REST)its primerily using rest assured ,mevan dependencies like restassured,testNG,all apachePOI, then we have created TEstNG ,jsonPath , alluar result for details please read the file "ReadMe".

Features of project 

	1)This project is cappable to automate execution and validation:
	 Rest : post , put , patch , get , delete 
	 SOAP

	2) This project is build on the concepts of data driven and keyword driven.
	   I have divided my project into 4 packages
	   * Request Repository: In request repository I have add baseURI, resources, request body
     * Test Class : IN test class package I have add exteactor mehtod 
     * Common methods: I have writen common method like excle data extractor,request responses file creator,excle data upgration and along with other method.
     *Driver class : this driver class is actually driving the entire execution.executer method first called were in execting response status code and body .
  3) The test execution is driven by static driver/testNG xml
  4) my project is cappable to save the evidence of the execution inti the text file contents detaies of
     *request body
     *response received
     * endpoint  
