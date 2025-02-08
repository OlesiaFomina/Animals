USE `Друзья человека`;

DELETE FROM animals WHERE breed = 'Нубийский верблюд';

CREATE TABLE вьючные AS
SELECT * FROM animals WHERE breed = 'Арабский скакун' OR breed = 'Обыкновенный осел';

DELETE FROM animals WHERE breed = 'Арабский скакун' OR breed = 'Обыкновенный осел';
