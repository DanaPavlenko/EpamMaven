package ua.epam.dana.transformer;

import ua.epam.dana.model.annotation.*;
import java.lang.reflect.*;
import java.sql.ResultSet;
import java.sql.*;

public class Transformer<T> {
    private final Class<T> clazz;

    public Transformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Object fromResultSetToEntity(ResultSet rs)
            throws SQLException {
        //create new object
        Object entity = null;
        try {
            entity = clazz.getConstructor().newInstance();
            if (clazz.isAnnotationPresent(Table.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    // if field is annotated with @Column
                    if (field.isAnnotationPresent(Column.class)) {
                        Column column = (Column) field.getAnnotation(Column.class);
                        String name = column.name();
                        int length = column.length();
                        field.setAccessible(true);
                        Class fieldType = field.getType();
                        if (fieldType == String.class) {
                            field.set(entity, rs.getString(name));
                        } else if (fieldType == Integer.class) {
                            field.set(entity, rs.getInt(name));
                        } 
                    } 
                }
            }
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        } catch (NoSuchMethodException e) {
        }
        return entity;
    }
}

