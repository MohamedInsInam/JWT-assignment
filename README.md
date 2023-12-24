1) Clone the project.
   
2) build and run the project. (jwt-demo)
   
3) Sign up providing any username and password.(username can not be duplicated)

    api POST : http://localhost:8080/api/signup
    ex : - requesBody { "username" : "Ali", "password" : "pass123@" }
   
   Note 1 - Inmemory database is used, So, just after running the application you must sign up first.
   
   Note 2 - You can check if the user is added successfully using below api, before proceeding with Login API.
   (Please note that this is only to confirm the user is added successfully in the assignment level, this is not used in production level, since it gives users' privacy data)
   
            api GET : http://localhost:8080/api/userLogins
            sample output - [{ "id": 1, "username" : "Ali", "password" : "pass123@" }] 

5) After successful signup, you need to fire login api to get the JWT Token.

   api POST : http://localhost:8080/api/login
   ex : - requesBody { "username" : "Ali", "password" : "pass123@" }
   ex : - response { "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBbGkiLCJpYXQiOjE3MDM0MTcwOTIsImV4cCI6MTcwMzQyMDY5Mn0.CVFs1qJHqbywc7-tiMIVJ-sajg6M_G2BiFlICiyAUTs" }

6) use this token as bearer token in postman, (Bearer <token> )
7) Now you will be able to access below apis.
   
   GET : http://localhost:8080/api/secured/users/
   GET : http://localhost:8080/api/secured/post/
   GET : http://localhost:8080/api/secured/comment/
   GET : http://localhost:8080/api/secured/post/<user_id>
   GET : http://localhost:8080/api/secured/comment/<post_id>

   I will share the postman collection in email.
    
   Thanks.
