package org.java8.utils.api.validators.impl;

import org.java7.api.entity.ProgrammingLanguage;
import org.java8.utils.api.validators.Validator;

import java.util.Set;

public class LanguagesValidator implements Validator<Set<ProgrammingLanguage>> {

    @Override public boolean validate(Set<ProgrammingLanguage> programmingLanguages) {
        return programmingLanguages.size() > 0;
    }
}
