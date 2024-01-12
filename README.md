# little-compiler

Compiler Design project

# Project Details

## Simple Logical Expression Grammar

| Head           | Production                                                              |
|:---------------|:------------------------------------------------------------------------|
| **Expression** | **Expression** OR **Term** \| **Term**                                  | 
| **Term**       | **Term** AND **Factor** \| **Factor**                                   | 
| **Factor**     | NOT **Factor** \| ( **Expression** )   \| **Variable** \| True \| False |
| **Variable**   | id                                                                      |

## Augmented Grammar

| ID | Head   | Production      |
|----|--------|-----------------|
| 0  | **E'** | **E**           |
| 1  | **E**  | **E** OR **T**  |
| 2  | **E**  | **T**           |
| 3  | **T**  | **T** AND **F** |
| 4  | **T**  | **F**           |
| 5  | **F**  | NOT **F**       |
| 6  | **F**  | (**E**)         |
| 7  | **F**  | **V**           |
| 8  | **F**  | True            |
| 9  | **F**  | False           |
| 10 | **V**  | id              |

## Follow Table

| Symbol | Follow        |
|--------|---------------|
| E      | OR, ), $      |
| T      | OR, ), $, AND |
| F      | OR, ), $, AND |
| V      | OR, ), $, AND |

## Parse Table

|     | OR  | AND | NOT | (  | )   | True | False | id | $      | E   | T   | F   | V  |
|-----|-----|-----|-----|----|-----|------|-------|----|--------|-----|-----|-----|----|
| I0  |     |     | s4  | s5 |     | s7   | s8    | s9 |        | g1  | g2  | g3  | g6 |
| I1  | s10 |     |     |    |     |      |       |    | accept |     |     |     |    |
| I2  | r2  | s11 |     |    | r2  |      |       |    | r2     |     |     |     |    |
| I3  | r4  | r4  |     |    | r4  |      |       |    | r4     |     |     |     |    |
| I4  |     |     | s4  | s5 |     | s7   | s8    | s9 |        |     |     | g12 | g6 |
| I5  |     |     | s4  | s5 |     | s7   | s8    | s9 |        | g13 | g2  | g3  | g6 |
| I6  | r7  | r7  |     |    | r7  |      |       |    | r7     |     |     |     |    |
| I7  | r8  | r8  |     |    | r8  |      |       |    | r8     |     |     |     |    |
| I8  | r9  | r9  |     |    | r9  |      |       |    | r9     |     |     |     |    |
| I9  | r10 | r10 |     |    | r10 |      |       |    | r10    |     |     |     |    |
| I10 |     |     | s4  | s5 |     | s7   | s8    | s9 |        |     | g14 | g3  | g6 |
| I11 |     |     | s4  | s5 |     | s7   | s8    | s9 |        |     |     | g15 | g6 |
| I12 | r5  | r5  |     |    | r5  |      |       |    | r5     |     |     |     |    |
| I13 | s10 |     |     |    | s16 |      |       |    |        |     |     |     |    |
| I14 | r1  | s11 |     |    | r1  |      |       |    | r1     |     |     |     |    |
| I15 | r3  | r3  |     |    | r3  |      |       |    | r3     |     |     |     |    |
| I16 | r6  | r6  |     |    | r6  |      |       |    | r6     |     |     |     |    |

