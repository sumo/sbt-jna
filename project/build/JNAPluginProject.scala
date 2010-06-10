import sbt._
class JNAPluginProject(info: ProjectInfo) extends PluginProject(info) with IdeaPlugin {
  lazy val publishTo = Resolver.file("GitHub", new java.io.File("../sumo.github.com/maven/"))

  val jnaeratorRepo = "JNAerator Maven Repository" at "http://jnaerator.sourceforge.net/maven"
  val nativeLibsRepo = "NativeLibs4Java" at "http://nativelibs4java.sourceforge.net/maven"
  val javaDotNetRepo = "Java.net Repository for Maven" at "http://download.java.net/maven/2"

  val jnaerator = "com.jnaerator" % "jnaerator" % "0.9.3"
}