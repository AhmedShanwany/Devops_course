echo "starting The Test"
#mvn clean test
mvn clean package dependency:copy-dependencies -DoutputDirectory=target/lib
mvn clean test -DsuiteXmlFile=testng.xml
#sleep 100