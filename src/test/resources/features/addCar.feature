Feature: Добавление автомобиля

  Background: Открываем браузер и переходим на домашнюю страницу
    Given Пользователь запускает браузер
    When Пользователь открывает домашнюю страницу ilcarro
    And Пользователь нажимает на ссылку Login
    And Пользователь вводит валидные данные
    And Пользователь нажимает на кнопку Yalla
    Then Пользователь проверяет отображение сообщения об успешном логине

  @AddCar
  Scenario: Успешное добавление автомобиля
    And Пользователь нажимает на кнопку Let the car work
    When Пользователь вводит данные автомобиля
      | location | manufacture | model | year | fuel   | seats | classCar | price | about             | photo                               |
      | Haifa    | Trabant     | P50   | 1957 | Petrol | 4     | A        | 500   | Perfect condition | C:/Users/Ivan/Downloads/Trabant.jpg |
      |          |             |       |      |        |       |          |       |                   |                                     |
    And Пользователь нажимает кнопку Submit
    Then Пользователь проверяет сообщение "Trabant P50 added successful"
    And Пользователь закрывает браузер

