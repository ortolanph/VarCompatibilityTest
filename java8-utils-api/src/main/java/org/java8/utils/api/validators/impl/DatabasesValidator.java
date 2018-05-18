package org.java8.utils.api.validators.impl;

import org.java7.api.entity.Database;
import org.java8.utils.api.validators.Validator;

import java.util.Set;

public class DatabasesValidator implements Validator<Set<Database>> {

    @Override public boolean validate(Set<Database> databases) {
        return databases.size() > 0;
    }
}
