CREATE TABLE IF NOT EXISTS "products"
(
    "id" BIGSERIAL PRIMARY KEY NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "carbs" FLOAT NOT NULL,
    "fats" FLOAT NOT NULL,
    "proteins" FLOAT NOT NULL,
    "calories" FLOAT NOT NULL,
    "article" VARCHAR(25) NOT NULL
);