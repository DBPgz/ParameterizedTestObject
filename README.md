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

This project demonstrates how to create a parameterized Test Object without using the Object Repository at all.

## How to run the demo

1. git clone this repository out onto your pc
2. start your Katalon Studio
3. open the project 'UsingParameterizedTestObjectOnTheFly'
4. load the Test Case 'TC1'
5. run the Test Case
6. the test case executes a series of verification, the last of which will intensionally fail.
7. please read the Log View of Katalon Studio to see what happened

## Description

Please read the test case code at 

The code is very short. Frankly speaking, I was surprised how easy it is to create a Test Object without using the Object Repository.
