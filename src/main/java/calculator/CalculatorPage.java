package calculator;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.Arrays;
import java.util.List;

public class CalculatorPage extends WebPage {
    private ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
    private static final List<String> TYPES = Arrays
            .asList(new String[]{"\"+\"", "\"-\"", "\"*\"", "\"/\""});
    private String selected = "\"+\"";

    public CalculatorPage(final PageParameters parameters) {

        add(new FeedbackPanel("feedback"));

        String resultFromParametersStr = "";

        if (parameters.containsKey("result")) {
            resultFromParametersStr = parameters.getString("result");
        }

        final Label result = new Label("result", "Result : " + resultFromParametersStr);

        final TextField<String> number1 = new TextField<String>("num1",
                Model.of(""));
        number1.setRequired(true);
        number1.add(new NumberValidator());

        final TextField<String> number2 = new TextField<String>("num2",
                Model.of(""));
        number2.setRequired(true);
        number2.add(new NumberValidator());

        final RadioChoice<String> hostingType = new RadioChoice<String>(
                "hosting", new PropertyModel<String>(this, "selected"), TYPES);

        Form<?> form = new Form<Void>("calcForm") {

            @Override
            protected void onSubmit() {

                final String number1Str = number1.getModelObject();
                final String number2Str = number2.getModelObject();
                final String operationStr = hostingType.getModelObject();

                String resultStr = arithmeticOperations.execute(number1Str, number2Str, operationStr);

                PageParameters pageParameters = new PageParameters();
                pageParameters.add("result", resultStr);
                setResponsePage(CalculatorPage.class, pageParameters);

            }

        };

        add(form);
        form.add(number1);
        form.add(number2);
        form.add(hostingType);
        add(result);

    }
}
