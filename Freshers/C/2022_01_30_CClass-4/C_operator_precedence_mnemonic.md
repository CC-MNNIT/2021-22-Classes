# C Operator Precedence Mnemonic

There is a shortcut to remember C operator Precedence.

## **PUMA IS REBL** ( spell "REBL" as if "REBEL").

### NOTE:

- "I" in IS does not represent any operator and used for completion of the sentence.

- all operators with associativity not specified is left to right.

### Description:

* P - Primary
* U - Unary
* M - Multiplicative
* A - Additive
* S- Shift
* R- Relational
* E- Equality
* B- BitWise ( & > ^ > |)
* L- Logical ( logical && > logical ||)

and the last three operators are remembered as TACO as in [Mexican Taco](https://en.wikipedia.org/wiki/Taco):

* T - Ternary
* A - Assignment
* Co - Comma


## For Associativity:

All except Unary, Assignment and Ternary are Left to Right (**AUTO rides in the right**, i.e., Assignment, Unary and Ternary are right to left).

_Good luck!_