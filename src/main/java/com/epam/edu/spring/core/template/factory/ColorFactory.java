package com.epam.edu.spring.core.template.factory;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.FactoryBean;

public class ColorFactory implements FactoryBean<Color> {

    private Color color;



    @Override
    public Color getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

}
