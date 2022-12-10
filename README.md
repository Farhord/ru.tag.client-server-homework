# Инструкция для запуска проекта
Для запуска проекта потребуется: IntelliJ IDEA, PostgreSQL (я пользовался 14 версией)

1. В postgesql необходимо создать новую базу данных с двумя таблицами:

Имя первой таблицы: tokens

Колонки:
* Имя: id, Тип: character varing, Длина: 100, не нулабельное, первичный ключ
* Имя: login, Тип: character varing, Длина: 25, не нулабельное
* Имя: token, Тип: character varing, Длина: 100, не нулабельное

Имя второй таблицы: users

Колонки:
* Имя: login, Тип: character varing, Длина: 25, не нулабельное, первичный ключ
* Имя: password, Тип: character varing, Длина: 25, не нулабельное
* Имя: username, Тип: character varing, Длина: 30, не нулабельное
* Имя: email, Тип: character varing, Длина: 25, нулабельное

2. Склонировать проект в IntelliJ IDEA

3. В файле Application.kt в методе Database.connect() необходимо указать:
* ulr (пример: "jdbc:postgresql://localhost:5432/client-server-homework", где localhost - IP адресс на котором расположен сервер postgress, 5432 - порт, client-server-homework - название базы данных)
* driver = "org.postgresql.Driver"
* user - имя пользователя указанное при создании БД
* password - пароль указанный при создании БД

4. Проект готов к запуску
