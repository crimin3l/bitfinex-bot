package com.klein.btc.repository;

import com.vladmihalcea.hibernate.type.array.internal.ArraySqlTypeDescriptor;
import com.vladmihalcea.hibernate.type.array.internal.IntArrayTypeDescriptor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * Maps an {@code int[]} array on a PostgreSQL ARRAY type.
 * <p>
 * For more details about how to use it, check out <a href="https://vladmihalcea.com/2017/06/21/how-to-map-java-and-sql-arrays-with-jpa-and-hibernate/">this article</a> on <a href="https://vladmihalcea.com/">vladmihalcea.com</a>.
 *
 * @author Vlad Mihalcea
 */
public class FloatArrayType
        extends AbstractSingleColumnStandardBasicType<float[]>
        implements DynamicParameterizedType {

    public FloatArrayType() {
        super(ArraySqlTypeDescriptor.INSTANCE, FloatArrayTypeDescriptor.INSTANCE);
    }

    public String getName() {
        return "float-array";
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((FloatArrayTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}