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
  roomNumber VARCHAR(20),
  type VARCHAR(50),
  price DECIMAL(10, 2),
  hotelId INT,
  FOREIGN KEY (hotelId) REFERENCES Hotel(id)
);