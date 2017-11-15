--
-- Структура таблицы `book_author`
--

CREATE TABLE `book_author` (
  `book_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`author_id`)
);

--
-- Структура таблицы `author`
--

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  PRIMARY KEY (`author_id`),
  CONSTRAINT `book_author_ibfk_2` FOREIGN KEY (`author_id`)
  REFERENCES `book_author` (`author_id`) ON DELETE CASCADE
);

--
-- Структура таблицы `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `availability` varchar(100) NOT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `isbn` (`isbn`),
  CONSTRAINT `book_author_ibfk_1` FOREIGN KEY (`book_id`)
  REFERENCES `book_author` (`book_id`) ON DELETE CASCADE,

);

--
-- Структура таблицы `book_instance`
--

CREATE TABLE `book_instance` (
  `book_instance_id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_number` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `book_id` int(11) NOT NULL,
  PRIMARY KEY (`book_instance_id`),
  UNIQUE KEY `inventory_number` (`inventory_number`),
  CONSTRAINT `book_instance_ibfk_1` FOREIGN KEY (`book_id`)
  REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `password` (`password`)
);

--
-- Структура таблицы `librarian`
--

CREATE TABLE `librarian` (
  `librarian_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `patronymic` varchar(100) NOT NULL,
  PRIMARY KEY (`librarian_id`),
  CONSTRAINT `librarian_ibfk_1` FOREIGN KEY (`librarian_id`)
  REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

--
-- Структура таблицы `reader`
--

CREATE TABLE `reader` (
  `reader_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `patronymic` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `reader_card_number` varchar(100) NOT NULL,
  PRIMARY KEY (`reader_id`),
  UNIQUE KEY `reader_card_number` (`reader_card_number`),
  UNIQUE KEY `phone` (`phone`),
  CONSTRAINT `reader_ibfk_1` FOREIGN KEY (`reader_id`)
  REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
);


--
-- Структура таблицы `book_order`
--

CREATE TABLE `book_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` date NOT NULL,
  `fulfilment_date` date DEFAULT NULL,
  `pickup_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `actual_return_date` date DEFAULT NULL,
  `book_instance_id` int(11) NOT NULL,
  `reader_id` int(11) NOT NULL,
  `librarian_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  CONSTRAINT `book_order_ibfk_1` FOREIGN KEY (`book_instance_id`)
  REFERENCES `book_instance` (`book_instance_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_order_ibfk_2` FOREIGN KEY (`reader_id`)
  REFERENCES `reader` (`reader_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_order_ibfk_3` FOREIGN KEY (`librarian_id`)
  REFERENCES `librarian` (`librarian_id`) ON DELETE CASCADE ON UPDATE CASCADE
);



