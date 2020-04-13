package by.epam.investmentplatform.view;

import by.epam.investmentplatform.service.UserService;
import by.epam.investmentplatform.service.exceptions.ServiceException;
import by.epam.investmentplatform.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
    private static final Logger LOGGER = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
//        User user = new User("2", "brent", "1234qwer", "russian-brent@mail.ru", "Igor", "Sechin", "643");
//        User user = new User("2", "brent", "1234qwer", "russian-brent@mail.ru", "Igor", "Sankin", "643");
//        userService.save(user);
//        System.out.println(userService.update(user,));
//        System.out.println(userService.deleteUser("brent"));
//        userService.getUser(1);
        try {
            System.out.println(userService.getAllUsers());
        } catch (ServiceException e) {
            LOGGER.error("Error happens.", e);
        }
    }
}
