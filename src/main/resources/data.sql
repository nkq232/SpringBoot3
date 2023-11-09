LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ADMIN'),(2,'MANAGER'),(3,'EMPLOYEE');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$eRrhgxbCTOoBIlwf5ZtZv.Y2QSSTiukB7HUHc7YYsnOUYpyQ7sTgW','Quan','Nguyen','22',1,1),(2,'employee1','$2a$10$eRrhgxbCTOoBIlwf5ZtZv.Y2QSSTiukB7HUHc7YYsnOUYpyQ7sTgW','Dat','Nguyen','2312',0,3),(4,'employee2','$2a$10$eRrhgxbCTOoBIlwf5ZtZv.Y2QSSTiukB7HUHc7YYsnOUYpyQ7sTgW','Huyen','Pham','ndwjqnd',1,3),(5,'employee5','$2a$10$sBXAVdhmOIyXt4gW2LnHMOoglAbAjiK9hiTzq0nN7F4E/cZMb2GwS','Quan','Nguyen','22',1,3),(3,'manager','$2a$10$eRrhgxbCTOoBIlwf5ZtZv.Y2QSSTiukB7HUHc7YYsnOUYpyQ7sTgW','Hung','Nguyen','ndkjwndq',1,2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;