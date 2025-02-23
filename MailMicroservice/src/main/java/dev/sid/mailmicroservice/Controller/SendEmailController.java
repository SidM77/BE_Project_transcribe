package dev.sid.mailmicroservice.Controller;


import dev.sid.mailmicroservice.Service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tests")
public class SendEmailController {

    public SendEmailService sendEmailService;

    public SendEmailController(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

//    @GetMapping("/sendEmail")
//    public String sendEmail() {
//        sendEmailService.sendEmail("siddanth.manoj@gmail.com", "Click here for test link https://localhost:3000/67b8ba0ca4850643c45e164d", "Invitation for Interview Round 1");
//        return "Sent";
//    }


    @GetMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestParam String email,
                                            @RequestParam String body,
                                            @RequestParam String subject) {
        sendEmailService.sendEmail(email, body, subject);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/assignTest")
    public ResponseEntity<String> assignTest(@RequestParam String email,
                                            @RequestParam String id) {
        sendEmailService.sendEmail(email, "Please use this link to give Round 1 of the test http://localhost:5173/round1/" +id, "Invitation to Interview Round 1");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
