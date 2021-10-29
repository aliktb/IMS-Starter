Coverage: 67%

# Inventory Management Project

A Backend Java Application that allows the user to interact with a simple MySQL database for a shop.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

---

If you do not have git bash, install it from <a href=https://git-scm.com/downloads>here</a>

Install MySQL by <a href=https://dev.mysql.com/downloads/windows/installer/8.0.html>clicking here</a>

Install Java by <a href=https://www.oracle.com/java/technologies/downloads/#java8>clicking here</a>

Follow the steps <a href=https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html>here</a> to add JAVA to the system PATH

If you would like to run the application from the source code you will also need to install eclipse from <a href=https://www.eclipse.org/>here</a>

---

### Installing

A step by step series of examples that tell you how to get a development env running:

- Create a new folder in your machine's local directory and open that folder in the file explorer.

- Right-click and select

```
git bash here
```

Type

```
git clone https://github.com/aliktb/IMS-Starter.git
```

- After hitting enter, the repository should be available in your your machine

- Open Eclipse and select

```
File > Open Projects from File System...
```

- Right-click on the project in the package explorer and click

```
Run as > Java Application
```

- The application should now be running in the console. As a quick demo, type

```
customer
```

- Hit enter and type

```
create
```

- Follow the prompts and then type

```
read
```

- You should be able to see all customers.

## Running the tests

Running the tests is as simple as running the project as a JUnit test in Eclipse. The pom.xml contains all the dependencies neccessary to run the tests including JUnit and Mockito. The tests should appear next to the project explorer and break down the test classes and show if any tests have failed.

### Unit Tests

Explain what these tests test, why and how to run them

```
Unit testing through JUnit allows the application's source code to be tested in their smallest units possible, which are methods. Each method's output is verified against a predetermined result that is to be expected given any intial parameters or inputs have been selected. Mockito allows mocking objects in a test to check functionality of a method which relies on an instantiated object.

To run the unit tests, simply run the project  as a JUnit test. JUnit should be available if the dependencies in the pom.xml are set up correctly. To see the test coverage, simply right click on the project in the project tree and select Coverage As > JUnit tests.
```

## Deployment

Deployment can be acheived using the precompiled Fat JAR file and a MySQL database

## Built With

- [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [Git](https://git-scm.com/) for versioning.

## Authors

- **Chris Perrins** - _Initial work_ - [christophperrins](https://github.com/christophperrins)

- **Ali Khattab** - _Final result_ - [aliktb](https://github.com/aliktb)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- Many thanks go to the [QA Academy](https://www.qa.com/) and their trainers for their expertise and support
