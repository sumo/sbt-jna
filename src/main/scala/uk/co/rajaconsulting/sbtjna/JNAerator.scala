package uk.co.rajaconsulting.sbtjna
import com.ochafik.lang.jnaerator._
import java.io._

class JNAerator(javaOutputDir:String, headerRootDir:String, scalaOutputDir:String, scalaOut:Boolean, verbose:Boolean, includePaths: List[String], 
                frameworkPaths: List[String], libraries: List[(String, List[String])]) {
  var args = List("-noComp", "-o", javaOutputDir)
  if (scalaOut) {
    args = args ::: List("-scalaOut", scalaOutputDir)
  }
  if (verbose) {
  	args = "-v" :: args
  }

  args = args ::: includePaths.flatMap(List("-I", _))
  args = args ::: frameworkPaths.flatMap(List("-F", _))
  libraries.foreach((element)  => {
  	val hfs = element._2.map(
  		header=> new File(headerRootDir + "/" + header).getAbsolutePath);
  	args = args ::: List("-library", element._1)
  	args = args ::: hfs
  })
  println("JNAerating headers with options " + args)
  JNAerator.main(args.toArray);
}