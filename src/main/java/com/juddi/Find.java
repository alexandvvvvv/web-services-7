package com.juddi;

import com.company.CoffeeService;
import com.company.CoffeeWebService;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.mapping.ServiceLocator;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessService;

import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.Map;

public class Find {

	public static void FindAndCall () {
		find();
		call();
	}

	public static void find() {
		try {
			UDDIClient uddiClient = new UDDIClient("META-INF/wsdl2uddi-uddi.xml");
			UDDIClerk clerk = uddiClient.getClerk("joe");
        	
        	BusinessEntity businessEntity = clerk.findBusiness("uddi:uddi.joepublisher.com:business-for-wsdl");
        	//
        	if (businessEntity!=null) {
	        	System.out.println("Found business with name " + businessEntity.getName().get(0).getValue());
	        	if (businessEntity.getBusinessServices() !=null) {
		        	System.out.println("Number of services: " + businessEntity.getBusinessServices().getBusinessService().size());
		        	
		        	for (BusinessService businessService: businessEntity.getBusinessServices().getBusinessService()) {
		        		System.out.println("Service Name        = '" + businessService.getName().get(0).getValue() + "'");
		        		System.out.println("Service Key         = '" + businessService.getServiceKey() + "'");
		        		System.out.println("Service Description = '" + businessService.getDescription().get(0).getValue() + "'");
		        		System.out.println("BindingTemplates: " + businessService.getBindingTemplates().getBindingTemplate().size());
		        		
		        		for (int i=0; i<businessService.getBindingTemplates().getBindingTemplate().size(); i++) {
		    				BindingTemplate bindingTemplate = businessService.getBindingTemplates().getBindingTemplate().get(i);
		    				System.out.println("--BindingTemplate" + " " + i + ":");
		    				System.out.println("  bindingKey          = " + bindingTemplate.getBindingKey());
		    				System.out.println("  accessPoint useType = " + bindingTemplate.getAccessPoint().getUseType());
		    				System.out.println("  accessPoint value   = " + bindingTemplate.getAccessPoint().getValue());
		    				System.out.println("  description         = " + bindingTemplate.getDescription().get(0).getValue());
		        		}
		        	}
	        	}
        	}
	        		
        	businessEntity.getBusinessServices();
        	
        	//TODO JUDDI-610
			//FindTModel findBindingTModel = WSDL2UDDI.createFindBindingTModelForPortType(portType, namespace);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void call() {
		try {
			UDDIClient uddiClient = new UDDIClient("META-INF/wsdl2uddi-uddi.xml");
			UDDIClerk clerk = uddiClient.getClerk("joe");

			//find the service in the UDDI registry
			System.out.println("The clientside of a runtime lookup usually knows the serviceKey.");
			System.out.println("To get updated binding information you should use the ServiceLocator with a live cache.");
			String helloWorldServiceKey = "uddi:uddi.joepublisher.com:service_helloworld";

			long startTime = System.currentTimeMillis();
			ServiceLocator serviceLocator = new ServiceLocator(clerk);
			System.out.println("Created Cache in " + (System.currentTimeMillis() - startTime) + " [milliseconds]");
			System.out.println("Now adding a listener to the cache..."); //expensive
			startTime = System.currentTimeMillis();
			serviceLocator.withLiveCache(new URL("http://localhost:18079"));
			System.out.println("Add Listener to Cache in " + (System.currentTimeMillis() - startTime) + " [milliseconds]");

			//first time the lookup will have to contact UDDI
			startTime = System.currentTimeMillis();
			String endpoint = serviceLocator.lookupEndpoint(helloWorldServiceKey);
			long duration = System.currentTimeMillis() - startTime;
			System.out.println("1. UDDI Lookup - Elapsed time: " + duration + "[milliseconds] Endpoint=" + endpoint);

			//second lookup should be lightning fast
			long startTime2 = System.currentTimeMillis();;
			String endpoint2 = serviceLocator.lookupEndpoint(helloWorldServiceKey);
			long duration2 = System.currentTimeMillis() - startTime2;
			System.out.println("2. Cache Lookup - Elapsed time: " + duration2 + "[milliseconds] Endpoint=" + endpoint2);

			//Invoke the endpoint using 'endpoint2'
			CoffeeService helloWorldService = new CoffeeService();
			CoffeeWebService helloWorld = helloWorldService.getCoffeeWebServicePort();
			Map<String, Object> requestContext = ((BindingProvider) helloWorld).getRequestContext();
			requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint2);
			String reply = helloWorld.getCoffees().toString();
			System.out.println("*************** Service reply: " + reply);
			//need to call shutdown to take down the LiveCache Callback Endpoint.
			Thread.sleep(10l);
			serviceLocator.shutdown();
			//TODO JUDDI-610
			//FindTModel findBindingTModel = WSDL2UDDI.createFindBindingTModelForPortType(portType, namespace);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}