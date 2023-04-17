UPDATE book_list_tb
SET registe_date = DATE_ADD(
	DATE_ADD(
		DATE_ADD(
			CURDATE(),
            INTERVAL -cast(RAND()*(4-1)+1 AS UNSIGNED)
            DAY),
		INTERVAL -cast(RAND()*(4-1)+1 AS UNSIGNED)
		MONTH),    
     INTERVAL -cast(RAND()*(4-1)+1 AS UNSIGNED)
YEAR)