Exercise 2.24
-------------


Interpreter output

sicp-mailonline.core=> (list 1 (list 2 (list 3 4)))
(list 1 (list 2 (list 3 4)))



Box and pointer structure

[.|.] - [.|.] - nil
 |       |
 |     [.|.] - [.|.] - nil
 |      |       |
 |      |       |
 |      |     [.|.] - [.|.] - nil
 |      |      |       | 
 1      2      3       4 



As a tree

              +
            /   \  
          1      +
               /   \
              2     +
                  /   \
                3      4
