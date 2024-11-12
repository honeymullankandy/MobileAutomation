Feature: validation place api

Scenario Outline: verify if Place is beingSucessfully added using addPlaceAPI
Given add place api with "<name>" "<adress>" and "<phon>"
When user calls "AddPlaceAPI" with "POST" HTTP request
Then API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify the place_id maps to the "<phon>" using "getPlaceAPI"
Given deletePlace Payload
When user calls "deletePlaceAPI" with "DELETE" HTTP request

Examples:
|name|adress|phon|
|hm|kalyani|981|
|hm1|kalyani1|9811|
