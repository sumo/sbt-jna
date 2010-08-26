import sbt._
import de.element34.sbteclipsify._
class JNAPluginProject(info: ProjectInfo) extends PluginProject(info) with Eclipsify {
  val jnaerator = "com.jnaerator" % "jnaerator" % "0.9.4"
  override lazy val includePlugin = propertyOptional[Boolean](true)
  override lazy val includeProject = propertyOptional[Boolean](true)
}