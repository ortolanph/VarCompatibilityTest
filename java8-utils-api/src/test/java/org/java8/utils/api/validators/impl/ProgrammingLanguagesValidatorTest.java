package org.java8.utils.api.validators.impl;

import org.java7.api.entity.ProgrammingLanguage;
import org.java7.api.entity.Project;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProgrammingLanguagesValidatorTest {

    private final Set<ProgrammingLanguage> NO_PROGRAMMING_LANGUAGE = new HashSet<>();

    private final Set<ProgrammingLanguage> ONE_PROGRAMMING_LANGUAGE = new HashSet<>();

    private ProgrammingLanguagesValidator programmingLanguagesValidator = new ProgrammingLanguagesValidator();

    private TestProjectUtils utils = TestProjectUtils.getInstance();

    @Before
    public void setUp() throws Exception {
        ONE_PROGRAMMING_LANGUAGE.add(ProgrammingLanguage.JAVA);
    }

    @Test
    public void noDatabase() throws Exception {
        Project project = utils.projectWithProgrammingLanguage(NO_PROGRAMMING_LANGUAGE);
        assertFalse(programmingLanguagesValidator.validate(project));
    }

    @Test
    public void containsAtLeastOneDatabase() throws Exception {
        Project project = utils.projectWithProgrammingLanguage(ONE_PROGRAMMING_LANGUAGE);
        assertTrue(programmingLanguagesValidator.validate(project));
    }

}
