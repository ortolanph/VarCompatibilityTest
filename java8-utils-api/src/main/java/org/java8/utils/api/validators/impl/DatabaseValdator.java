package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Database;
import org.java8.utils.api.validators.Validator;

import java.util.Set;

public class DatabaseValdator implements Validator<Set<Database>> {

    @Override public boolean validate(Set<Database> databases) {
        return false;
    }
}
