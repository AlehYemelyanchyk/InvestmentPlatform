package by.epam.investmentplatform.controller.tag;

import by.epam.investmentplatform.NamesConstants;

import javax.servlet.jsp.tagext.TagSupport;
import java.time.LocalDate;

public class GetCurrentDateTag extends TagSupport {

    @Override
    public int doStartTag() {
        pageContext.getSession().setAttribute(NamesConstants.DATE, LocalDate.now());
        return SKIP_BODY;
    }
}
