# APSRTC-Spring-Boot
Spring boot application to login user based and add routes, buses similar to state transport websites
Role based authentication - User and Admin
New user register - default user role.
password - encrypted before updating in db - bcrypt
JWT token generated to restrict access to admin pages and user pages
Model bus created - regnumber and type - ordinary/deluxe
CRUD operations implemented for table bus_detail
Only Admin can modify/delete bus detail
Normal user and admin can view and add bus details.