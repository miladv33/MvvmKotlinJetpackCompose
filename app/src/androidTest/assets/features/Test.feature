Feature: FirstBDD
  click on the button and change the value

  @FirstBDD
  Scenario Outline:
      Given I Start the applicaton
      When I click the button
      Then Text is Changed
    Examples:
      | email                   | password                    |
      | somelonmgemail@mail.com | 12345678                    |
      | test@gmail.com          | somePassWithVeryLongValue   |