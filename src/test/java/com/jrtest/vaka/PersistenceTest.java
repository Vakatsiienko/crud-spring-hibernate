package com.jrtest.vaka;

import com.jrtest.vaka.config.PersistenceConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author Iaroslav
 * @since 20.12.2014 15:40
 */
@ContextConfiguration(classes = PersistenceConfig.class)
public class PersistenceTest extends AbstractTestNGSpringContextTests {


}
