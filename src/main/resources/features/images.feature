Feature: List images
  Background:
    Given x-api-key and baseURI already acquired.


  @images
  Scenario Outline: list image that are liked by the user
    When User lists favourite image by "<sub_id>"
    Then User should see his-her image "<image_id>"
    Examples:
      | image_id |    sub_id      |
      | naber    | my-user-1234   |
      | iyisen   | your-user-1234 |