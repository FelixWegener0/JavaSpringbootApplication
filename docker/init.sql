-- create database
CREATE DATABASE IF NOT EXISTS my_database;

-- use current database
USE my_database;

-- create table for user
CREATE TABLE IF NOT EXISTS user (
    id int AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    mobileAppToken varchar(255),
);

-- create table for temperature
CREATE TABLE IF NOT EXISTS environmentalMetrics (
    id int AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    temperature DOUBLE,
    humidity DOUBLE,
    room varchar(100)
);