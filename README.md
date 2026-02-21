# Blogging Platform API

A robust Spring Boot REST API featuring asynchronous notifications, secure authentication, and MySQL integration.

##  Key Features
* **Asynchronous Email Notifications**: Leverages `@EnableAsync` and `@Async` to send comment alerts in the background, ensuring near-instant API response times.
* **User Authentication**: Secured with Spring Security using **Basic Auth** and **BCrypt** password encoding.
* **Relational Persistence**: Uses **MySQL** for managing complex relationships between Users, Posts, and Comments.

##  Prerequisites
* **Java**: Version 23 (Requires `--enable-preview` flags).
* **Database**: MySQL Server.
* **Email**: A Gmail account with **2-Step Verification** enabled and an **App Password**.

##  Setup Instructions
1. **Clone the project** to your local machine.
2. **Database Setup**: Create a schema named `bloggingPlatform` in your MySQL Workbench.
3. **Configure Secrets**:
   - Copy `src/main/resources/application.properties.template` to `application.properties`.
   - Update `spring.mail.username` and `spring.mail.password` (16-digit App Password).
4. **Run the Application**: Ensure your IDE is configured to handle Java 23 preview features.

## API Endpoints
| Action | Method | Endpoint | Auth |
| :--- | :--- | :--- | :--- |
| **Register User** | `POST` | `/api/users/register` | None |
| **Create Post** | `POST` | `/api/posts` | Basic Auth |
| **Add Comment** | `POST` | `/api/comments/post/{postID}` | Basic Auth |

