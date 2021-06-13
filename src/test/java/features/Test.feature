Feature: For handling multiple windows

Scenario: Switching tabs using handles

Given User navigated to "http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html"
When User gets the count of open tab
And User clicks on "link2"
And User clicks on "link3"
And User gets the count of open tab
And User switch to tab "2"
And Wait for "3" Seconds
And User switch to tab "1"
Then Test is successfully