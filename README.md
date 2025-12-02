# Travel Agency Back-End Modernization (D288)

## Scenario
A travel agency has recently launched a complete overhaul of their front-end vacation bookings application using Angular and JavaScript. The front-end engineers have encountered various undocumented bugs when sending requests and fetching data from the back-end. The back-end was built in the early 1990s, and the original developer has retired, leaving the system unsupported.  

The CTO decided to create a project to port mission-critical functionalities to a modern framework. You, a Java software developer, were tasked with developing a minimally viable product (MVP) to migrate the legacy back-end to the modern Spring framework.

---

## Requirements
Your submission must represent your **original work** and understanding of the course material. Performance assessments are automatically scanned through the WGU similarity checker. Review your similarity report and ensure **Academic Authenticity** guidelines are met.  

### Notes
- **Professional Communication:** Submissions are assessed via Grammarly for Education. Feedback must be reviewed prior to submission.  
- **File Format:** Write your submission in Microsoft Word (.doc or .docx), unless otherwise specified. Screenshots or proof of experience should be submitted separately as a PDF.  
- **Rubric:** Use the rubric to guide your submission. Each requirement may be evaluated by multiple rubric aspects.  
- **Plugins/Libraries:** External plugins or libraries beyond those specified are **not allowed**.

---

## Project Tasks

### **A. Create a New Java Project**
Use **Spring Initializr** with the following dependencies:
- Spring Data JPA (`spring-boot-starter-data-jpa`)  
- REST Repositories (`spring-boot-starter-data-rest`)  
- MySQL Driver (`mysql-connector-java`)  
- Lombok  

> Copy the supplied `application.properties` into your project as it will initially be empty.

---

### **B. GitLab Integration**
- Log into GitLab using the provided web link.  
- Connect your new Java project.  
- Commit with a message and push after completing **each task** (B–F, etc.).  
- Submissions without commits after each task **will not be evaluated**.  
- Backup commits can be made anytime.  
- Submit:
  - Git repository URL  
  - Repository branch history including commit messages and dates

---

### **C. Create Packages**
Construct the following packages on the same hierarchy level:
- `controllers`  
- `entities`  
- `dao`  
- `services`

Additional:
- Create a `config` package. Copy `RestDataConfig.java` from the lab environment and update package/import addresses.  
- Copy `application.properties` from the lab environment to your project.

---

### **D. Entities**
- Write entity classes matching the UML diagram.  
- Include the required enum.

---

### **E. DAO**
- Write repository interfaces for entities extending `JpaRepository`.  
- Include cross-origin support.

---

### **F. Services**
Implement the following in the `services` package:
- `Purchase` data class (includes customer cart and cart items)  
- `PurchaseResponse` data class (includes order tracking number)  
- `CheckoutService` interface  
- `CheckoutServiceImpl` class (service implementation)

---

### **G. Validation**
- Implement validation to enforce inputs required by the Angular front-end.

---

### **H. Controllers**
- Implement a REST controller `CheckoutController` with a `@PostMapping` to place orders.  
- No need to duplicate repository REST methods in Java.

---

### **I. Sample Data**
- Programmatically add five sample customers.  
- Ensure customer data is **not overwritten** on application restart.

---

### **J. Run and Test**
- Add a customer order for a vacation with two excursions using the unmodified Angular front-end.  
- Provide screenshots showing:
  - No network errors when adding data  
  - Database tables in MySQL Workbench confirming successful data insertion  

> Include the front-end view and browser inspection console in screenshots.

---

### **K. Professional Communication**
- Ensure all submission content and presentation reflect **professional communication standards**.
