SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE store;

INSERT INTO store(`id`, `store_name`, `store_number`, `store_number`, `country`, `state`, `city`, `address`)
VALUES (2, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312", "yABA"),
       (3, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312", "yABA"),
       (4, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312", "yABA"),
       (5, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312", "yABA"),
       (6, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312", "yABA"),
       (7, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312", "yABA") ,
       (8, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312", "yABA") ,
       (9, "Pat", 15, "Nigeria", "Lagos", "Yaba", "312", "yABA");

SET FOREIGN_KEY_CHECKS =1;