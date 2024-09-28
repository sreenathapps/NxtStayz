-- Drop tables if exist
DROP TABLE IF EXISTS Room;
DROP TABLE IF EXISTS Hotel;

-- Create tables
CREATE TABLE Hotel (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  location VARCHAR(255),
  rating INT
);

CREATE TABLE Room (
  id INT PRIMARY KEY AUTO_INCREMENT,
  roomNumber TEXT,
  type TEXT,
  price DOUBLE,
  hotelId INT,
  FOREIGN KEY (hotelId) REFERENCES Hotel(id)
);