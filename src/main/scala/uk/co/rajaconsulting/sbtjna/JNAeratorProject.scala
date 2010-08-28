package uk.co.rajaconsulting.sbtjna

import sbt._
import com.ochafik.lang.jnaerator._

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

  lazy val javaOutputDir = "target/generatedsources/java"
  lazy val scalaOutputDir = "target/generatedsources/scala"
  lazy val scalaOut = false
  lazy val headerDir = "src/main/headers"
  val library:String
  
  override def mainSourceRoots = super.mainSourceRoots +++ (Path.fromFile(javaOutputDir)) ##
  
  def includePaths:List[String] = Nil
  
  def frameworkPaths:List[String] = Nil

  // project.info.parent for subproject to parent relation
  lazy val jnaerate = task {
    var args = List("-noComp", "-o", javaOutputDir, "-library", library)
    if (scalaOut) {
      args = args ::: List("-scalaOut", scalaOutputDir)
    }
    args = args ::: List(headerDir)
    args = args ::: includePaths.flatMap(List("-I", _))
    args = args ::: frameworkPaths.flatMap(List("-F", _))
    log.info("JNAerating headers with options " + args + ".....")
    JNAerator.main(args.toArray);
    None
  } describedAs ("Generate Java And Scala Java Native Access wrappers for native code")

}