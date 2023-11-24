package es.us.isa.reasonertutorial;

import es.us.isa.idlreasonerchoco.analyzer.Analyzer;
import es.us.isa.idlreasonerchoco.analyzer.OASAnalyzer;
import es.us.isa.idlreasonerchoco.configuration.IDLException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    public static void main(String[] args) throws IDLException {

        //------------------------- Reasoner tutorial -------------------------//

        // Reasoner operations:
        // 1. Generate random valid/invalid requests.
        // 2. Validate requests.
        // 3. Validate IDL.
        // 4. check if a parameter is false optional.
        // 5. check if a parameter is dead.
        // 6. Provide explanations for invalid requests.

        //How to use the reasoner:

        // Step 1: Create a new analyzer Object.
        // Step 2: Perform analysis operation.
        // Step 3: Get the result of the analysis operation.


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


        //------------------------- Analyzer object -------------------------//
        Analyzer analyzer2 = new OASAnalyzer("./src/main/resources/OAS/OAS_test_suite_orig.yaml",
                "/tutorial2", "get");
        //---------------------------------------- -------------------------//

        //------------------------- Validating IDL -------------------------------------//
        System.out.println("The IDL is valid: " + analyzer2.isValidIDL());

        //------------------------- Check if a parameter is dead -------------------------//
        System.out.println("The parameter is dead: " + analyzer2.isDeadParameter("p1"));

        //------------------------- Check if a parameter is false optional -----------------//
        System.out.println("The parameter is false optional: " + analyzer2.isDeadParameter("p1"));

    }
}