package by.epam.investmentplatform.controller.tag;

import by.epam.investmentplatform.NamesConstants;

import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentDateTag extends TagSupport {

    private static final String dataPattern = "yyyy-MM-dd";

    @Override
    public int doStartTag() {
        String date = new SimpleDateFormat(dataPattern).format(new Date());
        pageContext.getSession().setAttribute(NamesConstants.DATE, date);
        return SKIP_BODY;
    }
}
