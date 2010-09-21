package uk.co.rajaconsulting.sbtjna

import sbt._
import java.io._

/**
 * <ul>
 * <li>Override javaOutputDir to change the default output directory from "target/generatedsources/java".</li>
 * <li>Override scalaOut and set to true to get scala file generation.</li>
 * <li>Override scalaOutputDir to change the default output directory from "target/generatedsources/scala".</li>
 * 
 * @author sumitraja
 *
 */
trait JNAeratorProject extends DefaultProject {

  lazy val javaOutputDir = "target/generated-sources/java"
  lazy val scalaOutputDir = "target/generated-sources/scala"
  lazy val scalaOut = false
  lazy val verbose = false
  lazy val headerRootDir = "src/main/headers"
  /** (Library name, headers offset from headerRootDir) **/
  def libraries: Map[String, List[String]]

  override def mainSourceRoots = super.mainSourceRoots +++ (Path.fromFile(javaOutputDir)) +++ (Path.fromFile(scalaOutputDir)) ##

  def includePaths: List[String] = Nil

  def frameworkPaths: List[String] = Nil

  // project.info.parent for subproject to parent relation
  lazy val jnaerate = task {
    new JNAerator(javaOutputDir, headerRootDir, scalaOutputDir, scalaOut, verbose, includePaths, frameworkPaths, libraries)
    None
  } describedAs ("Generate Java and Scala JNA wrappers for native code")

}