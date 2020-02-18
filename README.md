# currencyConverter

This is a Java Spring Boot project that consumes Mastercard CurrencyCalculator API

Please note that I did not write any unit tests for this project. I was trying to keep the project under a certain amount of time I was spenting on it.

Thanks


create-account will take as postman POST http method

host --> http://localhost:8080/create-account
request
{
	"firstName": "Jean-Claude",
	"lastName": "Tounkara",
	"currencyType": "USD"
}

Response
{
    "data": {
        "customer": {
            "firstName": "Jean-Claude",
            "lastName": "Tounkara",
            "uuid": "daa0dc72-602c-4697-8b8e-d5eb5811698f"
        },
        "uuid": "79406311-8015-4df1-acb9-589c2df0aa3c",
        "balance": 0.0,
        "currencyType": "EUR"
    },
    "developerText": "success"
}

Host --> http://localhost:8080/fund-account

POSTMAN POST HTTP METHOD REQUEST
{
	"customerUuid": "daa0dc72-602c-4697-8b8e-d5eb5811698f",
	"accountUuid": "79406311-8015-4df1-acb9-589c2df0aa3c",
	"amount": "1000"
}

Response
{
    "data": {
        "customer": {
            "firstName": "Jean-Claude",
            "lastName": "Tounkara",
            "uuid": "daa0dc72-602c-4697-8b8e-d5eb5811698f"
        },
        "uuid": "79406311-8015-4df1-acb9-589c2df0aa3c",
        "balance": 1000.0,
        "currencyType": "USD"
    },
    "developerText": "success"
}


Host --> http://localhost:8080/transfer-funds

Request
{
	"fromAcctUuid": "c41fd47c-2ad9-448c-ab94-1008082b57bf",
	"fromCustomerUuid": "2643e1c4-6139-4c31-afaf-3d154779d229",
	"toAcctUuid": "79406311-8015-4df1-acb9-589c2df0aa3c",
	"toCustomerUuid": "828b9320-ed3b-4f1b-a13f-f5950bdf377e",
	"amount": "100",
	"toCurrencyType": "EUR"
}

Response
{
    "fromAcct": {
        "customer": {
            "firstName": "Jean-Claude",
            "lastName": "Tounkara",
            "uuid": "f6da0333-4879-4309-a416-9117d783495f"
        },
        "uuid": "c41fd47c-2ad9-448c-ab94-1008082b57bf",
        "balance": 900.1242,
        "currencyType": "USD"
    },
    "toAcct": {
        "customer": {
            "firstName": "Kadiatou",
            "lastName": "Tounkara",
            "uuid": "daa0dc72-602c-4697-8b8e-d5eb5811698f"
        },
        "uuid": "79406311-8015-4df1-acb9-589c2df0aa3c",
        "balance": 100.0,
        "currencyType": "EUR"
    },
    "developerText": "success"
}
