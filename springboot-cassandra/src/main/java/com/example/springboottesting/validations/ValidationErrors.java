package com.example.springboottesting.validations;

import com.example.springboottesting.model.ErrorAttributes;

import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ValidationErrors {

    private final Queue<ErrorAttributes> errors = new ConcurrentLinkedQueue<>();

    public Collection<ErrorAttributes> getErrors() {
        return Collections.unmodifiableCollection(errors);
    }

    public void addError(String field, String message) {
        ErrorAttributes attribute = new ErrorAttributes();
        attribute.setAttribute(field);
        attribute.setReason(message);
        this.errors.add(attribute);
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ValidationErrors:");
        sb.append(errors.toString());
        return sb.toString();
    }
}
