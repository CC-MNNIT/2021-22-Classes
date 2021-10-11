# Code Warrior Class-2

#### October 11th, 2021

### Code Warrior Class 2 [Recording](https://bit.ly/CodeWarriors-class2)

## Class Content :-

### Minimax with Alpha-Beta pruning Algorithm

- [AlphaBeta Pruning PDF](alphabetapruning.pdf)
- [UCLA CS 161 Notes On Alpha-Beta pruning](http://web.cs.ucla.edu/~rosen/161/notes/alphabeta.html)

### Additional Resources
- [Minimax, and Alpha-Beta: MIT OpenCourseWare](https://www.youtube.com/watch?v=STjW3eH0Cik)
- [Alpha-Beta pruning: HackerEarth](https://www.hackerearth.com/blog/artificial-intelligence/minimax-algorithm-alpha-beta-pruning/)
- [Minimax/Alpha-Beta Simulator](https://raphsilva.github.io/utilities/minimax_simulator/)

### Additional Topics
- Move Ordering
- BitBoards
- Iterative Deepening
- Killer Heuristics
- History Heuristics
- Principal Variation (PV) Moves
- Null Move Heuristics
- Transposition tables

Here is a code for 2k17's problem statement, you can clone the repo ;)
[Clash Of Pawns AI](https://github.com/Abhey/Clash-Of-Pawn-AI)

### PseudoCode for Minimax with Alpha-Beta Pruning

```python
evaluate (node, alpha, beta)
     if node is a leaf
        return the heruistic value of node
     if node is a minimizing node
        for each child of node
            beta = min (beta, evaluate (child, alpha, beta))
            if beta <= alpha
                return beta
        return beta
     if node is a maximizing node
        for each child of node
            alpha = max (alpha, evaluate (child, alpha, beta))
            if beta <= alpha
                return alpha
        return alpha
```