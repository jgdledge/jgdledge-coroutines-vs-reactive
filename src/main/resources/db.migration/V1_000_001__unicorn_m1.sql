DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id` char(36) NOT NULL,
    `first_name`  varchar(254),
    `last_name`  varchar(254),
    `email`  varchar(254),
    `created_at`  DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3),
    `updated_at`  DATETIME(3) DEFAULT CURRENT_TIMESTAMP (3) ON UPDATE CURRENT_TIMESTAMP (3),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
