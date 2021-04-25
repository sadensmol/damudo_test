*Task*

1) create a new springboot based standalone application; 
it shall read a local json based config file having 4 parameters:
instance ID, mongodb URL, heartbeat interval in seconds and httpPort

2) connect to the mongodb database
{
"instanceId": "95305568-5347-444d-91c4-10d9a8ed173b",
"mongoDb": "mongodb://myDBReader:D1fficultP%40ssw0rd@mongodb0.example.com:27017/?authSource=admin",
"heartBeatInSec": 15,
"httpPort": 8888
}

3) start a thread that create or updates an entry in the database 
(collection: appserver containing one entry per application instance, identified by their instance ID); 
record should have lastHearbeat field being update on every heartbeat

4) (optional) listen in a own thread to the specified httpPort for requests 
and simply print their content to stdout

*Requirements*
Docker  
make  
java 13

*How to start*
start mongodb in docker  
make start  

./gradlew bootRun

*How to test*
It should have mongodb started (as it included ITs)

./gradlew test
