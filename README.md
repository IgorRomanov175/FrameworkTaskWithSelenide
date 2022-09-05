command to run:

mvn -Denvironment=GoogleCalculatorTestData -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src/test/java/com/epam/framework/XMLSuites/GoogleE2ETest.xml -Dtest=Hardcore test

environment (choose properties file):
  GoogleCalculatorTestData
  
browser (choose browser):
  chrome
  firefox
  edge
  
surefire.suiteXmlFiles (choose XML Suite):
  src/test/java/com/epam/framework/XMLSuites/GoogleE2ETest.xml
  
test (choose test case):
  Hardcore
  HurtMePlenty
