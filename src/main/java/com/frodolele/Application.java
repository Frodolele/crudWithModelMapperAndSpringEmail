package com.frodolele;

import lombok.val;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    public ModelMapper modelMapper() {
        val mapper = new ModelMapper();
        Configuration configuration = mapper.getConfiguration();
        configuration.setFieldAccessLevel(Configuration.AccessLevel.PUBLIC);
        configuration.setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR);
        configuration.setDestinationNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        configuration.setSourceNameTokenizer(NameTokenizers.CAMEL_CASE);
        configuration.setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
        configuration.setMatchingStrategy(MatchingStrategies.STANDARD);

        return mapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
