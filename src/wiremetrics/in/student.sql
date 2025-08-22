CREATE DATABASE IF NOT EXISTS smartstudent;
USE smartstudent;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    roll_no VARCHAR(20) UNIQUE,
    department VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(20),
    marks INT
);