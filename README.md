# CinemaRoom-REST-Service
A REST service app for handling cinema ticketing. Implemented from HYPERSKILL. (see below picture)

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/c2e638d6-551e-4ff2-a22f-c3fc3a9761f7)


## Endpoints

*Runs on localhost:8080

#### Get All Available Seats

```http
  GET /seats
```

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/26def129-d65a-49a6-9c69-b30da13ee348)

#### Purchase a Seat

```http
  POST /purchase
```

| Parameter | Value    | 
| :-------- | :------- |
|  `row  `  |  `int`   |
| `column ` |  `int`   |

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/9cb81ce8-8fe0-403e-98dc-cb5e886a4251)

#### Refund a Seat/Ticket

```http
  POST /return
```

| Parameter | Value    | 
| :-------- | :------- |
|  `token`  |  `UUID`  |

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/4a262d4d-0024-445e-ad01-f531973fe445)

#### Check the Stats

*Make sure to give the correct password parameter. ( password = super_secret)

```http
  POST /stats
```

| Parameter | Value    | 
| :-------- | :------- |
|  `password  `  |  `string`   |

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/ebd0bab4-28f3-4545-af43-ca6d485e9124)


## Some of the Mant Other Utilities Include:
#### Multiple exception checks and information for failures

  ![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/7201f814-3eff-4592-beec-95649d064739)

#### Token Validation when refunding purchased tickets and the check of availability of seats(you can only return a ticket with the token you got after purchasing the said ticket)

#### Smart Pricing
  
  ![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/e6b6e3d9-0ba3-445e-96fc-8dd30dfc3507)
  
#### Stats include live income and the state of the cinema room(s) 
