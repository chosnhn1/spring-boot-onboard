docker run --name mysql-todo \
  -e MYSQL_ROOT_PASSWORD=dev_password \
  -e MYSQL_DATABASE=todo_db \
  -e MYSQL_USER=todo_user \
  -e MYSQL_PASSWORD=dev_password \
  -p 3306:3306 \
  -v mysql-todo-data:/var/lib/mysql \
  -d mysql:8.0
