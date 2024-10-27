package org.program.Log4jLogger.controller;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

//    private static final Logger logger= LogManager.getLogger(GreetController.class);
    private static final Logger logger= LoggerFactory.getLogger(GreetController.class);

    @GetMapping({"/","greet"})
    public ResponseEntity<String> greet(){
        logger.info("Control in greet method");
        logger.debug("Service logic is invoked.");
        return new ResponseEntity<>("Greetings UsersOrClient", HttpStatus.OK);
    }

}
