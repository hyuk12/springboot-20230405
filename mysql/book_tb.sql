INSERT INTO
book_tb
SELECT
	0 as book_id, 
	book_name,
    author_id,
    publisher_id,
    category_id,
    cover_img_url
FROM
	(SELECT
		ROW_NUMBER() OVER(PARTITION BY
			book_name,
            author_id,
            publisher_id,
            category_id ORDER BY book_name) as num,
		book_name,
        author_id,
        publisher_id,
        category_id,
        cover_img_url
	FROM
		book_list_tb bl
			LEFT OUTER JOIN author_tb a ON(a.author_name = bl.author_name)
			LEFT OUTER JOIN publisher_tb ps ON(ps.publisher_name = bl.publisher_name)
			LEFT OUTER JOIN category_tb cg ON(cg.category_name = bl.category_name)
	) book_list
where
	num = 1