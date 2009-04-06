README
======

To build the application, we use NetBean 6.  Here is the procedure to set up the project:

1) Launch NetBean.
2) In File menu, select New Project...
3) Select Web category and Web application with Existing Sources.
4) Enter your project folder location (e.g.: O:\gtn-quebec\LomValidatorUI).  This folder should contains web and src directories.
5) Add Tomcat server.
6) Click Next.
7) Click Finish.
8) Select the root element of the project in the Projects window, right-click and Build.

At this moment, NetBean will generate the build files required to compile and build the application.
It should be impossible to compile at this moment as some libraries must be specified to resolve dependencies.

9) Select Libraries category in the Projects window, right-click and Properties.
10) In Frameworkѕ category, click Add and select Visual Web JavaServer Faces.
11) In Libraries category, click Add JAR/Folder and select these files :

- saxon9.jar (taken from saxonb9-1-0-5j) 
- jing.jar (taken from jing-20030619) * Not really used for now *

Note that other versions of these jar files may work but have not been tested.

12) Select the root element of the project in the Projects window, right-click and Build.

At this moment, you should be able to compile and build the application.


