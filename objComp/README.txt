CS442 Design Patterns
Spring 2015
PROJECT 5 README FILE

Due Date: Monday, May 4, 2015
Submission Date: Monday, May 4, 2015
Grace Period Used This Project: 0 Days
Grace Period Remaining: ??? Days
Authors: Joseph Howard and Weronika Kowalczyk
e-mails: jhoward4@binghamton.edu wkowalc1@binghamton.edu


PURPOSE:

This project uses Java reflection to create objects whose attributes
are specified in an input file.

PERCENT COMPLETE:

We believe this project is 100% complete.

PARTS THAT ARE NOT COMPLETE:

We believe all parts to be complete.

BUGS:

We did not find any bugs while testing the code.

JUSTIFICATION:

	In the FileProcessor we used BufferedReader because we saw in the 
last project that it is faster than Scanner. In PopulateObjects we used a 
HashMap to store the types of Integer, String, and Double because that way
we just had to look up the key depending on which instance we needed. We also 
used HashMaps to store the instances of First and Second because it is more 
efficient than ArrayList when doing the add and remove operations. 

FILES:
    
    Included with this project are 10 files:

    build.xml, the build file for this project
    README.txt, the file you are currently reading that describes the 
        project
    FileProcessor.java, the file user to parse the input file text
    Logger.java, the debug class that prints out messages when specific
        actions occur
	Driver.java, the main driver for the PopulateObjects object
	PopulateObjects.java, contains the class that takes in the input file and 
		populates the objects of First and Second with the attributes
		specified in that file.
	First.java, one of the classes from which objects are being made in 
		PopulateObjects, contains an int and String value
	Second.java, one of the classes from which objects are being made in 
		PopulateObjects, contains a double and int value
	 
    
SAMPLE OUTPUT:

Number of non-duplicate First objects: 4
Total Number of First objects: 6
Number of non-duplicate Second objects: 6
Total Number of Second objects: 8
Total time: 0.256 seconds

TO COMPILE:

    Run the command "ant -buildfile src/build.xml all"

TO RUN:

    Run the command "ant -buildfile src/build.xml run -Darg0="input.txt" -Darg1="5" -Darg2="0""

LOGGER VALUES:

    0 - no logging statements
    1 - reading from a file
    2 - methods have been overridden
    3 - Map has been added to
    4 - Parameters have ben created

EXTRA CREDIT:

None

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Joseph Howard
Weronika Kowalczyk

ACKNOWLEDGEMENT:

    During the coding process one or more of the following people may have been
    consulted. Their help is greatly appreciated. They helped with by providing 
    moral support, and consulting on design questions and syntax clarification.

