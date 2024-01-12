# Project Details

## Simple Logical Expression Grammar

| Head           | Production                                                              |
|:---------------|:------------------------------------------------------------------------|
| **Expression** | **Expression** OR **Term** \| **Term**                                  | 
| **Term**       | **Term** AND **Factor** \| **Factor**                                   | 
| **Factor**     | NOT **Factor** \| ( **Expression** )   \| **Variable** \| True \| False |
| **Variable**   | id                                                                      |

## Project Delivery Rules:
### Objective:
The objective of this project is to implement an SLR(1) parser for the provided simple logical expression grammar.

### Deliverables:

SLR(1) Parser Implementation:
* Develop an SLR(1) parser for the specified grammar. The parser should handle the parsing of basic logical expressions and build a parse table based on the SLR(1) parsing algorithm.

Example Expressions:
* Provide a set of example logical expressions that test various features of the grammar. Include expressions with OR, AND, NOT, parentheses, and variable references.

Report:
* Prepare a brief report that includes:Overview of the SLR(1) parsing algorithm and its application to the given grammar.
* Description of the parser implementation, highlighting key components.
* Examples of the parsing process for the provided expressions, showcasing the generated parse tables and parsing steps.
* Any challenges faced during the SLR(1) parser implementation and simple solutions applied.

### Submission Rules:

Code Submission:
* Submit the source code of the SLR(1) parser along with simple build instructions.
* Optionally, include comments in the code to explain critical components.

Example Expressions:
* Include a small text file or documentation with example logical expressions to demonstrate the functionality of the SLR(1) parser.

Report Submission:
* Submit a concise PDF document containing the brief report.
* Clearly explain the SLR(1) parsing approach, key parts of the implementation, and any minor challenges faced during the project.