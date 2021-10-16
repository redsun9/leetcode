SELECT train_id,
       station,
    time as "station_time",
    time - min (time) OVER (PARTITION BY train_id ORDER BY time)
    AS elapsed_travel_time,
    lead(time) OVER (PARTITION BY train_id ORDER BY time) - time
    AS time_to_next_station
FROM train_schedule;


SELECT transaction_id,
       change,
       sum(change) OVER (ORDER BY transaction_id) as balance
FROM balance_change
ORDER BY transaction_id;



SELECT sum(salary) OVER w, avg(salary) OVER w
FROM empsalary WINDOW w AS (PARTITION BY depname ORDER BY salary DESC);


SELECT sales_id,
       customer_id,
       cnt,
       SUM(cnt) OVER (ORDER BY customer_id, sales_id ROWS BETWEEN 1 PRECEDING AND CURRENT ROW) AS before_and_current, SUM(cnt) OVER (ORDER BY customer_id, sales_id ROWS BETWEEN CURRENT ROW AND 1 FOLLOWING) AS current_and_1_next, SUM(cnt) OVER (ORDER BY customer_id, sales_id ROWS BETWEEN 2 PRECEDING AND 2 FOLLOWING) AS before2_and_2_next, SUM(cnt) OVER (ORDER BY customer_id, price_per_item RANGE UNBOUNDED PRECEDING) AS current_and_all_before, SUM(cnt) OVER (ORDER BY customer_id, price_per_item RANGE BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) AS current_and_all_after,
FROM sales
ORDER BY customer_id, sales_id;


SELECT department,
       AVG(salary)
FROM itx_employee
GROUP BY department
HAVING AVG(salary) > 4000


