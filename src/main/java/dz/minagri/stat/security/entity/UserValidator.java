package dz.minagri.stat.security.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class UserValidator  {

/*   @Override
   public boolean supports(final Class<?> clazz) {
        return UserDTO.class.isAssignableFrom(clazz);
    }*/


    public void validate(final Object obj, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "message.firstName", "Firstname is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "message.lastName", "LastName is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "message.password", "LastName is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "message.username", "UserName is required.");
    }

}
