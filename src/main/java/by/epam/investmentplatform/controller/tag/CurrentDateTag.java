package by.epam.investmentplatform.controller.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTag extends TagSupport {
    private static final long serialVersionUID = -3464982113309963974L;

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.println("Current date: " + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }
}
