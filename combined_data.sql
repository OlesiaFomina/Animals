mysql> USE `Друзья человека`;
Database changed
mysql> CREATE TABLE молодые_животные (
    ->     id INT PRIMARY KEY AUTO_INCREMENT,
    ->     name VARCHAR(45),
    ->     breed VARCHAR(45),
    ->     birthdate DATE,
    ->     age_in_months INT
    -> );
Query OK, 0 rows affected (0,05 sec)

mysql> INSERT INTO молодые_животные (name, breed, birthdate, age_in_months)
    -> SELECT name, breed, birthdate, 
    ->        TIMESTAMPDIFF(MONTH, birthdate, CURDATE())
    -> FROM animals
    -> WHERE TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) >= 1
    -> AND TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) < 3;
Query OK, 1 row affected (0,02 sec)
Records: 1  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM молодые_животные;
+----+--------------+-----------------------------------+------------+---------------+
| id | name         | breed                             | birthdate  | age_in_months |
+----+--------------+-----------------------------------+------------+---------------+
|  1 | Плотва       | Джунгарский хомяк                 | 2022-08-20 |            29 |
+----+--------------+-----------------------------------+------------+---------------+
1 row in set (0,00 sec)

mysql> SELECT name, breed, birthdate, 
    ->        TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) AS age_in_months,
    ->        TIMESTAMPDIFF(YEAR, birthdate, CURDATE()) AS age_in_years
    -> FROM animals;
+--------------+-----------------------------------+------------+---------------+--------------+
| name         | breed                             | birthdate  | age_in_months | age_in_years |
+--------------+-----------------------------------+------------+---------------+--------------+
| Жучка        | Дворняга                          | 2021-05-03 |            45 |            3 |
| Барсик       | Бенгальский                       | 2019-12-15 |            61 |            5 |
| Плотва       | Джунгарский хомяк                 | 2022-08-20 |            29 |            2 |
| Васька       | Донской сфинкс                    | 2015-09-18 |           112 |            9 |
+--------------+-----------------------------------+------------+---------------+--------------+
4 rows in set (0,00 sec)

mysql> CREATE TABLE объединенная_таблица (
    ->     id INT PRIMARY KEY AUTO_INCREMENT,
    ->     name VARCHAR(45),
    ->     breed VARCHAR(45),
    ->     birthdate DATE,
    ->     commands VARCHAR(200),
    ->     animal_type_id INT,
    ->     pack_type_id INT,
    ->     age_in_months INT NULL,  -- Только для молодых животных
    ->     источник VARCHAR(50) -- Указывает, из какой таблицы запись
    -> );
Query OK, 0 rows affected (0,05 sec)

mysql> INSERT INTO объединенная_таблица (name, breed, birthdate, commands, animal_type_id, pack_type_id, источник)
    -> SELECT name, breed, birthdate, commands, animal_type_id, pack_type_id, 'animals'
    -> FROM animals;
Query OK, 4 rows affected (0,02 sec)
Records: 4  Duplicates: 0  Warnings: 0

mysql> INSERT INTO объединенная_таблица (name, breed, birthdate, commands, animal_type_id, pack_type_id, источник)
    -> SELECT name, breed, birthdate, commands, animal_type_id, pack_type_id, 'вьючные'
    -> FROM вьючные;
Query OK, 2 rows affected (0,02 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> INSERT INTO объединенная_таблица (name, breed, birthdate, commands, animal_type_id, pack_type_id, age_in_months, источник)
    -> SELECT name, breed, birthdate, NULL, NULL, NULL, age_in_months, 'молодые_животные'
    -> FROM молодые_животные;
Query OK, 1 row affected (0,01 sec)
Records: 1  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM объединенная_таблица WHERE источник != 'молодые_животные' AND age_in_months IS NOT NULL;
Empty set (0,01 sec)

mysql> SELECT * FROM объединенная_таблица;
+----+----------------+-----------------------------------+------------+--------------------------------------------+----------------+--------------+---------------+---------------------------------+
| id | name           | breed                             | birthdate  | commands                                   | animal_type_id | pack_type_id | age_in_months | источник                        |
+----+----------------+-----------------------------------+------------+--------------------------------------------+----------------+--------------+---------------+---------------------------------+
|  1 | Жучка          | Дворняга                          | 2021-05-03 | Сидеть, Лежать, Голос                      |              1 |            1 |          NULL | animals                         |
|  2 | Барсик         | Бенгальский                       | 2019-12-15 | Кушать, Спать, Мурчать                     |              1 |            2 |          NULL | animals                         |
|  3 | Плотва         | Джунгарский хомяк                 | 2022-08-20 | Бегать в колесе                            |              1 |            3 |          NULL | animals                         |
|  4 | Васька         | Донской сфинкс                    | 2015-09-18 | Мурчать, Царапать, Есть                    |              1 |            2 |          NULL | animals                         |
|  8 | Буцефал        | Арабский скакун                   | 2017-11-10 | Тпру, Шагом, Рысью                         |              2 |            4 |          NULL | вьючные                         |
|  9 | Тихоня         | Обыкновенный осел                 | 2014-03-01 | Иа, Стоять, Вести груз                     |              2 |            6 |          NULL | вьючные                         |
| 11 | Плотва         | Джунгарский хомяк                 | 2022-08-20 | NULL                                       |           NULL |         NULL |            29 | молодые_животные                |
+----+----------------+-----------------------------------+------------+--------------------------------------------+----------------+--------------+---------------+---------------------------------+
