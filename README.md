# FSD2 Web Application

Servlet and JSP labs plus the student feedback mini project. The application uses Java 21, `javax.servlet`, Tomcat 9, and Oracle Database Free (`FREEPDB1`).

A friend only needs Docker Desktop. Clone the repository and start both the web app and the database:

```bash
git clone https://github.com/shaikmohammedshoaib666/OMG-FSD2.git
cd OMG-FSD2
docker compose up --build
```

Open [http://localhost:8081/](http://localhost:8081/).

| Role | Username | Password |
|------|----------|----------|
| Student | shoaib | system |
| Admin | admin | admin123 |

The first run downloads Oracle Database Free and creates the database. That can take several minutes. Later starts are faster. `docker compose down` stops the containers and keeps the data. `docker compose down -v` also deletes the database volume.

The web app is published on port 8081 and Oracle on port 1522 so they do not collide with a Tomcat or Oracle install already using 8080 and 1521. Inside Docker the app connects to `oracle-db:1521/FREEPDB1` as `shoaib`. The startup script creates `users`, `students`, and `feedback`, and inserts the two logins above.

## What is in the repository

- `src/servlets` and `src/beans` — the web application
- `web/` — HTML, JSP, and `web.xml`
- `fsd2-jdbc-maven/` — standalone JDBC exercises, not required to run the site
- `db/init/01-schema.sh` — tables and sample rows created on the first database start

## Running in IntelliJ instead

If Oracle is already running on `localhost:1521/FREEPDB1` with user `shoaib` / password `system`, open this folder in IntelliJ and deploy it to Tomcat 9. `DbConfig` uses those values when the Docker environment variables are not set. Tomcat 10 and 11 need a `jakarta.servlet` migration and are not supported by this code.
