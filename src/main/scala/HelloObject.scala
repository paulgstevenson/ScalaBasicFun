package com.pgs.scala

import scala.util.control.Breaks

/**
 * Created by Paul on 06/04/2014.
 */
object HelloObject {

  def main(args: Array[String]) {
    println("Hello, world!") // prints Hello World

    val x = 10;

    if( x < 20 ){
      println("This is if statement");
    }

    var a = 10;

    // while loop execution
    while( a < 20 ){
      println( "Value of a: " + a );
      a = a + 1;
    }

    // do loop execution
    do{
      println( "do Value of a: " + a );
      a = a + 1;
    }while( a < 30 )

    // for loop execution with a range
    for( a <- 1 to 10){
      println( "range Value of a: " + a );
    }

    var b = 0;
    // for loop execution with a range
    for( a <- 1 to 3; b <- 1 to 3){
      println( "Value of a: " + a );
      println( "Value of b: " + b );
    }

    var numList = List(1,2,3,4,5,6);

    // for loop execution with a collection
    for( a <- numList ){
      println( "List Value of a: " + a );
    }

    numList = List(1,2,3,4,5,6,7,8,9,10);

    // for loop execution with multiple filters
    for( a <- numList
         if a != 3; if a < 8 ){
      println( "Filter list Value of a: " + a );
    }

    // for loop execution with a yield
    val retVal = for{ a <- numList
                      if a != 3; if a < 8
    }yield a

    // Now print returned values using another loop.
    for( a <- retVal){
      println( "Yield Value of a: " + a );
    }

    // Break a loop using the breaks object
    val loop = new Breaks;
    loop.breakable {
      for( a <- numList){
        println( "Value of a: " + a );
        if( a == 4 ){
          loop.break;
        }
      }
    }
    println( "After the loop" );

    // Outer and inner loops
    val numList1 = List(1,2,3,4,5);
    val numList2 = List(11,12,13);

    val outer = new Breaks;
    val inner = new Breaks;

    outer.breakable {
      for( a <- numList1){
        println( "Value of a: " + a );
        inner.breakable {
          for( b <- numList2){
            println( "Value of b: " + b );
            if( b == 12 ){
              inner.break;
            }
          }
        } // inner breakable
      }
    } // outer breakable.

    println(addInt(1,3))

    printMe()

    println("muliplier(1) value = " +  multiplier(1))
    println("muliplier(2) value = " +  multiplier(2))

    println(greeting)

    // String length method
    val palindrome = "Dot saw I was Tod";
    val len = palindrome.length();
    println("String Length is : " + len);

    // Concat strings
    "I am a string".concat(" ,cool eh!")
    // or
    "String " + "another string"


    // printf lets us format our strings
    val floatVar = 12.456
    val intVar = 2000
    val stringVar = "Hello, Scala!"
    val fs = printf("The value of the float variable is " +
      "%f, while the value of the integer " +
      "variable is %d, and the string " +
      "is %s", floatVar, intVar, stringVar)
    println(fs)
  }

  // Basic string val
  val greeting: String = "Hello, world!"

  // Basic function using param i and factor var
  var factor = 3
  val multiplier = (i:Int) => i * factor

  // Simple method function
  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b
    return sum
  }

  // Unit type function equivalent to void
  def printMe( ) : Unit = {
    println("Hello, Scala!")
  }
}
