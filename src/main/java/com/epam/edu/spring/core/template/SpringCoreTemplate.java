package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
		LinkedListItemRepository linkedListItemRepository = context.getBean("linkedListItemRepository", LinkedListItemRepository.class);

		//ArrayListItemRepository arrayListItemRepository = context.getBean("arrayListItemRepository", ArrayListItemRepository.class);

		/*Color color = context.getBean("color", Color.class);
		System.out.println(color.name());*/
		
	}

}
