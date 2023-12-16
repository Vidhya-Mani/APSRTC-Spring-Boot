# APSRTC-Spring-Boot
Spring boot application to login user based and add routes, buses similar to state transport websites.

Role based authentication - User and Admin.

New user register - default user role.

password - encrypted before updating in db - bcrypt.

JWT token generated to restrict access to admin pages and user pages.

Model bus created - regnumber and type - ordinary/deluxe.

CRUD operations implemented for table bus_detail.

Only Admin can modify/delete bus detail.

Normal user and admin can view and add bus details.

Created config for Bus routes using comman line runner.

Created bus schedule dao to map bus start and end time.

Mapping of schedule and route to a bus using registration number from postman.

Only admin will be able to map these information.

Now the mapping of bus, schedule and route cannot be done when the start time and end time of a bus overlaps. Condition check before mapping.

