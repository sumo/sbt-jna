package uk.co.rajaconsulting.sbtjna

import sbt._
import org.junit.Test
import org.junit.Assert._
import org.scalatest.junit.JUnitSuite
import java.io._;

/**
 * @author sumitraja
 *
 */
class JNAeratorTest extends JUnitSuite {

  @Test 
  def testJNAerate() {
    new JNAerator("target/generated-sources/java", "src/test/headers", "target/generated-sources/scala", true, true, List("/opt/local/include"),
                  Nil, List(("simple", List("simple.h"))), true, true, true, true, true, JNAeratorRuntime.BridJ)
    checkFile("target/generated-sources/java/simple/Pair.java")
    checkFile("target/generated-sources/java/simple/BiggerStruct.java")
    checkFile("target/generated-sources/java/simple/SimpleLibrary.java")
    
    checkFile("target/generated-sources/scala/simple/Simple.scala")
  }
  
  def checkFile(path:String) = {
    val file = new File(path);
    assertTrue(file.length > 0)
  }

}