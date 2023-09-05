# CinemaRoom-REST-Service
A REST service app for handling cinema ticketing. Implemented from HYPERSKILL.

- localhost:8080/seats
// Get Available Seats

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/26def129-d65a-49a6-9c69-b30da13ee348)

- localhost:8080/purchase
//Purchase a Seat

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/9cb81ce8-8fe0-403e-98dc-cb5e886a4251)

- localhost:8080/return
//Refund a Seat/Ticket

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/4a262d4d-0024-445e-ad01-f531973fe445)

- localhost:8080/stats?password=super_secret
//Check the Stats
*Give the correct password param like below

![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/ebd0bab4-28f3-4545-af43-ca6d485e9124)


Other Utilities include:
- Multiple exception checks and information for failures
  ![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/7201f814-3eff-4592-beec-95649d064739)

- Token Validation when refunding purchased tickets and the check of availability of seats(you can only return a ticket with the token you got after purchasing the said ticket)
- Smart Pricing
  
  ![image](https://github.com/ataberkuysal/CinemaRoom-REST-Service/assets/54504620/e6b6e3d9-0ba3-445e-96fc-8dd30dfc3507)
- Stats include live income and the state of the cinema room(s) 
