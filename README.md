# Servlet & JSP Repository Documentation

This repository contains several Java Servlet-based web application examples created for learning how Apache Tomcat works with servlets, how servlet requests are handled, and how Java web applications are structured.

## Repository overview

Each folder in this repository is a separate Maven web application or server configuration workspace. The examples cover basic servlet request handling, login validation, session management, MVC architecture, and a small complaint management system.

## Projects included

- `FirstSerlvet/`
  - A basic servlet example using HTML forms and servlet request processing.
  - Demonstrates form submission, servlet `doGet()`/`doPost()` handling, and response generation.

- `LoginApplication/`
  - A login and registration example using servlets to process credentials.
  - Focuses on form handling and basic control flow between login/register pages and servlet classes.

- `LoginValidation/`
  - A simple login validation example showing how servlets validate form inputs.
  - Demonstrates checking username/password values and forwarding or redirecting users.

- `MVC_Project/`
  - A Model-View-Controller style web application.
  - Includes controller servlets, model classes, repository/service layers, and static web pages.
  - Shows a more organized architecture for building real-world servlet projects.

- `Session_Handling/`
  - An example of HTTP session usage with servlets.
  - Demonstrates how to store and retrieve user state across multiple requests.

- `Smart-Complaint-System/`
  - A small complaint management system built with servlet controllers and model classes.
  - Includes repository and service layers to separate data handling from request logic.

- `Servers/`
  - Contains Apache Tomcat server configuration files for Tomcat runtime settings.
  - Useful when deploying and testing these projects with a local server instance.

- `TestSync/`
  - Contains an additional Tomcat server workspace and example project setup.

## How this documentation is organized

This README explains:

- the purpose of each example project
- the common structure of Java web applications
- how Apache Tomcat loads and executes servlets
- how to run these projects using Maven and Tomcat

## Java web application structure

Each project follows a common Maven webapp layout:

- `pom.xml` - Maven project and build configuration.
- `src/main/java` - servlet code and Java application classes.
- `src/main/webapp` - HTML pages, CSS, JavaScript, and web resources.
- `src/main/webapp/WEB-INF/web.xml` - servlet mappings and deployment configuration.
- `target/` - build output directory created by Maven.

### Important directories

- `WEB-INF/` is hidden from direct browser access and contains configuration files.
- `META-INF/` holds metadata such as manifest information.
- `lib/` contains library JAR files used by the web application.

## How Apache Tomcat handles servlets

Apache Tomcat is a servlet container that handles HTTP requests for Java web applications.

The servlet workflow is:

1. A browser sends an HTTP request to Tomcat.
2. Tomcat determines which web application should handle the request.
3. Tomcat maps the request URL to a servlet using `web.xml` or annotations.
4. The servlet is loaded and initialized if it is not already running.
5. Tomcat calls the servlet's `service()` method, which delegates to `doGet()` or `doPost()`.
6. The servlet processes the request, interacts with business logic, and generates a response.
7. Tomcat sends the HTTP response back to the client.

## How to run these projects

### Using Eclipse or an IDE

1. Import each project as a Maven project.
2. Add Apache Tomcat as a runtime server in the IDE.
3. Configure each project to use the Tomcat runtime.
4. Start Tomcat from the IDE and deploy the desired project.
5. Open the browser at `http://localhost:8080/<project-name>/`.

### Using Maven and command line

1. Open a command prompt in a project folder.
2. Run:
   ```powershell
   mvn clean package
   ```
3. Deploy the generated WAR or project folder to Tomcat's `webapps` directory.
4. Start Tomcat.
5. Browse to:
   ```
   http://localhost:8080/<project-name>/
   ```

> Note: If the project uses Eclipse workspace deployment, the application name may be based on the workspace project name.

## Learning guide

To learn from this repository, follow these steps:

1. Start with `FirstSerlvet/` to understand simple request/response handling.
2. Inspect `web.xml` and servlet classes to see how mappings are configured.
3. Move to `LoginApplication/` and `LoginValidation/` to learn form processing and validation.
4. Explore `Session_Handling/` to understand how session state is maintained across requests.
5. Study `MVC_Project/` to see a more structured application layout.
6. Review `Smart-Complaint-System/` for a practical example with multiple servlets and service layers.

## Recommended exploration steps

- Open HTML pages and locate `<form action="...">` attributes.
- Match form actions to their servlet URLs or mapped servlet names.
- Read servlet source code for `doGet()` and `doPost()` methods.
- Review how each servlet forwards or redirects requests.
- Check how data is passed between servlets, sessions, and views.

## Notes

- Each folder is a standalone example, not a single integrated application.
- You can run one project at a time on Tomcat.
- These examples are useful for learning core servlet concepts and Tomcat deployment.

---

Happy learning! Use this repository as a step-by-step guide to understand servlet lifecycle, request processing, and Tomcat deployment.
