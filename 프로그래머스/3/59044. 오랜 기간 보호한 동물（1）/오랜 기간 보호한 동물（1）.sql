SELECT 
    A.NAME, A.DATETIME 
FROM 
    ANIMAL_INS A
        LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE 
    B.DATETIME IS NULL
ORDER BY 
    A.DATETIME
LIMIT 
    3
