# Restaurant Management Service API

## Language and Framwork 

```bash
 Java , SpringBoot , JPA , MYSQL database , Swagger UI
```

## Data Flow

 1. Controller 

```bash
 #Apis for Admin (AdminController)
  getAllUsers()
  getAllOrders()
  getAllFoodItems()
 

 #Apis for FoodItem (FoodItemController)
  getAllFoodItem()
  addFoodItem()


#Apis for User (UserController)
  signUpUser()
  signInUser()
  signOutUser()
  orderFood()
  cancelorder()

```
2. Service 

```bash
 #Service for Admin 
  getAllUsers()
  getAllOrders()
  getAllFoodItems()
 

 #Service for FoodItem 
  getAllFoodItem()
  addFoodItem()


#Service for User
  signUpUser()
  signInUser()
  signOutUser()
  orderFood()
  cancelorder()

```

3. Model

```bash
 Admin()
 FoodItem()
 Order()
 User()
 AuthenticationToken()
 SignUpOutput()
 SignInInput()
```
4. Repository

```bash
 IAuthTokenRepo()
 IFoodItemRepo()
 IOrderRepo()
 IUserRepo()

```

## Data Structure Used

```bash
 MYSQL as database
```

## Project Summary

Restaurant Management Service API is a Assignment to practice mapping , APis and SignIn and SignUP users in springboot.
 
  #### Features for Employee

- Create /SignUp user
- SignIn user(Send token on mail for verification)
- SignOut user (Delete token)
- Create Order (Create the order using Foofitem id and user Id )
- create List of food item
- create Admin (special email for admin only)

  
## Authors

- [@hritvik-soni](https://www.github.com/hritvik-soni)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)


## Support

For support, email blah@blah.com or join our Slack channel.


## License

[MIT](https://choosealicense.com/licenses/mit/)


