package com.sample;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


import java.io.IOException;
import java.util.ArrayList;

@Path("/service")
public class SimpleRestService {

	UserDao userDao = new UserDao();
	   private static final String SUCCESS_RESULT="<result>success</result>";
	   private static final String FAILURE_RESULT="<result>failure</result>";

	  @GET
	   @Path("/drools")
	   @Produces(MediaType.APPLICATION_XML)
	 public ArrayList<User> drools(){
	    return userDao.getAllUsers();
	 }
	   
	  
	  
	   @GET
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	 public ArrayList<User> getUsers(){
	    return userDao.getAllUsers();
	 }

	@GET
	   @Path("/getIds")
	   @Produces(MediaType.TEXT_PLAIN)
	public String getSomething(@QueryParam("request") String request ,
			 @DefaultValue("1") @QueryParam("version") int version) {
		ArrayList<User> list = userDao.getAllUsers();
		String valor = "";
		for (User user:list)
		{
			valor += user.getId()+", ";
		}
        return valor;	
	}
	
	@GET
	   @Path("/userId")
	   @Produces(MediaType.APPLICATION_JSON)
	   public User getUser(@QueryParam("userid") int userid){
		 User user = userDao.getUser(userid);
	      return user;
	   }

	@GET
	@Path("/addUser")
    @Produces(MediaType.APPLICATION_XML)
	 public ArrayList<User> createUser(@QueryParam("id") int id,
			 @QueryParam("name") String name,
			 @QueryParam("profession") String profession) throws IOException
		  {
			  ArrayList<User> users = userDao.getAllUsers();
		      User user = new User(id, name, profession);
		      int result = userDao.addUser(user,users);
		      if(result == 1){
		    	  return users;
		         //return SUCCESS_RESULT;
		      }
		      
		      return users;
		      //return FAILURE_RESULT;*/
		  }
	
	 @GET
	 @Path("/deleteUser")
	 @Produces(MediaType.APPLICATION_XML)
	 public ArrayList<User> deleteUser(@QueryParam("userid") int userId)
	 {
		 ArrayList<User> users = userDao.getAllUsers();
		 int resultado = userDao.deleteUser(userId,users);
		 return users;
	 }
	 
	 @GET
	 @Path("/update")
	 @Produces(MediaType.APPLICATION_XML)
	 public ArrayList<User> update(@QueryParam("id") int id,
			 @QueryParam("name") String name,
			 @QueryParam("profession") String profession) throws IOException
	 {
		 ArrayList<User> users = userDao.getAllUsers();
		 User updateUser = new User(id, name, profession);
		 users = userDao.updateUser(updateUser,users);
		 return users;
	 }

	
}
