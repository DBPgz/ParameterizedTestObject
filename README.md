Using Parameterized Test Object on the fly
==========================================

## What is this?

This is a small [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this project out onto your pc
and run it with your Katalon Studio.

This project is developed with Katalon Studio version 5.4.2

The original question raised was:

>This is slightly off-topic, but is it possible to parameterize the test object without using the Object Repository?
Can I just create new test object in memory?
>https://forum.katalon.com/discussion/comment/17177#Comment_17177

## Background

This project demonstrates how to create a parameterized Test Object without using the Object Repository at all.

What is the reason why I developed this demo?

Please imagine we have a target Web page which contains a menu with 20 `<ul>` elements each of which contains 10 `<li><a href="..">label</a></li>`, and you want to verify the label texts against the data (read from inline, csv or database et). We are going to use Katalon Studio to do the test.

Katalon's tutorial documents would suggest to you to create a set of Test Objects in the Object Repository using the Spy Object.

However, creating 20 * 10 = 200 entries with the Spy Object is a miserable job. Nobody wants to do it.

Some of the Katalon enthusiasts in the forum discusses various ways of accessing HTML DOM with using Test Objects
- https://forum.katalon.com/discussion/5852/using-waitforelementpresent-without-an-object

This demo shows you how to:

1. create a Test Object instance on the fly without storing it into the Object repository
2. reuse the Test Object instance multiple times to get access to multiple DOM elements in the target
3. make the selector of the Test Object parameterized --- how to interpolate the place holder `${index}` in the selector expression with concrete values 1,2,3

## How to run the demo

1. git clone this repository out onto your pc
2. start your Katalon Studio
3. open the project 'UsingParameterizedTestObjectOnTheFly'
4. load the Test Case 'TC1'
5. run the Test Case.
6. the test case executes a series of verification on a target Web page  ![http://automationpractice.com/](https://github.com/kazurayam/UsingParameterizedTestObjectOnTheFly/blob/master/resources/WOMEN_DRESS_T-SHIRTS.png)
7. The last verification fails  intensionally.
8. please read the Log View of Katalon Studio to see what happened

## Description

All you need to know is written in the Test Case code. Please read the source at
- https://github.com/kazurayam/UsingParameterizedTestObjectOnTheFly/blob/master/Scripts/TC1/Script1529021746181.groovy

I was surprised to find how easily I could create a test case without using the Object Repository (and Spy Web) at all.

## Thanks

Thanks to http://automationpractice.com/index.php? as I used it as testbed.
