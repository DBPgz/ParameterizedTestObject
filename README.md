Using Parameterized Test Object on the fly
==========================================

## What is this repository?

This is a small [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this project out onto your pc
and run it with your Katalon Studio.

This project is developed with Katalon Studio version 5.4.2

The original question raised was:

>This is slightly off-topic, but is it possible to parameterize the test object without using the Object Repository?
Can I just create new test object in memory?
>https://forum.katalon.com/discussion/comment/17177#Comment_17177

## Problem to solve

Let's imagine you have a target Web page which contains a menu with 20 `<ul>` elements each of which contains 10 `<li><a href="..">label</a></li>`. You want to verify the label texts against some expected data. You will use Katalon Studio to do the test.

Katalon's documents would suggest to you to create a set of Test Objects in the Object Repository using the Spy Object. However, nobody would like to  create 20 * 10 = 200 entries in the Object Repository with the Spy Object tool.

## My solution

This demo shows you how to:

1. create a Test Object instance on the fly without storing it into the Object Repository
2. reuse the Test Object instance multiple times to get access to multiple elements in the target Web page
3. make the selector of the Test Object parameterized --- how to interpolate the place holder `${index}` in the selector expression with concrete values: 1,2,3...,10

I would call this method *Parameterized Test Object on the fly*. This method works well. Provided that a tester has sound knowledge of XPath or CSS selector, this method is easy to implement.

I was inspired by the discussion by Katalon enthusiasts in the Katalon forum:
- [Katalon Forum/Using waitForElementPresent without an object]( https://forum.katalon.com/discussion/5852/using-waitforelementpresent-without-an-object)

## How to run the demo

1. git clone this repository out onto your pc
2. start your Katalon Studio
3. open the project 'UsingParameterizedTestObjectOnTheFly'
4. load the Test Case 'TC1'
5. run the Test Case.
6. the test case executes a series of verification over tabs labeled `WOMEN`, `DRESSES` and `T-SHIRTS` in the target Web page  ![http://automationpractice.com/](https://github.com/kazurayam/UsingParameterizedTestObjectOnTheFly/blob/master/resources/WOMEN_DRESS_T-SHIRTS.png)
7. The last verification fails  intensionally.
8. please read the Log View of Katalon Studio to see what happened

## Description

Have a look at the Test Case source. It would explain everything.
- [./Scripts/TC1](https://github.com/kazurayam/UsingParameterizedTestObjectOnTheFly/blob/master/Scripts/TC1/Script1529021746181.groovy)


## Thanks

I used http://automationpractice.com/index.php as testbed. Many thanks.
