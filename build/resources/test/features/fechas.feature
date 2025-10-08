Feature: User selects a date on the Date picker.

  Scenario: Select date 15 this month
    Given the user opens the JQuery Datepicker home page
    When the user clicks on the date selection field
    And select day of the current month
    Then the selected date should appear in the text field