import sbt._
import de.element34.sbteclipsify._
class JNAPluginProject(info: ProjectInfo) extends PluginProject(info) with Eclipsify {

  val jnaeratorRepo = "JNAerator Maven Repository" at "http://jnaerator.sourceforge.net/maven"
  val nl4jRepo = "NativeLibs4Java" at "http://nativelibs4java.sourceforge.net/maven"
  val javaNetRepo = "Java.net Repository for Maven" at "http://download.java.net/maven/2"
  
  override def compileOrder = CompileOrder.JavaThenScala
  
  val jnaerator = "com.jnaerator" % "jnaerator" % "0.9.7"
  val junit = "junit" % "junit" % "4.8.1" % "test"
  val scalatest = "org.scalatest" % "scalatest" % "1.1" % "test"
  
  val publishTo = Resolver.file("sumo.github.com", new java.io.File("../sumo.github.com/maven-repo/"))
}