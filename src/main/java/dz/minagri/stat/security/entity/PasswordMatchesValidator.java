package dz.minagri.stat.security.entity;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
       // final UserDTO user = (UserDTO) obj;
        return true;
                //user.getPassword().equals(user.getMatchingPassword());
    }

}
