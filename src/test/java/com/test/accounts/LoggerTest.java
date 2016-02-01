package com.test.accounts;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by saikrisv on 01/02/16.
 */
public class LoggerTest {

    Logger logger = Logger.getLogger(LoggerTest.class);

    @Test
    public void testLogger(){
        logger.debug("Debug Message!!!");
        logger.warn("Warning Message");
    }

}
