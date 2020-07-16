CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL ,
    minutes INT NOT NULL ,
    genre VARCHAR(50) NOT NULL,
    director VARCHAR(50) NOT NULL
);

insert into movies (name, minutes, genre, director) values
                ('peli1',152, 'ACTION','director1'),
                ('peli2',113, 'THRILLER','director2'),
                ('peli3',136, 'ACTION','director3');