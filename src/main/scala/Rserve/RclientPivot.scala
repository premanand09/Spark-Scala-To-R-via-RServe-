package Rserve

import com.sun.prism.PixelFormat.DataType
import org.apache.avro.generic.GenericData.StringType
import org.apache.spark.sql.types.{StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}
import org.rosuda.REngine.REXP
import org.rosuda.REngine.Rserve.RConnection

import scala.collection.mutable.ListBuffer
import scala.reflect.internal.util.TableDef.Column


object RclientPivot {

  def main(args: Array[String]): Unit = {
    val Rcon = new RConnection()

//    val filename = "C:\\Hp data\\ieta\\IetaRCode\\rstudio-export\\test.csv"
    if (Rcon.isConnected) {
      println("Connected to RServe.")

    }

    val spark = SparkSession.builder().appName("").master("local").getOrCreate()

    Rcon.eval("source('C:/Hp data/ieta/IetaRCode/rstudio-export/poc.r', encoding = 'UTF-8')")

    val op = Rcon.eval("d1").asList()

    val ncol = Rcon.eval("ncol(d1)").asInteger()

    val rownames = Rcon.eval("rownames(d1)")

    var j=0

    val rowname_array = rownames.asStrings()

    val colstring = rowname_array.mkString(",")




   // println("hi")
    var dataList=new ListBuffer[List[String]]
    var s = Array[String]()


    var i=0


    var ship = new Array[REXP](ncol)

    while(i<ncol){

      ship{i} = op.at(i)
      i=i+1


    }


    for(k<-ship){

     // println("rr")

      s = k.asStrings()

      dataList+=s.toList


    }



    import spark.implicits._
    import org.apache.spark.sql.types.{IntegerType, StringType}
    import org.apache.spark.sql.types.{StructType,StructField,StringType}

   // val l = List(List("prem","prem"),List("raone","ratwo"))
    val rdd = spark.sparkContext.parallelize(dataList)
    /*val schemaUntyped = new StructType()
      .add("abc", StringType)
      .add("def", StringType)
*/
    val schemaUntyped = StructType(colstring.split(",").map(fieldName => StructField(fieldName, StringType, true)) )

//    val l1 = StructType(Array(StructField("", StringType, true)))



    val rowrdd = rdd.map(v =>


    Row(v: _*)

    )

    val df = spark.sqlContext.createDataFrame(rowrdd,schemaUntyped)
    df.show(10)



  }

}