# Spark-Scala-To-R-via-RServe-

# Executing R commands and R script via Rserve and taking R data into Spark RDD and Dataframe


This project is written in Scala language.
We are using Apache Spark as cluster computing framework to work with big data.
We are using Rserve which is an R package that creates Server process and allows Java,Scala program API to call Rserve and execute R codes using java/scala as programming languages.

Description of this project : 

1) It uses Rserve package of R, and it is required to have Rserve process already running in our system.
2) Then use some R script or directly write R code using Scala/Java.
3) If we required to get the whole data of R dataframe into Spark RDD or dataframe, see the code that converts and pivots and different stages to get data in Spark, so that it can be used further for spark parallel transformations.


Pre-required things : 

1) Install R.
2) install Rserve package in R using command - > install.packages("Rserve")
3) load Rserve library using command  - > library(Rserve)
4) start Rserve process  - > Rserve()



Written By :
Prem
