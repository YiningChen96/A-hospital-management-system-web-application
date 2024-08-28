This hospital management system is made using the spring boot java framework. To use it directly locally, you need to enter the code in the mysql command line:
  CREATE DATABASE hospital;
  CREATE USER springuser@'localhost' IDENTIFIED BY 'ThePassword';
  GRANT ALL ON hospital.* TO springuser@'localhost';

If you need to package this program, enter on the command line: 
  mvn clean package
  
For this jar package, you can double-click to run it, kill the process directly in the background when closing, or enter in the command line:
  java -jar demo-0.0.1-SNAPSHOT
