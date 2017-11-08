name := "Rserve"

version := "0.1"

scalaVersion := "2.11.8"


// https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.11
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.2.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.11
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.2.0"


// https://mvnrepository.com/artifact/com.databricks/spark-csv_2.10
libraryDependencies += "com.databricks" % "spark-csv_2.10" % "1.2.0"

// https://mvnrepository.com/artifact/org.rosuda.REngine/REngine
libraryDependencies += "org.rosuda.REngine" % "REngine" % "2.1.0"

// https://mvnrepository.com/artifact/org.rosuda.REngine/Rserve
libraryDependencies += "org.rosuda.REngine" % "Rserve" % "1.8.1"

// https://mvnrepository.com/artifact/com.databricks/spark-csv_2.10
libraryDependencies += "com.databricks" % "spark-csv_2.10" % "1.2.0"