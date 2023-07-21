# Doctor App

## Language and Framwork 

```bash
 Java , SpringBoot , JPA , MYSQL database , Swagger UI
```

## Data Flow

 1. Controller 

```bash
 #Apis for Admin (AdminController)
  createAdmin()

#Apis for Appointment (AppointmentController)
  getAllAppointments()

#Apis for Doctor (DoctorController)
  addDoctor()
  getAllDoctors()
   
#Apis for Patient (PatientController)
  signUpPatient()
  signInPatient()
  signOutPatient()
  getAllPatients()
  scheduleAppointment()
  cancelAppointment()
```
2. Service 

```bash
#Service for Admin 
  createAdmin()

#Service for Appointment 
  getAllAppointments()

#Apis for Doctor 
  addDoctor()
  getAllDoctors()
   
#Service for Patient 
  signUpPatient()
  signInPatient()
  signOutPatient()
  getAllPatients()
  scheduleAppointment()
  cancelAppointment()

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
 Post()
 User()
 AuthenticationToken()
 SignUpOutput()
 SignInInput()
 Qualification()
 Specialization()
 Appointments()
 Doctor()
 Patient()

```
4. Repository

```bash
 IAuthTokenRepo()
 IAppointmentRepo()
 IAdminRepo()
 IDoctorRepo()
 IPatientRepo()
```

## Data Structure Used

```bash
 MYSQL as database
```

## Project Summary

Doctor App is a Assignment to practice mapping , APis and SignIn and SignUP Patient and and schedult appointments springboot.
 
  #### Features for Employee

- Create /SignUp patient
- Create /SignUp Doctor
- SignIn patient (Send token on mail for verification)
- SignOut patient (Delete token)
- Create Appointment (Create the Appointment using email and token)
- Get Appontment by id(get the specific AppontmentS by providin email, token and Appontment id)

  
## Authors

- [@hritvik-soni](https://www.github.com/hritvik-soni)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)


## Support

For support, email blah@blah.com or join our Slack channel.


## License

[MIT](https://choosealicense.com/licenses/mit/)


