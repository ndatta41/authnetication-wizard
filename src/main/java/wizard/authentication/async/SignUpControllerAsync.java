package wizard.authentication.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.async.DeferredResult;
import wizard.authentication.request.CommonMessageResponseREST;
import wizard.authentication.request.SignUpRequestREST;
import wizard.authentication.service.SignUpService;

import javax.inject.Inject;

@Controller
@EnableAsync
public class SignUpControllerAsync {
    private static final Logger log = LoggerFactory.getLogger(SignUpControllerAsync.class);

    @Inject
    private SignUpService signUpService;

    @Async
    public void createNewAccount(
            DeferredResult<ResponseEntity<CommonMessageResponseREST>> result,
            SignUpRequestREST requestREST
    ) {
        log.info("Processing create account request with using email: {}", requestREST.emailAddress);
        signUpService.createAccount(requestREST);
        result.setResult(new ResponseEntity<>(HttpStatus.OK));
    }

}