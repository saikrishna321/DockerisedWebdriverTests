package com.test.accounts;

import junit.framework.Assert;
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
        logger.info("Info Message");
        try{
            Assert.assertTrue(false);
        }catch(Throwable e){
            logger.error("Count not login to the application");
            Assert.fail("Assert failed as returned false");
        }

    }

}
