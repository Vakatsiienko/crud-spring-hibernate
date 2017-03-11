package com.vaka.crud.controller;

import com.vaka.crud.config.PersistenceConfig;
import com.vaka.crud.config.ServiceConfig;
import com.vaka.crud.config.WebConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author Iaroslav
 * @since 27.12.2014 17:06
 */
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, PersistenceConfig.class, ServiceConfig.class})
public class ControllerTest extends AbstractTestNGSpringContextTests {

}

