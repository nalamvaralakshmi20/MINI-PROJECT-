1. Start Docker (before any terminal commands)
Windows / Mac (Docker Desktop)

Open Docker Desktop from the Start menu / Applications.
Wait until it says Docker is running (whale icon steady).
There is usually no reliable “start Docker” terminal command on Desktop; the app must be running.
Linux (if they use Docker Engine, not Desktop)


sudo systemctl start docker
Check Docker works:


docker version
docker compose version
If both print versions, Docker is ready.

2. Get the code on their computer (only if they don’t have the folder yet)
Option A – Git (one time)


git clone https://github.com/nalamvaralakshmi20/MINI-PROJECT-.git
cd MINI-PROJECT-
Option B – Already have the repo
Open terminal in the folder that contains docker-compose.yml:


cd path/to/MINI-PROJECT-
Option C – ZIP
GitHub → repo → Code → Download ZIP → unzip → cd into the folder.

3. Run the project (this is the main part)
From that folder:


docker compose up --build
Leave the terminal open while using the app.
First time: often 20–40 minutes (big Oracle download + first DB setup).
Later runs: often 1–3 minutes.
When it’s ready, open in the browser:

http://localhost:8081/

Logins

Role	Username	Password
Student
shoaib
system
Admin
admin
admin123
4. Stop when done
In the same terminal: Ctrl+C, then:


docker compose down
Copy-paste block for your friend
If they already have the MINI-PROJECT- folder on their laptop:


docker compose up --build
Then open http://localhost:8081/.

If they only see the repo on GitHub and have no folder yet:


git clone https://github.com/nalamvaralakshmi20/MINI-PROJECT-.git
cd MINI-PROJECT-
docker compose up --build
Then open http://localhost:8081/.

Summary: Push to their GitHub = everyone can use that repo. Each person still needs the files on their machine once, then only docker compose up --build (with Docker Desktop running) to run the project.








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
