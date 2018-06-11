Our client wants to implement a new backup system, in which files are stored into data tapes.
 
This new system must follow the following 2 rules:    
1. Never place more than two files on the same tape.
2. Files cannot be split across multiple tapes.
	
It is guaranteed that all tapes have the same size and that they will always be able to store the largest file.
Every time this process is executed, we already know the size of each file, and the capacity of the tapes. 
Having that in mind, we want to design a system that is able to count how many tapes will be required to store the backup in the most efficient way.
The parameter of your function will be a structure that will contain the file sizes and the capacity of the tapes. 
You must return the minimum amount of tapes required to store the files.

You can write any methods or classes you would like. However,  you cannot change the Batch interface contract.

Example:
--------
	Input: Tape Size = 100; Files: 70, 10, 20
	Output: 2