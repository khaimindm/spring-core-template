package com.epam.edu.spring.core.template.factory;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.FactoryBean;

public class ColorFactory implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        return Color.RED;
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

}
