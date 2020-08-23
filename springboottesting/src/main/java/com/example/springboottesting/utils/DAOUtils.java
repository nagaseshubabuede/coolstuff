package com.example.springboottesting.utils;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.util.StringUtils;

public class DAOUtils {

    /**
     * Instantiates a new DAO utils.
     */
    private DAOUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * To table name.
     * @param obj the obj
     * @return the string
     */
    public static String toTableName(Object obj) {
        return toTableName(obj.getClass());
    }

    /**
     * To table name.
     * @param type the type
     * @return the string
     */
    public static String toTableName(Class<?> type) {
        Table tableAnnotation = type.getAnnotation(Table.class);

        return (tableAnnotation != null && StringUtils.hasText(tableAnnotation.value())
                ? tableAnnotation.value()
                : type.getSimpleName());
    }

}
