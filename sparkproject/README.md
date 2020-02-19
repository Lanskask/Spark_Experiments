# Data Validation Project

- count of rows in Hive and BQ
- except data from Hive and BQ
```scala
dataFrame1.except(dataFrame2)
```

## TODO
Cleane code in this proj
add conf.file to resources folder
get hive table name and get data, build dataframe from hive table
get bq name and get dataframe from bq table
write dataFrame1.except(dataFrame2) to file on google storage in gog buckets
build jar for spark-submit
