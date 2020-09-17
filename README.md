Coverage: 34%
# Project Title

Inventory-Management-System is a Java program using MySQL.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Java 7 or later

IDE - Eclipse
Build tool - Maven
Database managaement System - MySQL

### Installing

1) Clone this repository and open it in your IDE.

2) Either change the 'connect()' method to your own database connection inside the src/main/java/com/qa/ims/utils/DBUtils.java file OR change the database properties method and modify src/main/java/com/qa/ims/IMS.java to pass the file location of 'properties.db' to connect().

3)Run the 'Runner.java' class under src/main/java/com/qa/ims to start the application.

## Running the tests

The tests are located under src/test.

### Unit Tests 

The Junit tests cover some basic testing such as checking classes like Orders or Item have correct equals() and 
hashCode() methods.
  
The tests for the Data-Access Objects (DAOs) are a bit more complex, passing in objects, ensuring they are 
processed correctly and that the correct information is passed back. Example:

@Test
	public void testCreate() {
		final Customer created = new Customer(6L, "Leeand", "Perrins");
		assertEquals(created, DAO.create(created));  
  
Using an IDE you can run these tests by right-clicking the classes and selecting the "Run as JUnit test" 
option or right-click on the IMS folder and click "Run as JUnit test" to run whole application test.

To run these tests in your IDE by right-clicking the classes and selecting "Run as JUnit test".  
  
If you are using eclipse, you can also right-click the project folder and select 'Coverage As...'.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Jordan Harrison** - *IMS Starter* - 
[JHarry444](https://github.com/JHarry444/IMS-Starter)
* **Nick Johnson** - *Updated IMS Starter* 
[nickrstewarttds](https://github.com/nickrstewarttds/IMS-Starter)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
