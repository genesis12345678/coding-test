SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, CASE 
                                                          WHEN STATUS = 'SALE' THEN '판매중'
                                                          WHEN STATUS = 'RESERVED' THEN '예약중'
                                                          ELSE '거래완료'
                                                      END AS STATUS
FROM USED_GOODS_BOARD
# WHERE DATE_FORMAT(CREATED_DATE, '%Y-%d-%m') = '2022-10-05'
WHERE YEAR(CREATED_DATE) = 2022 AND MONTH(CREATED_DATE) = 10 AND DAY(CREATED_DATE) = 5
ORDER BY BOARD_ID DESC