# DockerIntegration with Selenium and TestNG. Seleniumstandalone chrome and Firefox

Docker is Containerization platform which can pack test suite and all it's dependencies.Using Docker we can run the test in isolated Docker Container and it do not 
require WebDriver, drivers or Browsers installed on your system.Highly recommended for Grid infrastructure, as nodes can be easly configured as Docker containers instead of configuring multiple environments on different virtual machine or different systems (which in terms require configuration and maintenance efforts).  

Install Docker on system.  
**1.) SELENIUM CHROME**  
docker pull selenium/standalone-chrome:latest     // For chrome seltup  
docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:latest  
docker ps  
		ChromeOptions op = new ChromeOptions();  
		URL url = new URL(""http://localhost:4444""); or http://localhost:4444/wd/hub  
		RemoteWebDriver driver = new RemoteWebDriver(url,op);  
    And Now run normal tests, execution will perform in background.  

**2.) SELENIUM FIREFOX**  
docker stop CONTAINER_ID // we can get container ID from docker ps command  
docker pull selenium/standalone-firefox:latest     // For firefox setup  
docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-firefox:latest  
docker ps  
		FirefoxOptions op = new FirefoxOptions();  		
		URL url = new URL(""http://localhost:4444"");  
		RemoteWebDriver driver = new RemoteWebDriver(url,op);  


Basic Commands in DOCKER - after installing docker open the CMD as Admin and execute commands as below to work with Docker  
docker version	version of cloud client, Docker desktop and some more information  
docker --version	          	:only the version  
docker info	                	:information about number of containers, images and more   
docker help	                	:List of definitions of different Docker commands  
docker login	              		:Let the user login to Docker desktop and links it to hub, Prompts to enter userName and password  
docker logout	              		:to logout from Docker  
docker images	              		:give you list of images pulled from hub with information like image ID, created etc  
docker pull                 		:IMAGE_NAME	will pull the IMAGE_NAME image from hub  
docker rmi IMAGE_ID	        	:will delete the image from Desktop docker  
docker rmi -f IMAGE_ID	    		:will delete forcefully even if the image is in use  
docker ps	                  	:available containers in Docker with information like container id, created, Image using etc  
docker rm CONTAINER_ID	    		:will remove the container from Docker desktop  
docker rm -f CONATINER_ID	  	:will delete the contianer forcefully even if it is in use somewhere  
docker stop CONTAINER_ID	  	:will stop the container  
docker stats	              		:will show use of CPU and other stats by Docker  
docker system df	          	:will give number of containers, images and size on Desktop Docker  
docker system prune	        	:this will remove all stopped containers from Docker Desktop  


## Next will be implementing Selenium Grid 

From-  https://github.com/SeleniumHQ/docker-selenium/blob/trunk/docker-compose-v3.yml download or copy content of the file  	
Read instruction in the file And -	save the file on system as:     docker-compose-v3.yml   
Opne CMD- 	cd directory to file location  
Run the Docker grid using compose as- 	docker-compose -f docker-compose-v3.yml up  
Check Grid containers are configured-	open URL in browser and grid setup with 3 nodes should show:   http://localhost:4444/grid/console  
Scale more chrome nodes--	docker-compose scale chrom=2    
// one chrome node we already have created above from file and this command will make chrome node total to 2, by addgin one more
docker images- 	command will show number images - which in this case should be 4, 3 for each browser and one for hub   
docker ps-	should show at-least 4 containers : 4 for each node browser (as chrome image is scaled to 2) and 1 hub  
Setup the test code file (e.g. GridDockerIntegrationTestNG) to point hub and when execution will be parallel from testNG it will allocate the available nodes in parallel way- for example in our code we setup 4 containers and we have four @Test methods. In testNG.xml we setup parallel execution on the basis of methods so each test case will execute parallely on respective Containers created in Docker Grid setup above 	

