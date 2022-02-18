# event-log-analyser

1. Please refer master branch
2. clone the project from master
3. cd to cloneed project as current working directory
4. then use **mvn package** command
to run application use **mvn spring-boot:run -Dspring-boot.run.arguments="{PathToLogFile}\logfile.txt"**

sample content of log file:
`{"id":"scsmbstgra","state":"STARTED","type":"APPLICATION_LOG","HOST":"12345","timestamp":1491377495212}
{"id": "scsmbstgrb","state": "STARTED","timestamp":1491377495213}
{"id":"scsmbstgrb","state":"FINISHED" ,"timestamp":1491377495216}
{"id":"scsmbstgra","state":"FINISHED","type":"APPLICATION_LOG","HOST":"12345","timestamp":1491377495217}
{"id":"scsmbstgrc","state":"FINISHED","type":"APPLICATION_LOG","HOST":"12345","timestamp":1491377495217}
{"id":"scsmbstgrc","state":"STARTED","type":"APPLICATION_LOG","HOST":"12345","timestamp":1491377495213}
{"id":"scsmbstgre","state":"STARTED","type":"APPLICATION_LOG","HOST":"12345","timestamp":1491377495211}
{"id":"scsmbstgre","state":"FINISHED","type":"APPLICATION_LOG","HOST":"12345","timestamp":1491377495214}`