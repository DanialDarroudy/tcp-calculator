# TCP Calculator – Client-Server

A modular client-server calculator built with Java.  
Features TCP communication, a custom dependency injection (DI) container, and a microkernel architecture.  
Implements Factory and Strategy design patterns for extensibility, maintainability, and clean separation of concerns.

---

## 🚀 Features
- **TCP communication** between client and server  
- **Custom DI container** for dependency management  
- **Microkernel architecture** enabling modular extensibility  
- **Factory pattern** for flexible object creation  
- **Strategy pattern** for dynamic behavior injection  

---

## 🏗️ Architecture Overview
The system is divided into two main modules:

- **Server**  
  - Listens for TCP requests  
  - Uses DI container to manage dependencies  
  - Executes calculation strategies via microkernel plug-ins  

- **Client**  
  - Sends calculation requests over TCP  
  - Receives and displays results  
  - Can be extended with new interfaces (GUI, etc.)

---

## 🛠️ Technologies
- Java
- TCP protocol  
- Custom DI framework  
- Factory & Strategy design patterns  
- Microkernel modularity  

