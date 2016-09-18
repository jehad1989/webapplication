
package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import static javax.ws.rs.HttpMethod.POST;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;
import java.math.*;
import org.json.JSONArray;
/**
 * REST Web Service
 *
 * @author nvidia
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of service.GenericResource
     * @return an instance of java.lang.String
     */
    String Content=" ";
    double root,root1,root2;
    String solution=" ";
    @POST
   
    @Produces("application/json")
    //@Produces({MediaType.APPLICATION_JSON})
    public String getJson(String jsonObject) throws JSONException 
    {
              String[]e=jsonObject.split("&");
        String[]ee=e[1].split("=");
        String[]ee2=e[2].split("=");
        String[]ee3=e[3].split("=");
        int a=Integer.valueOf(ee[1]);
                int b= Integer.valueOf(ee2[1]);
                        int c=Integer.valueOf(ee3[1]);
                        
                        double k=Math.sqrt((Math.pow(b, 2)) - (4*a*c));
        if (k == 0)
{
   root=(-b)/(2*a);
   solution="the solution is "+root;
   //return String.valueOf(root);
} 
        if(k>0)
        {
    root1 = (-b + k) / (2*a);
    root2 = (-b - k) / (2*a);
     solution="first solution is "+root1+" the second solution is "+root2;
    //return String.valueOf("first solution is "+root1+" the second solution is "+root2);
        
        }
        else
        solution=" No possible solution";
        
                return "<html><body>"+solution+"</body></html>";
    }/*
    
    */
        
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) throws JSONException 
    {
 JSONObject json = new JSONObject();
 JSONArray array=new JSONArray();
    
    array.put(solution);
    json.put("p", array);
     Content=solution;

    }
}
