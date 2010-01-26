README
======

To build the application, we use NetBean 6.5.

1) Launch NetBean.
2) In File menu, select Open Project...
3) Select the folder NormeticValidator folder (or the trunk folder below NormeticValidator folder).
4) Select the root element of the project in the Projects window, right-click and Build.

At this moment, NetBean will generate the build files required to compile and build the application.
If some errors occur at the compile step, maybe it's caused by missing libraries:

1) Select Libraries category in the Projects window, right-click and Properties.
2) In Frameworkѕ category, click Add and select Visual Web JavaServer Faces.
3) In Libraries category, click Add JAR/Folder and select these files :

- saxon9.jar (taken from saxonb9-1-0-5j) 
- jing.jar (taken from jing-20030619) * Not really used for now *

Note that other versions of these jar files may work but have not been tested.

4) Select the root element of the project in the Projects window, right-click and Build.

At this moment, you should be able to compile and build the application.
