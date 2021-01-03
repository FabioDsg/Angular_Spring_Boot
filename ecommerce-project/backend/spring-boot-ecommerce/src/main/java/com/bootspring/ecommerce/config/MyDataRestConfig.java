package com.bootspring.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.bootspring.ecommerce.entity.Product;
import com.bootspring.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		// Temporarily disabling these methods
		HttpMethod[] theUnsupportedActions =  {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		
		// Disable methods for Product: PUT, POST and DELETE.
		config.getExposureConfiguration()
				.forDomainType(Product.class)
				.withItemExposure((metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions) )
				.withCollectionExposure((metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions));
	
		// Disable methods for ProductCategory: PUT, POST and DELETE.
			config.getExposureConfiguration()
					.forDomainType(ProductCategory.class)
					.withItemExposure((metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions) )
					.withCollectionExposure((metadata, HttpMethods) -> HttpMethods.disable(theUnsupportedActions));
		}
	
	

}
