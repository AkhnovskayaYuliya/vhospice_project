# План тестирования мобильного приложения "В хосписе"
## Введение
Данный документ описывает тест-план для  мобильного приложения "В Хосписе". Цель данного тест-плана — обеспечить, чтобы все функциональные компоненты приложения "В Хосписе" работали корректно и соответствовали заявленным требованиям. Это поможет гарантировать высокое качество и надежность приложения, что, в свою очередь, способствует улучшению удобства его использования всеми заинтересованными сторонами.
## Объект тестирования
Мобильное приложение "В Хосписе" и его ключевые функциональные возможности: 
* Информация о новостях: Раздел с новостями, включающий функционал для просмотра новостей и взаимодействия с ними.
* Тематические цитаты: Раздел с цитатами, которые пользователи могут просматривать для мотивации и поддержки.
* Информация о приложении: Раздел с подробной информацией о приложении, его разработчиках и условиях использования.
## Функции, которые должны быть протестированы 
### Авторизация
1. Проверка наличия всех элементов на странице. (планируется автоматизация)
2. Авторизация с валидными данными. (планируется автоматизация)
3. Тестирование поля "Логин". (планируется автоматизация)
4. Тестирование поля "Пароль". (планируется автоматизация)
### Главная страница
1. Проверка наличия всех элементов на странице.
2. Раскрытие/скрытие списка новостей. 
3. Раскрытие/скрытие отдельной новости. 
4. Переход в раздел Новости. 
### Новости
1. Проверка наличия всех элементов страницы. 
2. Раскрытие/скрытие отдельной новости. 
3. Сортировка новостей.
4. Фильтрация новостей. 
5. Переход к Панели Управления. 
### Панель управления
1. Проверка наличия всех элементов страницы.
2. Сортировка новостей.
3. Раскрытие/скрытие отдельной новости.
4. Фильтрация новостей.
5. Редактирование новости.
6. Создание новости.
### Раздел с тематическими цитатами "Главное - любить себя" 
1. Отображение элементов на странице
2. Возможность развернуть/свернуть каждую отдельную цитату.
### Навигация в приложении 
1. Доступность всех навигационных элементов.
2. Корректность переходов в соответствующие разделы при нажатии на навигационные элементы.
### О приложении
1. Проверка наличия всех элементов страницы.
2. Доступность документации.
### Выход из приложения
1. Возможность завершения сеанса пользователя.
## Сценарии, которые планируется автомазировать 
### Авторизация и аутентификация:
1. Проверка успешной авторизации с корректными данными.
2. Проверка неуспешной авторизации с некорректными данными.
### Навигация по приложению
1. Проверка корректности работы главного меню.
2. Проверка переходов между основными разделами приложения.
3. Проверка работы кнопок навигации.
### Фильтрация новостей
1. Проверка фильтрации новостей по различным параметрам (дата, категория, статус).
2. Проверка корректности отображения отфильтрованных новостей.
### Добавление и редактирование новостей
1. Проверка возможности добавления новой новости.
2. Проверка редактирования существующей новости.
3. Проверка обязательных полей при добавлении/редактировании новости.
### Выход из профиля
1. Проверка выхода из профиля.
## Техники проектирования тестов и виды тестирования
### Техники тест-дизайна
* Анализ граничных значений
* Разделение на классы эквивалентности
* Информация о приложении: Раздел с подробной информацией о приложении, его разработчиках и условиях использования.
### Виды тестирования
1. **Функциональное тестирование.**     
* Проверка заявленной функциональности.  
* Проверка всех функциональных возможностей приложения, чтобы убедиться, что они соответствуют заявленным техническим требованиям и спецификациям.
2. **Тестирование GUI.**     
* Проверка графического интерфейса пользователя (GUI) на корректность отображения и функционирования всех элементов интерфейса, а также на удобство использования.
3. **Нефункциональное тестирование.**    
* Usability тестирование
4. **Позитивное тестирование.**    
5. **Негативное тестирование.**
## Критерии прохождения тестирования  
1. Все функциональные возможности приложения работают без ошибок.
2. Пользователь успешно авторизуется, используя валидные учетные данные, и переходит на главную страницу приложения.
3. Новости отображаются корректно, все функции взаимодействия с ними (создание, просмотр, редактирование) исправно функционируют.
4. Тематические цитаты отображаются корректно, каждую отдельную цитату можно успешно развернуть для детального просмотра.
5. Раздел "Информация о приложении" содержит актуальную документацую и она доступна для просмотра. 
6. Пользовательский интерфейс интуитивно понятен, навигация удобна, и пользователи могут легко осуществлять необходимые действия.
7. Позитивное тестирование: Все основные функции приложения работают корректно и ожидаемо при использовании корректных данных и вводе.
8. Негативное тестирование: Приложение корректно обрабатывает ошибочные сценарии, ввод некорректных данных не приводит к сбоям.  
## Инструменты тестирования
* MacBook Pro M2, macOS Sonoma 14.4.1
* Android Studio Jellyfish | 2023.3.1  
Build #AI-233.14808.21.2331.11709847, built on April 12, 2024  
Runtime version: 17.0.10+0-17.0.10b1087.21-11572160 aarch64   
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.  - основная среда разработки для создания, тестирования и отладки Android-приложений. Является официальной IDE для разработки Android-приложений, что гарантирует совместимость и поддержку последних версий SDK и инструментов.
* Эмулятор: Pixel 7 API 29 - используется для тестирования приложений в виртуальной среде, имитирующей реальное устройство. Устройство используется для тестирования на актуальных спецификациях и API уровнях. API 29 (Android 10) обеспечивает совместимость с большим количеством устройств и версий Android, что важно для охвата большей аудитории.  
* Github - Платформа для управления версиями кода, совместной работы над проектом и хранения кода. Широко используется для управления проектами и 
поддерживает интеграцию с CI/CD инструментами. Обеспечивает надежное хранение и возможность отслеживания изменений в коде, что важно для командной работы и стабильности проекта.  
* Espresso и UI Automator - Эти инструменты используются для автоматизированного тестирования UI компонентов Android-приложений. Espresso: Обеспечивает быстрые и стабильные тесты, идеально подходит для тестирования UI элементов в приложениях. UI Automator: Позволяет тестировать взаимодействие приложения с системными элементами и другими приложениями, расширяя возможности тестирования.  
* Allure - Инструмент для генерации отчетов о результатах тестирования. Предоставляет детализированные и наглядные отчеты, которые помогают анализировать результаты тестов и выявлять проблемы.  
## Интервальная оценка времени на проведение тестирования и автоматизации (в часах)  

