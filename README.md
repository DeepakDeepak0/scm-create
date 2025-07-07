# SCM
# 📇 Smart Contact Manager

Smart Contact Manager (SCM) is a full-stack web application designed to help users securely store and manage their personal or professional contacts. Built with Spring Boot, Thymeleaf, and MySQL, it features user authentication, contact CRUD operations, responsive UI with Tailwind CSS, and support for dark/light themes.

---

## 🚀 Features

- 🔐 User Registration & Login
- 🗂️ Add, Edit, Delete & View Contacts
- 🌓 Dark/Light Theme Toggle
- 🖼️ Profile Picture Upload
- 🔎 Search & Pagination
- 🔒 Spring Security Role-based Access
- 📧 Email Notifications (SMTP Setup)
- 💾 MySQL / H2 Database Support
- 📱 Fully Responsive UI (TailwindCSS)

---

## 🛠️ Tech Stack

**Backend:** Spring Boot, Spring MVC, Spring Security, JPA  
**Frontend:** Thymeleaf, Tailwind CSS  
**Database:** MySQL (or H2 for development)  
**Tools:** Maven, Lombok, Cloudinary (optional), Mailtrap/SMTP

---

## 📁 Project Structure

smart-contact-manager/
├── src/
│ ├── main/
│ │ ├── java/com/scm/ # Backend logic
│ │ └── resources/
│ │ ├── templates/ # Thymeleaf templates
│ │ └── static/ # CSS, JS, images
│ └── test/
├── application.properties
└── pom.xml

---

### 🔧 Prerequisites

- Java 17+
- Maven
- MySQL

---

## ⚙️ Installation & Setup

# 📥 Clone the Project

```bash
git clone https://github.com/DeepakDeepak0/SCM.git


🔧 Application Configuration (Important)
Before running the app, make sure you update the required credentials in src/main/resources/application.properties:

✅ Replace the placeholders in the file:
application.properties

# Database Configuration
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

# Google OAuth2 Login
spring.security.oauth2.client.registration.google.client-id=your_google_client_id
spring.security.oauth2.client.registration.google.client-secret=your_google_client_secret

# GitHub OAuth2 Login
spring.security.oauth2.client.registration.github.client-id=your_github_client_id
spring.security.oauth2.client.registration.github.client-secret=your_github_client_secret

# Cloudinary Configuration
cloudinary.cloud.name=your_cloudinary_name
cloudinary.api.key=your_cloudinary_api_key
cloudinary.api.secret=your_cloudinary_api_secret

# Email Configuration (SMTP / Mailtrap / Gmail)
spring.mail.host=smtp.yourmailhost.com
spring.mail.port=587
spring.mail.username=your_email_username
spring.mail.password=your_email_password
spring.mail.properties.domain_name=yourdomain.com





▶️ Run the App
bash
mvn spring-boot:run

🙋‍♂️ Author
Made with ❤️ by Deepak Maurya
