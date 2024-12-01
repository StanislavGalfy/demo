@SET MYSQL_PWD=root
@MYSQL -uroot -e "DROP DATABASE demo; DROP USER demo;"
@MYSQL -uroot -e "CREATE USER demo IDENTIFIED BY 'demo';"
@MYSQL -uroot -e "CREATE DATABASE demo;"
@CALL liquibase --changeLogFile=changelog.xml --url=jdbc:mariadb://localhost/demo --username=root --password=root update
@MYSQL -uroot demo -e "GRANT INSERT, SELECT, UPDATE, DELETE ON demo TO demo;"
@MYSQL -uroot demo -e "FLUSH PRIVILEGES;"