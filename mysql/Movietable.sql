CREATE TABLE movie (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    overview TEXT,
    actor VARCHAR(255),
    img VARCHAR(255)
);

CREATE TABLE genre (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE movie_genre (
    movie_id INT,
    genre_id INT,
    PRIMARY KEY (movie_id, genre_id),
    FOREIGN KEY (movie_id) REFERENCES movie(id),
    FOREIGN KEY (genre_id) REFERENCES genre(id)
);
