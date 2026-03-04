docker run --name mysql-minilog \
  -e MYSQL_ROOT_PASSWORD=dev_password \
  -e MYSQL_DATABASE=minilog_db \
  -e MYSQL_USER=minilog_user \
  -e MYSQL_PASSWORD=dev_password \
  -p 3307:3306 \
  -v mysql-minilog-data:/var/lib/mysql \
  -d mysql:8.0
