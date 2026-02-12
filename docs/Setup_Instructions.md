# Setup Instructions – MediTrack

## 1. Prerequisites

- Java JDK 8 or higher
- IntelliJ IDEA / Eclipse (or any Java IDE)
- Git (optional, for cloning repository)

To verify Java installation:

java -version
javac -version


## 2. Clone the Repository (Optional)

If using Git:

git clone https://github.com/lingambaby/MediTrack.git



## 3. Project Structure

src/main/java/com/airtribe/meditrack
    ├── entity
    ├── service
    ├── util
    ├── exception
    ├── test
    └── Main.java


## 4. Import Project in IDE

1. Open IntelliJ / Eclipse
2. Click Open Project
3. Select the MediTrack folder
4. Ensure JDK is configured in Project Settings


## 5. Running the Application

Navigate to:

src/main/java/com/airtribe/meditrack/Main.java

Run Main.java to start the console-based MediTrack system.


## 6. Running Manual Test Cases

Navigate to:

src/main/java/com/airtribe/meditrack/test/TestRunner.java

Run TestRunner.java to execute manual test scenarios.


## 7. Features Supported

- Add Doctor
- Add Patient
- Book Appointment
- View Appointments
- Generate Bill
- Custom Exception Handling
- Enum usage for status and specialization


## 8. Notes

- This is a console-based Java application.
- Data is stored in memory (no database used).
- Manual test cases are implemented using a TestRunner class.
