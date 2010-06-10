import sbt._
class JNAPluginProject(info: ProjectInfo) extends PluginProject(info) with IdeaPlugin {
  override def managedStyle = ManagedStyle.Maven
  lazy val publishTo = Resolver.file("GitHub Pages", new java.io.File("../sumo.github.com/maven/")) 
}