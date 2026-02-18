Feature: Vendor Search Filter on bstackdemo.com

@uat
  Scenario Outline: Search Filter By Vendor
    Given User is on bstackdemo.com
    When User chooses "<vendorName>"
    Then Products of "<vendorName>" should show "<vendorBrand>"

    Examples:
      | vendorName | vendorBrand |
      | Apple      | iPhone      |
      | Google     | Pixel       |
      | Samsung    | Galaxy      |
      | OnePlus    | One Plus    |
