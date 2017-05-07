package calculator;


import org.apache.wicket.validation.CompoundValidator;
import org.apache.wicket.validation.validator.PatternValidator;
import org.apache.wicket.validation.validator.StringValidator;

public class NumberValidator extends CompoundValidator<String> {
    private static final long serialVersionUID = 1L;

    public NumberValidator() {

        add(StringValidator.lengthBetween(1, 100));
        add(new PatternValidator("([0-9]+)||([0-9]+(\\u002E\\d{1,20})?)"));

    }
}
