package by.epam.investmentplatform.controller.tag;

import by.epam.investmentplatform.Constants;

import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getCurrentDateTag extends TagSupport {
    private static final long serialVersionUID = -3464982113309963974L;

    @Override
    public int doStartTag() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        pageContext.getSession().setAttribute(Constants.DATE, date);
        return SKIP_BODY;
    }
}
