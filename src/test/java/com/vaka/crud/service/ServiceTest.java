package com.vaka.crud.service;

import com.vaka.crud.config.PersistenceConfig;
import com.vaka.crud.config.ServiceConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author Iaroslav
 * @since 22.12.2014 20:48
 */
@ContextConfiguration(classes = {ServiceConfig.class, PersistenceConfig.class})
public class ServiceTest extends AbstractTestNGSpringContextTests {
}
