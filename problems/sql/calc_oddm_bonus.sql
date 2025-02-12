--1873. Calculate Special Bonus
SELECT
    employee_id,
    CASE
        WHEN MOD(employee_id, 2) <> 0
        AND name NOT LIKE 'M%' THEN salary
        ELSE 0
    END as bonus
FROM
    Employees
ORDER BY
    employee_id;