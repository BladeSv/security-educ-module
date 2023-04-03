package by.mitr.securityeducmodule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping(path = "/info",method = RequestMethod.GET)
    public ResponseEntity<String> getInfo(){
        return ResponseEntity.ok("Hello Security Info");
    }

    @RequestMapping(path = "/about",method = RequestMethod.GET)
    public ResponseEntity<String> getAbout(){
        return ResponseEntity.ok("Information about Security");
    }

    @RequestMapping(path = "/admin",method = RequestMethod.GET)
    public ResponseEntity<String> getAdmin(){
        return ResponseEntity.ok("Information about Admin");
    }
}
