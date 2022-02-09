/*
 *  $
 *
 * Copyright (c) 2022  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
 */
package com.pega.controller;

import com.pega.service.AccessSecretVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author vagrant
 * @version $ 2/8/22
 */
@Controller
public class WelcomeController {

        @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
        public @ResponseBody
        String helloWorld() throws Exception {

            return AccessSecretVersion.accessSecretVersion(); //"application/json" mean this is a text not a redirect
        }
}
