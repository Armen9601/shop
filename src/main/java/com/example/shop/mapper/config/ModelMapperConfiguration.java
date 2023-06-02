package com.example.shop.mapper.config;

import com.example.shop.dto.ProductDto;
import com.example.shop.entity.Product;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setFieldMatchingEnabled(true)
        .setSkipNullEnabled(true)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
    Converter<Double, Double> nullDoubleConverter = context -> {
      Double sourceValue = context.getSource();
      Double destinationValue = context.getDestination();
      return sourceValue != null ? sourceValue : destinationValue;
    };
    Converter<Integer, Integer> nullIntegerConverter = context -> {
      Integer sourceValue = context.getSource();
      Integer destinationValue = context.getDestination();
      return sourceValue != null ? sourceValue : destinationValue;
    };

    // Add the custom converters for double and int fields
    PropertyMap<ProductDto, Product> productMap = new PropertyMap<>() {
      protected void configure() {
        using(nullDoubleConverter).map(source.getPrice()).setPrice(null);
        using(nullIntegerConverter).map(source.getCount()).setCount(null);
      }
    };
    mapper.addMappings(productMap);
    return mapper;
  }
}
