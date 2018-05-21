package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Employee;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BossValidatorTest {

    private BossValidator bossValidator = new BossValidator();

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    @Test
    public void shouldBeABoss() throws Exception {
        Employee employee = utils.boss();
        assertTrue(bossValidator.validate(employee));
    }

    @Test
    public void shouldNotBeABoss() throws Exception {
        Employee employee = utils.employee();
        assertFalse(bossValidator.validate(employee));
    }

}
