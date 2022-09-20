# Computer Hardware Store
## Test task for Shift Lab 

## ТЗ
Магазин, торгующий компьютерами и комплектующими со следующим типом товаров:
* Мониторы
* Жесткие диски
Каждый товар имеет следующие свойства:
* номер серии
* производитель
* цена
* количество единиц продукции на складе

Дополнительные свойства товаров:
* Настольные компьютеры имеют форм-фактор: десктопы, неттопы, моноблоки
* Ноутбуки подразделяются по размеру: 13, 14, 15, 17 дюймовые
* Мониторы имеют диагональ
* Жесткие диски имеют объем

Необходимо реализовать back-end приложение, которое имеет RESTful HTTP методы выполняющие:
1) Добавление товара
2) Редактирование товара
3) Удаление товара
4) Просмотр всех существующих товаров по типу
5) Просмотр товара по идентификатору


   Требования к реализации
1) Реализация должна быть выполнена на языке Java или Kotlin
2) В качестве базы данных использовать in memory database, например H2

## Описание проекта

Тестовое задание для Shift Lab представляющее собой RESTful сервис для магазина, торгующим компьютерами и комплектующими

##### Какие технологии использовал

* Сервис написан на **Java** с помощью фреймворка **Spring Boot 2**
* Для создания удобной документации был выбран фреймворк **Swagger (OpenApi 3.0)**
* Для логирования был выбран фреймворк **Log4j2**
* Для написания тестов использовался **Junit 5** и **Mockito**
* В качестве базы данных использовалась **in memory database H2**
* Для преобразования данных из реляционного вида в объектный и обратно использовался **Hibernate**
* Системой сборки был выбран Maven

##### Что можно делать

Через RESTful HTTP методы сервиса возможны следующие действия:

1) Добавление товара
2) Редактирование товара
3) Удаление товара
4) Просмотр всех существующих товаров по типу
5) Просмотр товара по идентификатору

**Описание работы сервиса c endpoint-ами и request-ами/response-aми приведено в swagger документации,
которую можно просмотреть при запущенном сервисе по url** `http://localhost:8100/swagger-ui/index.html`

##### Что использовал в реализации сервиса

* Для реализации сервиса был выбран **controller-service-repository pattern** типичный для RESTful сервисов


* Были созданы следующие **Entity** со стратегией **joined** для хранения информации о товарах:
   - **GoodEntity** для общих свойств товаров
   - **PC** для особых свойств компьютеров
   - **Laptop** для особых свойств ноутбуков
   - **HardDisk** для особыз свойств жестких дисков
   - **Monitor** для особых свойств мониторов

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="/entities_uml.png">
  <source media="(prefers-color-scheme: light)" srcset="/entities_uml.png">
</picture>

* Для создания репозиториев использовал **Spring Data JPA репозитории**
* Имеются следующие репозитории, реализующие интерфейс JpaRepository:
   - **GoodRepository** для работы со всеми товарами
   - **PCRepository** для работы с компьютерами
   - **HardDiskRepository** для работы с жесткими дисками
   - **MonitorRepository** для работы с мониторами
   - **LaptopRepository** для работы с ноутбуками


* Бизнес логика реализована в следующих cервисах:
   - **AddService** для добавления товаров
   - **DeleteService** для удаления товаров
   - **SearchService** для поиска добавленных товаров
   - **UpdateService** для обновления добавленных товаров


* Для доступа к сервису были созданы следующие контроллеры:
   - **AddController** для доступа к сервису добавления товаров
   - **DeleteController** для доступа к сервису удаления товаров
   - **SearchController** для доступа к сервису поиска товаров
   - **UpdateController** для доступа к сервису обновления товаров

## Как установить и запустить проект(windows)

1) Клонировать этот репозиторий 
2) Зайти в папку проекта, где лежит **pom.xml**
3) Из консоли исполнить команду **mvn package**, после этого создатся папка **/target**, где будет лежать файл **computer-hardware-store-0.0.1-SNAPSHOT.jar**
4) Запустить образ можно командой **java -jar target/computer-hardware-store-0.0.1-SNAPSHOT.jar**
5) Проект запущен, иначе смотри логи

Проверить работоспособность можно с помощью программы **Postman** или из командной строки используя утилиту **curl**, также можно использовать **swagger** по url выше для запросов


Также можно получить доступ к базе данных h2 по url **http://localhost:8100/h2**
Для этого:
 - в поле **JDBC URL** введите **jdbc:h2:mem:storeDb**
 - в поле **User Name:** введите **sa**
 - пароля нет