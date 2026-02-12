# JVM Report – MediTrack Project

## 1. Introduction to JVM

JVM (Java Virtual Machine) is a virtual machine that enables Java programs to run on any platform.
It executes Java bytecode and makes Java platform-independent.

Java Source Code (.java)
        ↓
Compiled by javac
        ↓
Bytecode (.class)
        ↓
Executed by JVM


## 2. Class Loader Subsystem

The Class Loader is responsible for loading class files into memory.

It follows the Parent Delegation Model.

Types of Class Loaders:

1. Bootstrap ClassLoader
   - Loads core Java libraries (rt.jar)

2. Extension ClassLoader
   - Loads classes from extension libraries

3. Application ClassLoader
   - Loads classes from the application classpath


## 3. JVM Memory Structure (Runtime Data Areas)

### 1. Method Area
- Stores class metadata
- Stores static variables
- Stores method bytecode

### 2. Heap Area
- Stores objects and instance variables
- Shared across all threads
- Garbage Collector works here

### 3. Stack Area
- Each thread has its own stack
- Stores local variables
- Stores method calls (stack frames)

### 4. PC Register
- Stores address of current executing instruction

### 5. Native Method Stack
- Used for native (non-Java) methods


## 4. Execution Engine

The Execution Engine executes the bytecode.

It has three main components:

### 1. Interpreter
- Executes bytecode line by line
- Slower but simple

### 2. JIT (Just-In-Time) Compiler
- Converts frequently used bytecode into native machine code
- Improves performance

### 3. Garbage Collector
- Automatically removes unused objects from Heap memory
- Prevents memory leaks


## 5. JIT vs Interpreter

Interpreter:
- Executes code line by line
- Slower performance

JIT Compiler:
- Converts bytecode to machine code
- Faster execution
- Improves runtime efficiency


## 6. Write Once, Run Anywhere (WORA)

Java achieves platform independence because:

- Java code is compiled into bytecode
- Byte
