# TLV-Processor
Process TLVs with the following format 
- Format: TYPE(6)-LENGTH(4)-VALUE 
- Type - fixed 6 chars length. Defines the type of processing required. 
- Length - fixed 4 chars (represented as text) length of the value. 
- Value - the actual data to be processed of length 'Length' above

Processing requirements
- For Type UPPRCS: convert the value to uppercase, if already uppercase do nothing.
- For Type REPLCE: replace the value with fixed string "THIS STRING"
- For any other type indicate an error “Type not valid” and continue processing.
- Output should be printed as the TLVs are processed.
- Input is specified on StdIn and output is expected on StdOut.
- Assume all data is in ascii.
- Assume all data will always follow the format specified, i.e. no malformed TLVs.

Coding requirements
- Create a jar file name tlvprocessor.jar with all the dependencies used in the project.
- Design for extensibility, which will help to easily add
- New input-output types like network streams
- New processors like LOWRCS


Sample Test Cases
This is one of test case suite that will be used for evaluation. Please test your code against these
before submitting. All test cases MUST pass before the code can be accepted.

The test is run as follow:
java -jar tlvprocessor.jar < input
Note: The input is still from STDIN.

Input:
UPPRCS-0005-abcde
REPLCE-0003-123
UPPRCS-0008-Abcdefgh
REPLCE-0003-123
REPLCE-0001-Z
TAG001-0012-abcdefgh1234
UPPRCS-0004-1234
ABCDEF-0004-abcde-12

Output:
UPPRCS-ABCDE
REPLCE-THIS STRING
UPPRCS-ABCDEFGH
REPLCE-THIS STRING
REPLCE-THIS STRING
Type not valid
UPPRCS-1234
Input is in invalid Format
