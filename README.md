# BUS-Spring-Boot Project

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

### SNAPSHOTS:
    This folder has all the screenshots of postman and db created with data. I have configured the port to 9090 for this project.

## Steps Followed to implement all requirements:

Role based authentication - User and Admin.
    http://localhost:9090/authenticate - POST
    Create admin role using a method initrole after postconstruct. Set default role as user for any new login
    {
    "name": "Mah",
    "password": "mah123"
    }
New user register - default user role.
    http://localhost:9090/registerUser - POST
    {
    "name": "Dha",
    "age": 7,
    "email": "dha@gmail.com",
    "password": "dha123"
}

password - encrypted before updating in db - using bcrypt.

JWT token generated to restrict access to admin pages and user pages.
    This token generated should be passed in header as key for Authorization in form bearer TOKEN

Models  created -

    apsrtc=> \dt
            List of relations
    Schema |     Name     | Type  | Owner 
    --------+--------------+-------+-------
    public | bus_detail   | table | root
    public | bus_route    | table | root
    public | bus_schedule | table | root
    public | role         | table | root
    public | user_role    | table | root
    public | user_table   | table | root
    (6 rows)

CRUD operations implemented for table bus_detail.
    http://localhost:9090/api/busDetail - GET,POST
    http://localhost:9090/api/busDetail/2 - PUT and DELETE
    {
    "registrationNumber": "KL31NN1234",
    "type": "ORDINARY"
    }

Only Admin can modify/delete bus detail.

Normal user and admin can view and add bus details.

Created config for Bus routes using command line runner. 
    But when restarting the server after db creation comment out the save list as it will try to run again and build will fail as duplicates will not be created.

Created bus schedule dao to map bus start and end time.

Mapping of schedule and route to a bus using bus_id from postman.
    http://localhost:9090/api/busDetail/4/map-schedule - POST
    {
   "registrationNumber": "KL31NN1234",
    "routeName": "routeBK",
    "startTime": "2023-12-01T21:00:00",
    "endTime": "2023-12-01T05:00:00"
    }

Only admin will be able to map these information.

Now the mapping of bus, schedule and route cannot be done when the start time and end time of a bus overlaps. Condition check before mapping.

Displayed the Route wise bus details with bus reg number and type when hit from postman.
    http://localhost:9090/api/busDetail/buses-for-route?routeName=routeBK - GET

DB DATA - COMPLETE LIST:

    apsrtc=> select * from role;
        role  |        role_description         
        -------+---------------------------------
        Admin | Admin permissions update/delete
        User  | Default role for all new users
        (2 rows)

    apsrtc=> select * from user_role;
 user_id | role_id 
---------+---------
 vidhya  | Admin
 Mahil   | User
 Dharun  | User
(3 rows)

    apsrtc=> select * from user_table;
  name  | age |      email       |                           password                           
--------+-----+------------------+--------------------------------------------------------------
 vidhya |  22 | vidhya@gmail.com | $2a$10$apkzkMl5uhhWeBIGYXvtzuJV7.IiNc6c7NEdTDQ4IH6jW.gztorZG
 Mahil  |   9 | mahil@gmail.com  | $2a$10$bCi7OkrgaeaV75q/F2s.l.d.xuoMBOjcCBi0m6AROP6zsZOm2R9wW
 Dharun |   7 | dharun@gmail.com | $2a$10$MHFuaIC4ilnSnREYtBq.c.0Qlq4ou5Mc05ulQnoj4nHIXILKzOL/6
(3 rows)

    apsrtc=> select * from bus_detail;
 id | registration_number |   type   
----+---------------------+----------
  2 | TN51NU1234          | DELUXE
  3 | KA51PUT1234         | ORDINARY
  4 | KL31NN1234          | ORDINARY
(3 rows)

    apsrtc=> select * from bus_route;
 id | end_place | route_name | start_place 
----+-----------+------------+-------------
  1 | Chennai   | routeBC    | Bangalore
  2 | Hyderabad | routeBH    | Bangalore
  3 | Goa       | routeBG    | Bangalore
  4 | Kerala    | routeBK    | Bangalore
  5 | Mumbai    | routeBM    | Bangalore
  6 | Bangalore | routeCB    | Chennai
  7 | Bangalore | routeHB    | Hyderabad
  8 | Bangalore | routeGB    | Goa
  9 | Bangalore | routeKB    | Kerala
 10 | Bangalore | routeMB    | Mumbai
(10 rows)

    apsrtc=> select * from bus_schedule;
 id |      end_time       |     start_time      | bus_id | route_id 
----+---------------------+---------------------+--------+----------
  2 | 2023-12-01 15:00:00 | 2023-12-01 08:00:00 |      2 |        4
  3 | 2023-12-01 12:00:00 | 2023-12-01 08:00:00 |      3 |        4
  4 | 2023-12-01 17:00:00 | 2023-12-01 13:00:00 |      3 |        8
  5 | 2023-12-01 05:00:00 | 2023-12-01 21:00:00 |      4 |        4
(4 rows)


