SELECT
    name,
    population,
    area
FROM
    World
WHERE
    area >= 3000000
UNION
-- UNION is more performant than OR
SELECT
    name,
    population,
    area
FROM
    World
WHERE
    population >= 25000000;