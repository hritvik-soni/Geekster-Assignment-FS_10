# Instagram Backend

## Language and Framwork 

```bash
 Java , SpringBoot , JPA , MYSQL database , Swagger UI
```

## Data Flow

 1. Controller 

```bash
 #Apis for Admin(AdminController)
  createAdmin()

#Apis for User (UserController)
  signUpUser()
  signInUser()
  signOutUser()
  createInstaPost()
  removeInstaPost()
  addComment()
  removeInstaComment()
  addLike()
  getLikeCountByPost()
  removeInstaLike()
  followUser()
  unFollowUser()
```
2. Service 

```bash
 #Service for Admin 
  createAdmin()

#Service for User 
  signUpUser()
  signInUser()
  signOutUser()
  createInstaPost()
  removeInstaPost()
  addComment()
  removeInstaComment()
  addLike()
  getLikeCountByPost()
  removeInstaLike()
  followUser()
  unFollowUser()

#Service for authenticationService
  authenticate()
  saveAuthToken()
  findFirstByUser()
  removeToken()

#Service for utility
  EmailUtility()
  HashingUtility()
```

3. Model

```bash
 Admin()
 User()
 AuthenticationToken()
 SignUpOutput()
 SignInInput()
 Comment()
 Follow()
 Like()
 post()
 AccountType()
 Gender()
 PostType()
```
4. Repository

```bash
 IAuthTokenRepo()
 IPostRepo()
 ICommentRepo()
 IFollowRepo()
 ILikeRepo()
 IPAdminRepo()
 IUserRepo()
```

## Data Structure Used

```bash
 MYSQL as database
```

## Project Summary

Instagram Backend is a Assignment to practice mapping , APis and SignIn and SignUP createPost and get post by id in springboot.
 
  #### Features for Employee

- Create /SignUp user
- SignIn user(Send token on mail for verification)
- SignOut user (Delete token)
- Create Post (Create the Post using email and token and post link)
- Like a Post (like the Post using email and token and post id)
- Comment Post (comment on the Post using email and token and post id)
- Follow a user (by user id and email)

  
## Authors

- [@hritvik-soni](https://www.github.com/hritvik-soni)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)


## Support

For support, email blah@blah.com or join our Slack channel.


## License

[MIT](https://choosealicense.com/licenses/mit/)


