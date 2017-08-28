package ATMBranchFinderSpring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Invalid bank ID.") // 404
public class BankNotFoundException extends RuntimeException {

}
