# Leave System

# Description
Create leave requests and send data to Databest. We tested the API with 200 requests. I created separate requests for each request. I created a DTO that receives data from the front-end, sends it to the back-end, and then sends the data to Databest.

## I set post 8013.

## Backend Structure
- Spring Boot 3.3
- Spring Security
- Spring Data JPA
- Java 17
- spring-web
- postgresql
- lombok
- maven

## Databest

- users (id, username, email, role, department, etc.)
- leave_types (id, name, description, max_days)
- leave_requests (id, user_id, leave_type_id, start_date, end_date, status, reason)
- leave_balances (id, user_id, leave_type_id, year, remaining_days)

<img width="1105" height="484" alt="Screenshot 2568-07-30 at 11 51 20" src="https://github.com/user-attachments/assets/e5795483-1768-46f9-b682-a8f3951edc7a" />

