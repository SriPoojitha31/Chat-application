# Chat-application

# 💬 Java Chat Application

A simple console-based Chat Application built using **Java Sockets** and **Multithreading**. This project demonstrates real-time communication between multiple clients through a central server.

---

## 🚀 Features

- 🧠 Multi-client support using threads
- 💬 Real-time message broadcasting
- 🔒 Clean client-server architecture
- 🛠️ Easy to run with pure Java (no external libraries)

---

## 🧱 Technologies Used

- Java SE (Standard Edition)
- Socket Programming (`java.net`)
- Multithreading

---

## 🖥️ How It Works

- The **Server** listens for incoming client connections on a specific port.
- Each **Client** connects to the server and can send/receive messages.
- The server handles multiple clients using Java threads.
- All messages are broadcast to every connected client.

---

## 📁 File Structure

Chat-application/
│
├── ChatServer.java # Server-side code
├── ChatClient.java # Client-side code
└── README.md # Project documentation


---

## ⚙️ How to Run

### 🖥️ Prerequisites
- Java installed (`java -version`)
- Any terminal (Command Prompt / VS Code / Git Bash)

### 🧪 Steps to Run

#### 1. Compile Java files
```bash
javac ChatServer.java
javac ChatClient.java
```

---

Let me know if you want a version with:
- GUI usage
- demo screenshots
- or command aliases (like `.bat` files for faster testing).
