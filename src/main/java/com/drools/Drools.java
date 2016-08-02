package com.drools;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.KieResources;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class Drools {

	public static void main(String[] args) {
		 try {
	    	   KieServices kieServices = KieServices.Factory.get();
	    	    
	    	    KieFileSystem kfs = kieServices.newKieFileSystem();
	    	    KieResources kieResources = kieServices.getResources();
	    	    // KieRepository kieRepository = kieServices.getRepository();
	    	    
	    	    Resource resource = kieResources.newClassPathResource("Sample.drl");
	    	    // path has to start with src/main/resources
	    	    // append it with the package from the rule
	    	    kfs.write("src/main/resources/com/sample/Sample.drl", resource);
	    	    
	    	    KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();
	    	    Results results = kieBuilder.getResults();
	    	    
	    	    if( results.hasMessages( Message.Level.ERROR ) ){
	    	        System.out.println( results.getMessages() );
	    	        throw new IllegalStateException( "### errors ###" );
	    	    }
	    	    
	    	    KieContainer kieContainer = kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );
	    	    KieSession ksession = kieContainer.newKieSession();
	    	    

	            // go !
	            Message1 message1 = new Message1();
	            message1.setMessage("Hello World");
	            message1.setStatus(Message1.HELLO);
	            System.out.println("Antes: "+message1.getStatus());
	            ksession.insert(message1);
	            ksession.fireAllRules();
	            System.out.println("Despues "+message1.getStatus());
	            
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }

	}
	  public static class Message1 {

	        public static final int HELLO = 0;
	        public static final int GOODBYE = 1;

	        private String message;

	        private int status;

	        public String getMessage() {
	            return this.message;
	        }

	        public void setMessage(String message) {
	            this.message = message;
	        }

	        public int getStatus() {
	            return this.status;
	        }

	        public void setStatus(int status) {
	            this.status = status;
	        }

	    }

}
