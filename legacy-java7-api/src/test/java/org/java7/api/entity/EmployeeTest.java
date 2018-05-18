package org.java7.api.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void shouldCreateABoss() throws Exception {
        Employee boss = Employee.buildABoss(1, "Boss", 1234);
        assertTrue(boss.isBoss());
    }

    @Test
    public void shouldCreateAnEmployee() throws Exception {
        Employee boss = Employee.buildAnEmployee(1, "Subordinate", 1234);
        assertFalse(boss.isBoss());
    }

}
