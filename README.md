# Plusauth Spring Boot Starter Project



This is a very simple Spring Boot project demonstrating basic authentication flows such as register, login and logout. To keep things simple we used Spring Boot as the server framework and spring-boot-starter-oauth2-client for authentication.


## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [License](#license)

## Prerequisites
Before running the project, you must first follow these steps:

1) Create a Plusauth account and a tenant at https://dashboard.plusauth.com
2) Navigate to `Clients` tab and create a client of type `Regular Web Application`.
3) Go to details page of the client that you've just created and set the following fields as:
* Redirect Uris: http://localhost:8080/login/oauth2/code/plusauth
* Post Logout Redirect Uris: http://localhost:8080/


 Finally write down your Client Id and Client Secret for server configuration 
## Getting Started

First we need to configure the server. Open 'application.yml' in folder /src/main/resources/.

Then configure the file using your Client Id, Client Secret and your Plusauth tenant name.


Finally start the server:

        mvn spring-boot:run
    

The example is hosted at http://localhost:8080/

## License

This project is licensed under the MIT license. See the [LICENSE](LICENSE) file for more info.
