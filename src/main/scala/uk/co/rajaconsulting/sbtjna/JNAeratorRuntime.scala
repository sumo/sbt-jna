package uk.co.rajaconsulting.sbtjna

object JNAeratorRuntime extends Enumeration {
  type JNAeratorRuntime = Value
  val JNA, JNAerator, BridJ = Value
  
  def runtimeName(value: Value) = {
	  value match {
	  case JNA => "JNA"
	  case JNAerator =>  "JNAerator"
	  case BridJ => "BridJ"
	  }
  }
}