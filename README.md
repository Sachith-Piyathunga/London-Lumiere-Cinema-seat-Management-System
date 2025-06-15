# 🎟️ London Lumiere Cinema Seat Management System

A terminal-based Java application that simulates a seat reservation system for the **London Lumiere Cinema**. This system allows users to buy and cancel tickets, view seat availability, print tickets and customer information, and more, all via a simple console interface.

---

## 📌 Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Class Breakdown](#class-breakdown)
- [How to Run](#how-to-run)
- [Sample Output](#sample-output)
- [References](#references)
- [Author](#author)

## 📖 Project Overview

This application was developed as part of a university coursework project. It provides basic functionality for a cinema ticketing system using core **Object-Oriented Programming (OOP)** concepts in Java. It is designed to demonstrate Java classes, encapsulation, arrays, and user interaction through the terminal.

---

## ✅ Features

- 🎫 Buy tickets for available seats
- ❌ Cancel existing tickets
- 🪑 Display real-time seat layout (free/sold)
- 🔍 Search for a ticket by seat number
- 🔢 Sort tickets by price in ascending order
- 💰 Display total income from sold tickets
- 👤 Print customer (person) and ticket details
- ⏩ Automatically locate the first available seat
- 🧪 Validations for user inputs and seat selection

---

## ⚙️ Technologies Used

- 💻 **Java** (JDK 17)
- 🖥️ Console-based interface
- 📦 No third-party libraries used

---

### Main Screen

![image alt](https://github.com/Sachith-Piyathunga/London-Lumiere-Cinema-seat-Management-System/blob/024bb39bd91b134265cfbc7d0f324630d562dbc8/Image/1743077267659.jpg)

### Seating Plan

![image alt](https://github.com/Sachith-Piyathunga/London-Lumiere-Cinema-seat-Management-System/blob/0d112c793cc646d556b6553718d49c100e5a330b/Image/Screenshot_20250615_113142.png)

---

## 🧱 Class Breakdown

### 1. `CinemaManagement.java`
- Acts as the **main class** with the program’s menu and logic
- Manages the array of seats and the list of tickets

### 2. `Seat.java`
- Represents each seat
- Tracks availability using a simple integer flag (0 = free, 1 = sold)

### 3. `Person.java`
- Stores customer information: name, surname, and email
- Provides methods to get and set customer data

### 4. `Ticket.java`
- Represents a ticket that combines seat, price, and associated `Person`
- Automatically assigns price based on row:
  - Row 1 → Rs. 12
  - Row 2 → Rs. 10
  - Row 3 → Rs. 8

---

## ▶️ How to Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/<your-username>/LondonLumiereCinema.git
cd LondonLumiereCinema
```

### Step 2: Compile the Java Files
```
javac *.java
```

### Step 3: Run the Program
```
java CinemaManagement
```
