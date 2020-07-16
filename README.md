Program that takes 2 string parameters from the command line. 
Verify if the second string is a substring of the first string 
(without use substr, substring or any other standard function 
including regular expression libraries).

Each occurrence of * in the second substring means that it can be a match for 
zero or more characters of the first string.

Consider the example:
Input string 1: abcd
Input string 2: a*c
Program evaluate that the string 2 is a substring of the string 1.

Additionally asterisk (*) may be considered as a regular character, if it 
is preceded by a backslash (\).  Backslash (\) is considered as a regular 
character in all cases other than preceding the asterisk (*).
