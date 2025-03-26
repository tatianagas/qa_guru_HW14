<img src="/images/logotype.jpg" width="200" height="50">

# В чем польза покрытия тестами [сайта Гусевского хрустального завода](https://www.goose-crystal.ru/)

Сайт — важный инструмент для представления продукции и взаимодействия с клиентами. Для обеспечения его надежности и
качества необходимо внедрение тестирования.
Вот несколько причин, почему покрытие тестами критически важно:

1. **Повышение качества**: Тестирование помогает выявить ошибки и недочеты на ранних стадиях разработки, что
   способствует созданию более качественного продукта.

2. **Улучшение пользовательского опыта**: Регулярное тестирование функциональности сайта гарантирует, что пользователи
   смогут без проблем находить информацию и совершать покупки.

3. **Снижение затрат на поддержку**: Выявление и исправление ошибок на этапе тестирования обходится значительно дешевле,
   чем исправление проблем после запуска сайта.

4. **Поддержка изменений**: Сайт будет регулярно обновляться и улучшаться. Наличие тестов позволяет уверенно вносить
   изменения, не опасаясь сломать существующую функциональность.

5. **Доверие клиентов**: Надежный и стабильный сайт формирует доверие у клиентов, что в свою очередь способствует
   увеличению продаж и укреплению репутации завода.

Внедрение тестирования на сайте Гусевского хрустального завода — это инвестиция в его будущее и успешное развитие.

### Стек технологий

<p align="center">
    <a href="https://www.jetbrains.com/idea" title="IntelliJ IDEA">
        <img width="6%" src="icons/Intelij_IDEA.svg">
    </a>
    <a href="https://www.java.com" title="Java">
        <img width="6%" src="icons/Java.svg">
    </a>
    <a href="https://selenide.org" title="Selenide">
        <img width="6%" src="icons/Selenide.svg">
    </a>
    <a href="https://aerokube.com/selenoid" title="Selenoid">
        <img width="6%" src="icons/Selenoid.svg">
    </a>
    <a href="https://docs.qameta.io/allure" title="Allure Report">
        <img width="6%" src="icons/Allure_Report.svg">
    </a>
    <a href="https://qameta.io/" title="Allure TestOps">
        <img width="5%" src="icons/AllureTestOps.svg">
    </a>
    <a href="https://gradle.org" title="Gradle">
        <img width="6%" src="icons/Gradle.svg">
    </a>
    <a href="https://junit.org/junit5" title="JUnit5">
        <img width="6%" src="icons/Junit5.svg">
    </a>
    <a href="https://github.com" title="GitHub">
        <img width="6%" src="icons/GitHub.svg">
    </a>
    <a href="https://www.jenkins.io" title="Jenkins">
        <img width="6%" src="icons/Jenkins.svg">
    </a>
    <a href="https://telegram.org" title="Telegram">
        <img width="6%" src="icons/Telegram.svg">
    </a>
</p>

Вот несколько примеров простых тестов для сайта завода:

- [x] Наличие ссылки на логотип завода на главной странице
- [x] Находим рыбницу с помощью фильтрации в каталоге
- [x] Увеличение количества товаров в корзине
- [x] Отображение количества товаров в корзине на странице каталога
- [x] На странице конкретной экскурсии есть инф.блоки 2 других экскурсий
- [x] Проверяем корректность адреса магазина в Суздале
- [x] Наличие алерта при безуспешной авторизации


Запуск тестов из командной строки:

```
gradle clean goose_test
```

Отчетность о прогоне тестов в Telegram позволит оперативно отслеживать потенциальные и уже существующие проблемы на
сайте

### Пример такого отчета в Telegram:

<img src="/images/report.jpg" width="300" height="270">

### Пример [Allure-отчета](https://jenkins.autotests.cloud/job/Goose_crystal_factory_tests/28/allure/):

<img src="/images/allure_report.jpg" width="600">

### Прогон автотестов в [Jenkins](https://jenkins.autotests.cloud/job/Goose_crystal_factory_tests/):

<img src="/images/jenkins.jpg" width="600">

### Видео прогона одного из автотестов

![animation.gif](animation/animation.gif))


