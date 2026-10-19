# Project Explanation for FSD2 Web Application

## What This Project Does

This is a **Student Feedback System** - a web application where:
- Students can login and submit feedback about courses
- Admins can login and view all feedback from students
- Students can also view and manage student records (CRUD operations)

---

## Main Components Explained

### 1. LoginServlet (Login Form)
**What it does:**
- Shows a login page where users enter username and password
- Checks if the username/password matches in the Oracle database
- If correct: Creates a session and shows welcome message
- If wrong: Shows error message

**Why it's needed:**
- Security - only authenticated users can access the system
- Session management - remembers who is logged in
- Role-based access - students see different things than admins

**How it works:**
1. User types username/password in HTML form
2. Servlet checks Oracle database `users` table
3. If found: Creates session with username and role
4. Redirects to dashboard

---

### 2. DashboardServlet (Dashboard)
**What it does:**
- Shows the main menu after login
- Displays different options based on user role
- Students see: View Records, Insert Student, CRUD, Submit Feedback
- Admins see: All of the above + View All Feedback (Admin)

**Why it's needed:**
- Central navigation hub
- Role-based access control
- Prevents unauthorized access to admin features

**How it works:**
1. Checks if user is logged in (session check)
2. Gets user's role from session
3. Shows different menu items based on role
4. Admin gets extra "View All Feedback" option

---

### 3. LogoutServlet (Logout)
**What it does:**
- Ends the user's session
- Redirects to login page

**Why it's needed:**
- Security - clears session when user logs out
- Prevents unauthorized access after logout

**How it works:**
1. Gets current session
2. Invalidates (destroys) the session
3. Redirects to login.html

---

### 4. InsertStudentServlet (Add Student)
**What it does:**
- Shows a form to add new students
- Inserts student data into Oracle database
- Displays success/error message

**Why it's needed:**
- Add new students to the system
- Demonstrates database INSERT operation
- Shows how to handle form submissions

**How it works:**
1. doGet: Shows HTML form with ID, Name, Branch, Year fields
2. doPost: When user clicks submit, gets form data
3. Inserts into Oracle `students` table
4. Shows success message

---

### 5. CrudServlet (CRUD Operations)
**What it does:**
- Full Create, Read, Update, Delete operations on students
- Shows all students in a table
- Allows deleting students
- Allows inserting new students
- Allows updating student branch

**Why it's needed:**
- Complete database manipulation
- Demonstrates all CRUD operations
- Shows how to handle database actions

**How it works:**
1. **Create**: Form to insert new student
2. **Read**: SELECT query to show all students in table
3. **Update**: Form to update student's branch
4. **Delete**: Link to delete a student by ID

---

### 6. DisplayRecordsServlet (View Records)
**What it does:**
- Shows all student records from Oracle database
- Displays in an HTML table

**Why it's needed:**
- View all student data
- Demonstrates SELECT query
- Shows how to display database data in web page

**How it works:**
1. Connects to Oracle database
2. Runs SELECT query on `students` table
3. Displays results in HTML table

---

### 7. FeedbackServlet (Submit Feedback)
**What it does:**
- Shows feedback form to students
- Inserts feedback into Oracle database
- Shows success/error message

**Why it's needed:**
- Part of the mini project (Student Feedback System)
- Collects student feedback about courses
- Demonstrates form handling and database INSERT

**How it works:**
1. Checks if user is logged in
2. Shows form with: Student Name, Roll No, Course, Feedback
3. When submitted, inserts into `feedback` table
4. Shows success message

---

### 8. AdminFeedbackServlet (View All Feedback - Admin Only)
**What it does:**
- Shows all feedback submitted by students
- Only accessible to admin users

**Why it's needed:**
- Admin can see all student feedback
- Demonstrates role-based access control
- Part of mini project

**How it works:**
1. Checks if user is logged in AND is admin
2. If not admin: redirects to login
3. If admin: shows all feedback from database

---

### 9. RegisterServlet (Student Registration)
**What it does:**
- Shows registration form for new students
- Inserts new student into database

**Why it's needed:**
- Allows new students to register themselves
- Demonstrates user registration flow
- Part of Unit 2 (JSP + MVC) labs

**How it works:**
1. Shows registration form
2. When submitted, inserts into database
3. Shows success message

---

### 10. MvcLoginServlet (MVC Pattern Login)
**What it does:**
- Demonstrates MVC (Model-View-Controller) pattern
- Servlet (Controller) → Bean (Model) → JSP (View)

**Why it's needed:**
- Shows proper MVC architecture
- Separates business logic from presentation
- Part of Unit 2 labs

**How it works:**
1. Servlet handles login (Controller)
2. JavaBean holds data (Model)
3. JSP displays result (View)

---

### 11. HelloServlet (Simple Test)
**What it does:**
- Simple "Hello World" servlet
- Tests if Tomcat is working

**Why it's needed:**
- Quick test to verify setup
- First servlet example

---

## Database Tables Used

### 1. `users` Table
Stores login credentials
- username (primary key)
- password
- role (student or admin)

### 2. `students` Table
Stores student information
- id (primary key)
- name
- branch
- year

### 3. `feedback` Table
Stores student feedback
- id (primary key)
- student_name
- roll_no
- course
- feedback_text
- submitted_date

---

## Session Management

What is a session?
- A session is like a "login ticket" that remembers who you are
- When you login, server creates a session
- Session stores: username, role
- When you logout, session is destroyed

Why sessions are needed:
- Security - prevents unauthorized access
- Personalization - shows user-specific data
- Role-based access - different features for different users

---

## User Credentials

| Role | Username | Password | What They Can Do |
|------|----------|----------|-------------------|
| Student | shoaib | system | Submit feedback, view records, CRUD operations |
| Admin | admin | admin123 | All student features + View all feedback |

---

## Summary

This project demonstrates:
1. **Servlet-based web development**
2. **Database connectivity with Oracle**
3. **Session management** (login/logout)
4. **Role-based access control** (student vs admin)
5. **CRUD operations** (Create, Read, Update, Delete)
6. **MVC pattern** (Model-View-Controller)
7. **JSP (JavaServer Pages)** for dynamic web pages
8. **Mini Project** (Student Feedback System)

All of these are standard Java web development concepts used in real-world applications.
