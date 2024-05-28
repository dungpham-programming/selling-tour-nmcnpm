-- Tạo cơ sở dữ liệu
CREATE DATABASE `nmcnpm`;
USE `nmcnpm`;

-- Tạo bảng customer
CREATE TABLE `customer`
(
    `id`            int NOT NULL AUTO_INCREMENT,
    `customerBadge` varchar(255),
    `loyaltyPoint`  int,
    `email`         varchar(255),
    PRIMARY KEY (`id`)
);

-- Tạo bảng transaction
CREATE TABLE `transaction`
(
    `id`                varchar(50) NOT NULL,
    `amount`            double NOT NULL,
    `paymentMethod`     varchar(255) NOT NULL,
    `currency`          varchar(50) NOT NULL,
    `transactionStatus` varchar(50) NOT NULL,
    `transactionTime`   varchar(255) NOT NULL,
    `transferorName`    varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Tạo bảng order_tours
CREATE TABLE `order_tours`
(
    `id`                   int NOT NULL AUTO_INCREMENT,
    `customerId`           int NOT NULL,
    `total`                double NOT NULL,
    `note`                 varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `slotQuantity`         int NOT NULL,
    `paymentTransactionId` varchar(50),
    PRIMARY KEY (`id`) USING BTREE,
    FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`paymentTransactionId`) REFERENCES `transaction` (`id`) ON DELETE SET NULL
);

-- Thêm dữ liệu vào bảng customer
INSERT INTO `customer` (`customerBadge`, `loyaltyPoint`, `email`)
VALUES
    ('Gold', 1200, 'customer1@example.com'),
    ('Silver', 800, 'customer2@example.com'),
    ('Bronze', 300, 'customer3@example.com');

-- Thêm dữ liệu vào bảng transaction
INSERT INTO `transaction` (`id`, `amount`, `paymentMethod`, `currency`, `transactionStatus`, `transactionTime`, `transferorName`)
VALUES
    ('TXN001', 150.00, 'Credit Card', 'USD', 'Completed', '2024-05-20 12:30:00', 'John Doe'),
    ('TXN002', 200.00, 'PayPal', 'USD', 'Pending', '2024-05-21 15:45:00', 'Jane Smith'),
    ('TXN003', 75.00, 'Bank Transfer', 'USD', 'Completed', '2024-05-22 10:00:00', 'Emily Johnson');

-- Thêm dữ liệu vào bảng order_tours
INSERT INTO `order_tours` (`customerId`, `total`, `note`, `slotQuantity`, `paymentTransactionId`)
VALUES
    (1, 500.00, 'Tour to Hawaii', 2, 'TXN001'),
    (2, 300.00, 'Tour to Bali', 1, 'TXN002'),
    (3, 150.00, 'Tour to Vietnam', 3, 'TXN003');
