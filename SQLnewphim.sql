create database PhimNew
use PhimNew

CREATE TABLE Video (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Title NVARCHAR(255),
    Poster NVARCHAR(255),
    Views INT,
    Description NVARCHAR(MAX),
    Active BIT default 1,
    Url VARCHAR(255) 
);

CREATE TABLE Users (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Password NVARCHAR(255),
    Email NVARCHAR(255) UNIQUE,
    Fullname NVARCHAR(255),
    Admin BIT,
	Active BIT default 1,
);

CREATE TABLE Favorite (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT,
    VideoId INT,
    LikeDate DATE,
    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);

CREATE TABLE Histoty (
	Id INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT,
    VideoId INT,
    HDate DATE default CURRENT_TIMESTAMP,
    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);


CREATE TABLE Share (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT,
    VideoId INT,
    Emails NVARCHAR(MAX),
    ShareDate DATE,
    FOREIGN KEY (UserId) REFERENCES Users(Id),
    FOREIGN KEY (VideoId) REFERENCES Video(Id)
);


