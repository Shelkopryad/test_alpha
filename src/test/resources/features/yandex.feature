Feature: yandex_tests

  @1
  Scenario: yandex search mobile test
    When user goes to page "https://www.yandex.ru/"
    When user click on link "Маркет"
    When user click on link "Электроника"
    When user click on link "Телефоны"
    When user click on link "Смартфоны"
    When set checkbox filter "Samsung"
    When set checkbox filter "смартфон"
    When set min amount "40000"
    When opens first product and remembers the name
    Then check product title

  @2
  Scenario: yandex search headphones test
    When user goes to page "https://www.yandex.ru/"
    When user click on link "Маркет"
    When user click on link "Электроника"
    When user click on link "Портативная техника"
    When user click on link "Наушники и Bluetooth-гарнитуры"
    When set checkbox filter "Beats"
    When set min amount "17000"
    When set max amount "25000"
    When opens first product and remembers the name
    Then check product title