**1. Подготовительный этап**  
* Настройка окружения (установка и настройка Android Studio, эмулятора, инструментов) - 1 час.
  
**2. Разработка тестов**  
* Написание тестовых сценариев (чек-листов и тест-кейсов) - 6-8 часов
  
**3. Проведение функционального тестирования**  
* Ручное тестирование функционала - 2 часа.
  
**4. Автоматизация тестирования**  
* Автоматизация тестирования с помощью Espresso/UI Automator- 100-120 часов
  
**5. Интеграция и отчетность**  
* Интеграция тестов с CI/CD - до 2 часов  
* Настройка Allure для отчетности - до 2 часов  
* Анализ результатов тестирования и отчетность - до 2 часов
  
**6. Управление рисками и отладка**  
* Резерв на отладку и исправление ошибок в тестах - 10-15 часов
  
**Общая оценка времени:**  
* От 126 до 175 часов  
## Документация 
[Тест-кейсы](https://github.com/AkhnovskayaYuliya/VHospice/blob/main/Cases.xlsx)  
[Чек-листы](https://github.com/AkhnovskayaYuliya/VHospice/blob/main/Check-lists.xlsx)
## Риски
* Неполное покрытие тестирования.
* Задержка в тестировании из-за проблем с окружающей средой.
* Ограниченные ресурсы для тестирования.
* Недостаточное понимание требований.
* Недостаток в опыте и навыках.
