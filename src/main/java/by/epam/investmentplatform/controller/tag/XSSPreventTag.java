package by.epam.investmentplatform.controller.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XSSPreventTag extends TagSupport {
    private static final long serialVersionUID = -8878080453938946192L;
    private String inputText;

    @Override
    public int doStartTag() throws JspException {
        try {
            setInputText("some text");
            JspWriter out = pageContext.getOut();
            out.println("Current date: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    public void setInputText (String inputText){
        this.inputText = inputText;
    }
}
