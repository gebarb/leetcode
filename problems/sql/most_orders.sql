-- 586. Customer Placing the Largest Number of Orders
SELECT
    customer_number
FROM
    Orders
GROUP BY
    customer_number
HAVING
    COUNT(DISTINCT order_number) = (
        SELECT
            MAX(order_count)
        FROM
            (
                SELECT
                    customer_number,
                    COUNT(DISTINCT order_number) AS order_count
                FROM
                    orders
                GROUP BY
                    customer_number
            ) AS counter
    );