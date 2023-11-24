# IDLReasoner tutorial
## Analysis operations
IDLReasoner is a Java library that allows to automatically analyze IDL specifications and perform a number of operations on them, namely:
### 1. Generate random valid/invalid requests.
### 2. Validate requests.
### 3. Validate IDL.
### 4. check if a parameter is false optional.
### 5. check if a parameter is dead.
### 6. Provide explanations for invalid requests.

See the [IDLReasoner](https://github.com/isa-group/IDLReasonerChoco) for more details.

## How to use
### **Step 1:**
Add the following dependency to your pom.xml file.
```xml  
    <dependency>
        <groupId>es.us.isa</groupId>
        <artifactId>idlreasoner</artifactId>
        <version>1.0.0</version>
    </dependency>
    <dependency>
        <groupId>es.us.isa</groupId>
        <artifactId>idl-choco</artifactId>
        <version>1.0.0</version>
    </dependency>
```
### **Step 2:** 
Create a new analyzer object. It takes three parameters: path to the OAS file, the operation name, and operation type.
```java
Analyzer analyzer = new OASAnalyzer("./src/main/resources/OAS/OAS_test_suite_orig.yaml", "/tutorial1", "get");
```
### **Step 3:**
Perform analysis operation.
```java
Map<String, String> validRequest = analyzer.getRandomValidRequest();
```

## Example
```java
//------------------------- Analyzer object -------------------------//
Analyzer analyzer = new OASAnalyzer("./src/main/resources/OAS/OAS_test_suite_orig.yaml",
        "/tutorial1", "get");
//---------------------------------------- -------------------------//

//------------------------- Generate random valid requests -------------------------//
Map<String, String> validRequest = analyzer.getRandomValidRequest();
System.out.println("Generating a valid request: " + validRequest);

//------------------------- Generate random invalid requests -------------------------//
Map<String, String> invalidRequest = analyzer.getRandomInvalidRequest();
System.out.println("Generating an invalid request: " + invalidRequest);

//------------------------- Validating requests -------------------------------------//
System.out.println("The request is valid: " + analyzer.isValidRequest(validRequest));
System.out.println("The request is valid: " + analyzer.isValidRequest(invalidRequest));

//------------------------- Validating IDL -------------------------------------//
System.out.println("The IDL is valid: " + analyzer.isValidIDL());

//------------------------- Check if a parameter is dead -------------------------//
System.out.println("The parameter is dead: " + analyzer.isDeadParameter("p1"));

//------------------------- Check if a parameter is false optional -----------------//
System.out.println("The parameter is false optional: " + analyzer.isDeadParameter("p1"));
```