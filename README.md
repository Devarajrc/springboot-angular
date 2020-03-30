# springboot-angular
Hotel management 

In this application frontend is not clear but in postman it is working fine

Steps to Run Application

mvn clean install

mvn spring-boot:run

npm install

In Postman 
http://localhost:8090/item/register  (post request)
 {
        "id": 2,
        "itemName": "IDLI",
        "price": 25
    }

http://localhost:8090/item/serve/1   (Get request)
return price

http://localhost:8090/item/items   (Get request )
[
    {
        "id": 1,
        "itemName": "DOSA",
        "price": 15,
        "count": 9
    },
    {
        "id": 2,
        "itemName": "IDLI",
        "price": 25,
        "count": -55
    }
]

In Browser
localhost:4200