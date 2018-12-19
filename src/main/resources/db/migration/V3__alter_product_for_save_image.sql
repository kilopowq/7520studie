ALTER TABLE Product
  RENAME COLUMN image TO imageBytes;

ALTER TABLE Product ALTER COLUMN
  imageBytes TYPE bytea USING imageBytes::bytea;