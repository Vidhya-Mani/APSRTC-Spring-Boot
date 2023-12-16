# APSRTC-Spring-Boot

### CASE STUDY SCENARIO:
Catering to the commutation needs of an ever-increasing population was never a piece of cake, for the state-owned transport company ABC. Every day new buses were added into the fleet, and due to population expanding in the suburbs, new bus routes had to be identified. The management was facing problem in managing and mapping buses to proper routes. The department was receiving lot of complaints regarding improper management of bus schedules. People too were complaining regarding frequency of buses in some routes. Proper distribution of buses based on classes was also missing. Looking into all the above problems, APSRTC finally decided to automate the whole system of managing the fleet details. Below are given the Requirements decided by the management:
Create a screen with Login Id and Password. Check for the different roles and restrict access to perform the specified operations. (I.e., User cannot Modify/Delete values.). User types are Admin and User
Read the requirements carefully; Use appropriate fields and normalize the database wherever necessary
Provide feature to add  bus details, modify details and delete bus details.
The routes on which these buses ply should be taken from a static table ( Preloaded data)
Option to map the buses to these routes should be provided. At the time of mapping a bus, the start time and the end time of the trip too should be captured.
Bus schedules should not overlap.
Buses are of two types Ordinary and deluxe.
Display the Route wise bus details with bus reg number using a stored procedure.

## Steps Followed to implement all requirements:

Spring boot application to login user based and add routes, buses similar to state transport websites.

Role based authentication - User and Admin.

New user register - default user role.

password - encrypted before updating in db - bcrypt.

JWT token generated to restrict access to admin pages and user pages.

Model bus created - regnumber and type - ordinary/deluxe.

CRUD operations implemented for table bus_detail.

Only Admin can modify/delete bus detail.

Normal user and admin can view and add bus details.

Created config for Bus routes using command line runner.

Created bus schedule dao to map bus start and end time.

Mapping of schedule and route to a bus using registration number from postman.

Only admin will be able to map these information.

Now the mapping of bus, schedule and route cannot be done when the start time and end time of a bus overlaps. Condition check before mapping.

Displayed the Route wise bus details with bus reg number and type when hit from postman.


