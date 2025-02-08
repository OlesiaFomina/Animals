USE `Друзья человека`;

-- Общая таблица для всех животных
CREATE TABLE IF NOT EXISTS `animals` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `age` INT UNSIGNED,
    `breed` VARCHAR(255),
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Таблица для домашних животных
CREATE TABLE IF NOT EXISTS `domestic_animals` (
    `animal_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`animal_id`),
    FOREIGN KEY (`animal_id`) REFERENCES `animals`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Таблица для вьючных животных
CREATE TABLE IF NOT EXISTS `pack_animals` (
    `animal_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`animal_id`),
    FOREIGN KEY (`animal_id`) REFERENCES `animals`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Таблица для собак
CREATE TABLE IF NOT EXISTS `dogs` (
    `animal_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`animal_id`),
    FOREIGN KEY (`animal_id`) REFERENCES `domestic_animals`(`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Таблица для кошек
CREATE TABLE IF NOT EXISTS `cats` (
    `animal_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`animal_id`),
    FOREIGN KEY (`animal_id`) REFERENCES `domestic_animals`(`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Таблица для хомяков
CREATE TABLE IF NOT EXISTS `hamsters` (
    `animal_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`animal_id`),
    FOREIGN KEY (`animal_id`) REFERENCES `domestic_animals`(`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Таблица для лошадей
CREATE TABLE IF NOT EXISTS `horses` (
    `animal_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`animal_id`),
    FOREIGN KEY (`animal_id`) REFERENCES `pack_animals`(`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Таблица для верблюдов
CREATE TABLE IF NOT EXISTS `camels` (
    `animal_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`animal_id`),
    FOREIGN KEY (`animal_id`) REFERENCES `pack_animals`(`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Таблица для ослов
CREATE TABLE IF NOT EXISTS `donkeys` (
    `animal_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`animal_id`),
    FOREIGN KEY (`animal_id`) REFERENCES `pack_animals`(`animal_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
