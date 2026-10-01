<p align="center">
  <img src="banner.svg" alt="Grampanchayat Automation System" width="100%">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-f89820?style=for-the-badge&labelColor=0f172a" alt="Java">
  <img src="https://img.shields.io/badge/GUI-Swing-38bdf8?style=for-the-badge&labelColor=0f172a" alt="Swing">
  <img src="https://img.shields.io/badge/Build-Apache%20Ant-d22128?style=for-the-badge&labelColor=0f172a" alt="Ant">
  <img src="https://img.shields.io/badge/IDE-NetBeans-1b6ac6?style=for-the-badge&labelColor=0f172a" alt="NetBeans">
  <img src="https://img.shields.io/badge/Status-Working-22c55e?style=for-the-badge&labelColor=0f172a" alt="Status">
</p>

---

## Overview

Grampanchayat Automation System is a Java desktop application that replaces paper registers in a Gram Panchayat office. It stores and manages **birth, death and marriage records** in a database and generates the matching certificates.

## Features

| Module | What it does |
|--------|--------------|
| **Login and Users** | Secure login, add / edit / delete users |
| **Birth Records** | Add, edit, delete and view records in a table |
| **Death Records** | Add, edit, delete and view records in a table |
| **Marriage Records** | Add, edit, delete and view records in a table |
| **Certificates** | Generate birth, death and marriage certificates |
| **Database** | All records stored centrally through `DatabaseConnection.java` |

## Tech Stack

- **Language:** Java
- **GUI:** Java Swing
- **Build tool:** Apache Ant (NetBeans project)
- **Database:** configured in `src/DatabaseConnection.java`

## Project Structure

```
Grampanchayat Automation System
├── src/            Java source files and images
├── nbproject/      NetBeans project configuration
├── build.xml       Ant build file
└── manifest.mf
```

## Requirements

- Java JDK 8 or newer
- A running database server with the required database and tables
- NetBeans IDE or Apache Ant (optional)

## Getting Started

**Run the jar**

```bash
java -cp dist/grampanchayat.jar Login
```

**Run from NetBeans**

1. Open the project in NetBeans.
2. Update the database details in `src/DatabaseConnection.java`.
3. Run the `Login` class.

**Build with Ant**

```bash
ant jar
```

## Database Setup

1. Start your database server.
2. Create the database and tables used by the project.
3. Set the URL, username and password in `src/DatabaseConnection.java`.

## Roadmap

- Search and filter records
- Export records to PDF or Excel
- Role-based access (admin and clerk)

## Author

**Korabu Naved Arif**

[![GitHub](https://img.shields.io/badge/GitHub-MoghalPathan-181717?style=for-the-badge&logo=github&labelColor=0f172a)](https://github.com/MoghalPathan)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Naved%20Korabu-0a66c2?style=for-the-badge&logo=linkedin&labelColor=0f172a)](https://www.linkedin.com/in/naved-korabu-2b8221434/)
