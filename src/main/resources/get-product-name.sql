SELECT P.PRODUCT_NAME
FROM CUSTOMERS O
         JOIN ORDERS P ON O.ID = P.CUSTOMER_ID
WHERE LOWER(O.NAME) = LOWER(:name)
;