-- 1158. Market Analysis I
SELECT
    u.user_id AS buyer_id,
    u.join_date,
    COUNT(DISTINCT o.order_id) AS orders_in_2019
FROM
    Users u
    LEFT JOIN Orders o ON u.user_id = o.buyer_id
    AND o.order_date BETWEEN '2019-01-1' AND '2020-01-01'
GROUP BY
    u.user_id;