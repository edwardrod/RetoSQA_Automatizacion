Feature: User selects a date on the Date picker.

  Scenario: Select date 15 this month
    Given the user opens the JQuery Datepicker home page
    When the user clicks on the date selection field
    And select day of the current month
    Then the selected date should appear in the text field

  Scenario: Select date 15 next month
    Given the user opens the JQuery Datepicker home page
    When the user clicks on the date selection field
    And navigate to next month
    And select day of the next month
    Then the selected date should appear in the text field

  Scenario: Ingresar fecha de manera manual
    Given the user opens the JQuery Datepicker home page
    When the user clicks on the date selection field
    And The user attempts to manually enter a date into the text field
    And the field must not allow manual editing
    And It should only be possible to select one date from the calendar
    Then the selected date should appear in the text field