# Design Decisions – MediTrack Project

## 1. Project Architecture

The project follows a layered structure for better separation of concerns:

- entity → Contains core business models (Doctor, Patient, Appointment, Bill)
- service → Contains business logic
- util → Utility/helper classes
- exception → Custom exception handling
- test → Manual test execution
- Main → Entry point of the application

This structure improves readability, maintainability, and scalability.


## 2. Object-Oriented Design Principles Used

### 1. Encapsulation
All entity classes use private fields with public getters/setters.
This ensures controlled access to data.

### 2. Abstraction
Interfaces like:
- Payable
- Searchable

hide implementation details and expose only required methods.

### 3. Inheritance
- Person → Parent class
- Doctor and Patient extend Person

This reduces code duplication and improves reusability.

### 4. Polymorphism
Interfaces and overridden methods allow flexible behavior.


## 3. Use of Enums

Enums used:
- AppointmentStatus
- Specialization

Reason:
- Prevent invalid values
- Improve type safety
- Make code more readable


## 4. Custom Exception Handling

Custom exceptions created:
- AppointmentNotFoundException
- InvalidDataException

Reason:
- Improve error clarity
- Handle invalid scenarios properly
- Follow clean coding practices


## 5. Utility Classes

Utility classes implemented:
- DateUtil
- IdGenerator
- Validator
- CSVUtil
- DataStore

Reason:
- Centralized reusable functionality
- Avoid code duplication
- Improve modularity


## 6. In-Memory Data Storage

The project uses in-memory storage via DataStore class.

Reason:
- Simple implementation
- No database dependency
- Suitable for console-based application


## 7. Manual Testing Strategy

TestRunner class is used to:
- Validate business logic
- Simulate real-world scenarios
- Verify exception handling

No external testing framework was used.


## 8. Design Trade-offs

- No database integration (simplified version)
- Console-based UI instead of web UI
- Manual test runner instead of JUnit

These decisions were made to focus on core Java concepts.


## 9. Future Improvements

- Add database (MySQL / PostgreSQL)
- Add REST APIs using Spring Boot
- Add proper unit testing using JUnit
- Add logging framework
- Implement authentication system
