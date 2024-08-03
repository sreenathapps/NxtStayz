-- Insert sample data into tables
INSERT INTO Hotel (name, location, rating) VALUES
  ('The Plaza Hotel', 'New York', 4),
  ('The Beverly Hills Hotel', 'Los Angeles', 5),
  ('The Langham', 'Chicago', 3);

INSERT INTO Room (roomNumber, type, price, hotelId) VALUES
  ('A-101', 'Deluxe Room', 375.00, 1),
  ('A-205', 'Suite', 950.00, 1),
  ('B-106', 'Penthouse Suite', 2500.00, 1),
  ('C-401', 'Superior Guest Room', 465.00, 2),
  ('D-202', 'Bungalow', 1250.00, 2),
  ('A-107', 'Penthouse Suite', 3300.00, 2),
  ('A-301', 'Grand Room', 410.00, 3),
  ('C-313', 'Executive Suite', 700.00, 3),
  ('D-404', 'Premier Suite', 880.00, 3);