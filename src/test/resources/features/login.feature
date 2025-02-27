Feature: Логин

  Background: Открываем браузер и переходим на домашнюю страницу
    Given Пользователь запускает браузер
    When Пользователь открывает домашнюю страницу ilcarro

  @Login
  Scenario: Успешный логин юзера 1
    And Пользователь нажимает на ссылку Login
    And Пользователь вводит валидные данные
    And Пользователь нажимает на кнопку Yalla
    Then Пользователь проверяет отображение сообщения об успешном логине
    And Пользователь закрывает браузер

  @LoginWitString
  Scenario: Успешный логин юзера 2
    And Пользователь нажимает на ссылку Login
    And Пользователь вводит валидные данные "test_qa@gmail.com" и "Password@1"
    And Пользователь нажимает на кнопку Yalla
    Then Пользователь проверяет отображение сообщения об успешном логине
    And Пользователь закрывает браузер

  @LoginWitTable
  Scenario: Успешный логин юзера 3
    And Пользователь нажимает на ссылку Login
    And Пользователь вводит валидные данные email и password
      | email   | password   |
      | test_qa@gmail.com| Password@1|
    And Пользователь нажимает на кнопку Yalla
    Then Пользователь проверяет отображение сообщения об успешном логине
    And Пользователь закрывает браузер

  @InvalidPassword
  Scenario Outline: Неуспешный логин юзера
    And Пользователь нажимает на ссылку Login
    And Пользователь вводит валидный email и невалидный password
      | email   | password   |
      | <email> | <password> |
    And Пользователь нажимает на кнопку Yalla
    Then Пользователь проверяет отображение сообщения об неуспешном логине
    And Пользователь закрывает браузер
    Examples:
      | email             | password   |
      | test_qa@gmail.com | Password1  |
      | test_qa@gmail.com | password@1 |
      | test_qa@gmail.com | Password@  |