package uk.co.rajaconsulting.sbtjna
import com.ochafik.lang.jnaerator._
import java.io._

class JNAerator(javaOutputDir: String, defaultHeaderRootDir: String, scalaOutputDir: String, rootPackage: String, scalaOut: Boolean, verbose: Boolean, includePaths: List[String],
  frameworkPaths: List[String], libraries: Map[String, (String, List[String])], reification: Boolean, scalaStructSetters: Boolean, nocpp: Boolean,
  noJar: Boolean, noComp: Boolean, runtime: JNAeratorRuntime.Value) {

  var args = List("-o", javaOutputDir)
  if (scalaOut) {
    args = args ::: List("-scalaOut", scalaOutputDir)
  }
  if (verbose) {
    args = "-v" :: args
  }

  if (defaultHeaderRootDir != "") {
    args = args ::: List("-I", defaultHeaderRootDir)
  }
  
  args = args ::: includePaths.flatMap(x => List("-I", new File(x).getAbsolutePath))
  args = args ::: frameworkPaths.flatMap(x => List("-F", new File(x).getAbsolutePath))
  libraries.foreach((element) => {
    val (relativeDir, headers) = element._2
    val hfs = headers.map { header =>
      new File(defaultHeaderRootDir + "/" + relativeDir + "/" + header).getAbsolutePath
    }
    args = args ::: List("-library", element._1)
    args = args ::: hfs
  })
  if (reification) {
    args = "-reification" :: args
  }
  if (scalaStructSetters) {
    args = "-scalaStructSetters" :: args
  }
  if (nocpp) {
    args = "-nocpp" :: args
  }
  if (noJar) {
    args = "-noJar" :: args
  }
  if (noComp) {
    args = "-noComp" :: args
  }
  if (rootPackage != null) {
    args = "-root" :: rootPackage :: args
  }
  if (runtime != JNAeratorRuntime.JNAerator) {
    args = "-runtime" :: JNAeratorRuntime.runtimeName(runtime) :: args
  }
  println("JNAerating headers with options " + args)
  JNAerator.main(args.toArray);
}

