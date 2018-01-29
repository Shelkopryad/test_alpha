Feature: alfa_tests

  @3
  Scenario: yandex search mobile test
    When user goes to page "https://www.google.ru/"
    When search "Альфа банк"

    When user click on link "Электроника"
    When user click on link "Телефоны"
    When user click on link "Смартфоны"
    When set checkbox filter "Samsung"
    When set checkbox filter "смартфон"
    When set min amount "40000"
    When opens first product and remembers the name
    Then check product title