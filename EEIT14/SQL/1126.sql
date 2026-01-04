-- SELECT *,fee*0.9
-- FROM Bill
-- ORDER BY fee DESC
-- where fee >= 400 AND fee <= 700
-- where fee BETWEEN 400 AND 700
-- where fee NOT BETWEEN 400 AND 700
-- where fee < 400 or fee > 700

SELECT *,
         CASE 
              WHEN fee >= 700 THEN fee * 0.8
              WHEN fee >= 400 THEN fee * 0.9
              ELSE fee
         END AS discount
FROM Bill