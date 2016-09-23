package org.rfid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zlatan on 09.08.16.
 */
@Controller
public class StaticHTMLController {

    @RequestMapping(value = "/")
    public String index(){
        return "/index.html";
    }
}
