Feature: alfa_tests

  @3
  Scenario: alfa search test
    When user goes to page "https://www.google.ru/"
    When user search "Альфа банк"
    When user choose from results where URL "https://alfabank.ru/"
    When user choose from footer links "Работайте у нас"
