Feature: yandex_tests

  @1
  Scenario: yandex search mobile test
    When user goes to page "https://www.yandex.ru/"
    When user choose service "Маркет"
    When user choose "from categories" "Электроника"
    When user choose "from left menu" "Мобильные телефоны"
    When user set checkbox filter "Samsung"
    When user set checkbox filter "смартфон"
    When user set min amount "40000"
    When opens first product and remembers the name
    Then check product title

  @2
  Scenario: yandex search headphones test
    When user goes to page "https://www.yandex.ru/"
    When user choose service "Маркет"
    When user choose "from categories" "Электроника"
    When user choose "from left menu" "Наушники и Bluetooth-гарнитуры"
    When user set checkbox filter "Beats"
    When user set min amount "17000"
    When user set max amount "25000"
    When opens first product and remembers the name
    Then check product title