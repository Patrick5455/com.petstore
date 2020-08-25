SET FOREIGN_KEY_CHECKS = 0; #this encures sql does not check for foreign keys

TRUNCATE TABLE pet_animal;

INSERT INTO pet_animal(`id`, `breed`, `name`, `types`, `sex`, `age`)

VALUES(200,'bobby', 'german_sheperd', 'DOG', 'MALE', 15),
      (300,'bobby', 'german_sheperd', 'DOG', 'MALE', 15),
      (400,'bobby', 'german_sheperd', 'DOG', 'MALE', 15),
      (500,'bobby', 'german_sheperd', 'DOG', 'MALE', 15),
      (600,'bobby', 'german_sheperd', 'DOG', 'MALE', 15),
      (700,'bobby', 'german_sheperd', 'DOG', 'MALE', 15),
      (800,'bobby', 'german_sheperd', 'DOG', 'MALE', 15),
      (900,'bobby', 'german_sheperd', 'DOG', 'MALE', 15);

SET FOREIGN_KEY_CHECKS = 1;


