import sbt.{ProjectInfo, DefaultProject, ParentProject}

/**
 * Created by IntelliJ IDEA.
 * User: sumitraja
 * Date: Jun 10, 2010
 * Time: 9:44:17 PM
 */


class JNAProject(info: ProjectInfo) extends DefaultProject(info) {

	val javaOutputDir = "src/main/java"
	val scalaOutputDir = "src/main/scala"
	val headerDir = "src/main/headers"
	val args = List("-noComp", "-o", javaOutputDir, "-scalaOut", scalaOutputDir, headerDir)
	com.ochafik.lang.jnaerator.JNAerator.main(args.toArray);
}