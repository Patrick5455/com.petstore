SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE pet;

TRUNCATE TABLE store;


INSERT INTO store(`id`, `store_name`, `store_number`, `country`, `state`, `city`, `address`)
VALUES (2, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312"),
       (3, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312"),
       (4, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312"),
       (5, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312"),
       (6, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312"),
       (7, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312") ,
       (8, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312") ,
       (9, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312");

SET FOREIGN_KEY_CHECKS =1;