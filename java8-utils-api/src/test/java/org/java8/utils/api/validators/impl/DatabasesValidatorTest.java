package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Database;
import org.java7.api.entity.Project;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DatabasesValidatorTest {

    private final Set<Database> NO_DATABASE = new HashSet<>();

    private final Set<Database> ONE_DATABASE = new HashSet<>();

    private DatabasesValidator databasesValidator = new DatabasesValidator();

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    @Before
    public void setUp() throws Exception {
        ONE_DATABASE.add(Database.POSTGRESQL);
    }

    @Test
    public void noDatabase() throws Exception {
        Project project = utils.projectWithDatabase(NO_DATABASE);
        assertFalse(databasesValidator.validate(project));
    }

    @Test
    public void containsAtLeastOneDatabase() throws Exception {
        Project project = utils.projectWithDatabase(ONE_DATABASE);
        assertTrue(databasesValidator.validate(project));
    }

}
