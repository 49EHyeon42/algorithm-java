-- 1. 기본
SELECT fh.FLAVOR
FROM FIRST_HALF fh
         JOIN ICECREAM_INFO ii ON fh.FLAVOR = ii.FLAVOR
WHERE fh.TOTAL_ORDER > 3000
  AND ii.INGREDIENT_TYPE = 'fruit_based'
ORDER BY fh.TOTAL_ORDER DESC;

-- 2. 서브쿼리
SELECT fh.FLAVOR
FROM (SELECT *
      FROM FIRST_HALF
      WHERE TOTAL_ORDER > 3000) fh
         JOIN (SELECT *
               FROM ICECREAM_INFO
               WHERE INGREDIENT_TYPE = 'fruit_based') ii ON fh.FLAVOR = ii.FLAVOR
ORDER BY fh.TOTAL_ORDER DESC;

-- 3. CTE(Common Table Expression)
WITH FILTERED_FIRST_HALF AS (SELECT *
                             FROM FIRST_HALF
                             WHERE TOTAL_ORDER > 3000),
     FILTERED_INGREDIENT_TYPE AS (SELECT *
                                  FROM ICECREAM_INFO
                                  WHERE INGREDIENT_TYPE = 'fruit_based')
SELECT fh.FLAVOR
FROM FILTERED_FIRST_HALF fh
         JOIN FILTERED_INGREDIENT_TYPE ii ON fh.FLAVOR = ii.FLAVOR
ORDER BY fh.TOTAL_ORDER DESC;
