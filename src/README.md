# Cab Hailing System

### Running from IntelliJ
1. Create a SpringBoot Run/Debug application configuration
2. Provide the following VM Options: -Dapplication.home=. -Dproject.name=cabhailingsystem -Dspring.profiles.active=dev -Dapplication.environment=dev
3. Run or debug the application configuration

# API
Book a Cab
# url : localhost:8080/bookCab
# method type- POST
# Request Body (example): 
{
	"rider": {
		"location":5,
		"riderId":"123",
		"riderName":"abc"
	},
	"destination":"Phenix Mall",
	"numOfPassengers":4
}

# Response:
{
    "status": "SUCCESS",
    "trip": {
        "driver": {
            "driverId": "1234",
            "name": "Sam",
            "currLocation": 6,
            "cab": {
                "cabNumber": "TN-1234",
                "cabType": "SADAN",
                "cabStatus": "EMPTY"
            },
            "available": true
        },
        "rider": {
            "riderId": "123",
            "riderName": "abc",
            "location": 5,
            "numberOfPassengers": 0
        },
        "source": "5",
        "destination": "Phenix Mall",
        "tripDuration": "30 mins",
        "tripStartTime": "2020-09-07T18:28:14.52",
        "tripEndTime": null,
        "tripStatus": "NOTSTARTED"
    },
    "error": null
}

