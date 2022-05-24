package com.executioner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)				
@CucumberOptions(features="src/test/java/com/features", glue={"stepDefinitions", "com.utils"})						
public class Runner 				
{		

}