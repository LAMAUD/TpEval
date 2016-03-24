package fr.treeptik.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("passwordValidator2")
public class PasswordValidator2 implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		String password = value.toString();

		UIInput uiInputConfirmPassword = (UIInput) component.getAttributes()
				.get("confirmPassword2");
		String confirmPassword = uiInputConfirmPassword.getSubmittedValue()
				.toString();

		if (password == null || password.isEmpty() || confirmPassword == null
				|| confirmPassword.isEmpty()) {
			return;
		}

		if (!password.equals(confirmPassword)) {
			uiInputConfirmPassword.setValid(false);
			throw new ValidatorException(new FacesMessage(
					"Password must match confirm password."));
		}

	}

}
