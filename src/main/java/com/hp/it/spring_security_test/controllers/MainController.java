package com.hp.it.spring_security_test.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Bruce jia (chen-wei.jia@hp.com)
 * Date: 14-5-6
 * Time: 下午5:08
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/main")
public class MainController {
    protected static Logger logger = Logger.getLogger("controllers");

    /**
     * common page
     *
     * @return
     */
    @RequestMapping(value = "/common", method = RequestMethod.GET)
    public String getCommonPage() {
        logger.debug("Received request to show common page");
        return "commonpage";
    }

    /**
     * admin page
     *
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAadminPage() {
        logger.debug("Received request to show admin page");
        return "adminpage";

    }
}
