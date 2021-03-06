package wizard.authentication.service;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import wizard.authentication.db.pojo.User;
import wizard.authentication.exception.OperationNotAllowedException;
import wizard.authentication.exception.UnauthorizedException;
import wizard.authentication.db.repo.UserRepository;

import javax.inject.Inject;

@Service
public class SignInService {
    private static final Logger log = LoggerFactory.getLogger(SignInService.class);

    @Inject
    UserRepository userRepository;

    public void signIn(String emailAddress, String plainPassword) {
        User user = userRepository.findByEmail(emailAddress);
        if (user == null) {
            throw new UnauthorizedException("Email or password is not correct!");
        }
        validatePassword(plainPassword, user.password);
        if(user.isEmailVerified.equals(Boolean.FALSE)){
            throw new OperationNotAllowedException("Email is not verified. Please verify the email address sent to your email address");
        }
    }

    private void validatePassword(String plainPassword, String hashedPassword) {
        if (!BCrypt.checkpw(plainPassword, hashedPassword)) {
            throw new UnauthorizedException("Email or password is not correct!");
        }
    }
}
