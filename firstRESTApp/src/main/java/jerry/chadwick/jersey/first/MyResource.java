
package jerry.chadwick.jersey.first;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.enunciate.jaxrs.TypeHint;
import com.sun.jersey.api.Responses;


/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource/teams")
public class MyResource {

    public static List<String> myList;


    private static MyResource instance;
    private static final int iStringSize = 80;

    private static List<MyResourceObject> myResourceObjectList = null;
    private static List<MyCoachObject> myCoachesObjectList = null;


    // Main is only used for Java Apprentice class tasks and not part of the service.
    public static void main(String [] args) throws Exception {
//        long iUsedMemory = 5;

        if (instance == null)
            instance = new MyResource();
    }

// *******************************

    public static MyResource getInstance() {

        if (instance == null)
            instance = new MyResource();

        if (myList == null) {
            myList = new ArrayList<String>();

            // Read the list of resource strings from a file
            Charset charset = Charset.forName("US-ASCII");
            String file = "bbtourneywinners.txt";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line = null;
                while ((line = reader.readLine()) != null) {
                    instance.myList.add(line);
                }

            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
        }
        // Create the Resource List from the strings read in from the file
        if (myResourceObjectList == null)
            myResourceObjectList = new ArrayList<MyResourceObject>();
        if (myResourceObjectList.size()==0) {
            int iCount = 0;
            for (String s : instance.myList) {
                myResourceObjectList.add(new MyResourceObject(iCount++, s));
            }
        }
        // Create the Resource List from the strings read in from the file
        if (myCoachesObjectList == null)
            myCoachesObjectList = new ArrayList<MyCoachObject>();
        if (myCoachesObjectList.size()==0) {
                myCoachesObjectList.add(new MyCoachObject(0, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(1, "Adolph", "Rupp", 876));
                myCoachesObjectList.add(new MyCoachObject(2, "Dean", "Smith", 879));
                myCoachesObjectList.add(new MyCoachObject(3, "Bob", "Knight", 662));
                myCoachesObjectList.add(new MyCoachObject(4, "Mike", "Krzyzewski", 983));
                myCoachesObjectList.add(new MyCoachObject(5, "Rick", "Pitino", 341));
                myCoachesObjectList.add(new MyCoachObject(6, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(7, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(8, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(9, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(10, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(11, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(12, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(13, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(14, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(15, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(16, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(17, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(18, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(19, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(20, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(21, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(22, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(23, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(24, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(25, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(26, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(27, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(28, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(29, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(30, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(31, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(32, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(33, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(34, "John", "Wooden", 620));
                myCoachesObjectList.add(new MyCoachObject(35, "John", "Wooden", 620));
        }

        return instance;
    }

    @GET
    @Produces("text/html")
    public Response discovery() {
        String retVal =
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head lang=\"en\">" +
                        "    <meta charset=\"UTF-8\">" +
                        "    <title>Jerry's First REST Application</title>" +
                        "    <script src=\"https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js?skin=sunburst\"></script>" +
                        "</head>" +
                        "<!-- <body onload=\"prettyPrint()\"> -->" +
                        "<body>" +
                        "<p><h1>app-meta</h1></p>" +
                        "<p>You've made a successful request for the \"app-meta\" resource on the Jerry\'s First REST Application platform. + In case you\"re wondering why you didn't get back XML or JSON, it's probably because you're using a browser and browsers tend to ask for HTML before XML or JSON." +
                "" +
                "    But it's kinda convenient that the links below are clickable, don't you think?</p>" +
                "<!-- <pre class=\"prettyprint\"> -->" +
                "    <pre>" +
                "<br>";

        Integer iIndex = new Integer(0);

        for (int i = 0; i < getInstance().myResourceObjectList.size(); i++) {
            iIndex = i;
            retVal += "<a href=\"localhost:8080/firstRESTApp/myresource/" + iIndex.toString() + "\">localhost:8080/firstRESTApp/myresource/" + iIndex.toString() + "</a>" + "<br>";
        }
        retVal += "</list>" +
                "  </pre>" +
                "</body>" +
                "</html>";
        String eTag = String.valueOf(Response.status(200).hashCode());
        return Response.status(Response.Status.OK).tag(eTag).entity(retVal).build();
    }


    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET
    @Path("{id}")
    @Produces("text/plain")
    public Response getPlainTextParam(@PathParam("id") String id) {
        if (id != null) {
            Integer iIndex = new Integer(0);
            try {
                iIndex = Integer.parseInt(id);
                if (iIndex >= getInstance().myList.size()) {
                    String sErrText = "Path parameter: " + iIndex + " must be less than the length of the list of items, which is " + ((Integer) (getInstance().myList.size()-1)).toString();
                    return Response.status(Response.Status.NOT_FOUND).entity(sErrText).build();
                }
            }

            catch (NumberFormatException exc) {
                String sErrText = "Path parameter must be must be an integer number.";
                return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

            }
            catch (IndexOutOfBoundsException exc) {
                String sErrText = "Index must be between 0 and " + ((Integer) getInstance().myList.size()).toString();
                return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

            }
            String eTag = String.valueOf(Response.status(200).hashCode());
            String retVal = "Item number " + iIndex.toString() + " : " + getInstance().myList.get(iIndex.intValue()).toString();
            return Response.status(Response.Status.OK).tag(eTag).entity(retVal).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid id").build();
        }
    }

    // This method is called if JSON is request and a param is NOT passed
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJSONAllItems() {


        String retVal = new String();

        ObjectMapper mapper = new ObjectMapper();
        try {
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            JsonGenerator jsonGenerator=new JsonFactory().createJsonGenerator(out,JsonEncoding.UTF8);

            mapper.writeValue(jsonGenerator,getInstance().myResourceObjectList );
            retVal = out.toString();

        } catch (JsonGenerationException e) {
            String sErrText = "JSON Generation Error";
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();
        } catch (JsonMappingException e) {
            String sErrText = "JSON Mapping Error";
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();
        } catch (IOException e) {
            String sErrText = "I/O Error";
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();
        }
        String eTag = String.valueOf(Response.status(200).hashCode());
        return Response.status(Response.Status.OK).tag(eTag).entity(retVal).build();

    }

    // This method is called if XML is request and a param is NOT passed
    @GET
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_ATOM_XML})
    public Response getXMLAllItems(@PathParam("id") String id) {
        String retVal = new String();
        retVal ="<hello> " +
                "<title>Jerry's First REST Application" + "</title>" +
                "<list>";
        Integer iIndex = new Integer(0);

        for (int i = 0; i < getInstance().myResourceObjectList.size(); i++) {
            iIndex = i;
            retVal += "<item itemID=\"" + getInstance().myResourceObjectList.get(i).itemID + "\">localhost:8080/firstRESTApp/myresource/" + iIndex.toString() + "</item>";
        }

        retVal += "</list>" +
                "</hello>";
        String eTag = String.valueOf(Response.status(200).hashCode());
        return Response.status(Response.Status.OK).tag(eTag).entity(retVal).build();

    }


    // This method is called if XML or JSON is requested and an id is passed
    @GET
    @Path("{id}")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
    public Response getXMLItem(@PathParam("id") String id) {

        Integer iIndex = new Integer(0);

        try {
            iIndex = Integer.parseInt(id);
            if (iIndex >= getInstance().myList.size()) {
                String sErrText = "Path parameter: " + iIndex + " must be less than the length of the list of items, which is " + ((Integer) (getInstance().myList.size()-1)).toString();
                return Response.status(Response.Status.NOT_FOUND).entity(sErrText).build();
            }
        }

        catch (NumberFormatException exc) {
            String sErrText = "Path parameter must be must be an integer number.";
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        catch (IndexOutOfBoundsException exc) {
            String sErrText = "Index must be between 0 and " + ((Integer) getInstance().myList.size()).toString();
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        String eTag = String.valueOf(Response.status(200).hashCode());
        return Response.status(Response.Status.OK).tag(eTag).entity((getInstance().myResourceObjectList.get(iIndex.intValue()))).build();

    }

    // This method is called if XML or JSON is requested and an id is passed
    @GET
    @Path("{id}/coaches")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    @TypeHint(MyCoachObject.class)
    public Response getXMLCoachsItem(@PathParam("id") String id) {

        Integer iIndex = new Integer(0);

        try {
            iIndex = Integer.parseInt(id);
            if (iIndex >= getInstance().myList.size()) {
                String sErrText = "Path parameter: " + iIndex + " must be less than the length of the list of items, which is " + ((Integer) (getInstance().myList.size()-1)).toString();
                return Response.status(Response.Status.NOT_FOUND).entity(sErrText).build();
            }
        }

        catch (NumberFormatException exc) {
            String sErrText = "Path parameter must be must be an integer number.";
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        catch (IndexOutOfBoundsException exc) {
            String sErrText = "Index must be between 0 and " + ((Integer) getInstance().myList.size()).toString();
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        String eTag = String.valueOf(Response.status(200).hashCode());
        return Response.status(Response.Status.OK).tag(eTag).entity((getInstance().myCoachesObjectList.get(iIndex.intValue()))).build();

    }



    // This method is called if HTML is request and an id is passed
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public Response getHTMLItem(@PathParam("id")String id) {
        Integer iIndex = new Integer(0);
        try {
            iIndex = Integer.parseInt(id);
            if (iIndex >= getInstance().myList.size()) {
                String sErrText = "Path parameter: " + iIndex + " must be less than the length of the list of items, which is " + ((Integer) (getInstance().myList.size()-1)).toString();
                return Response.status(Response.Status.NOT_FOUND).entity(sErrText).build();
            }
        }

        catch (NumberFormatException exc) {
            String sErrText = "Path parameter must be must be an integer number.";
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        catch (IndexOutOfBoundsException exc) {
            String sErrText = "Index must be between 0 and " + ((Integer) getInstance().myList.size()).toString();
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        String retVal =  "<html> " + "<title>" + "Jerry's First REST Application" + "</title>"
                + "<body><h1>" + getInstance().myList.get(iIndex.intValue()).toString() + "</h1></body>" + "</html> ";
        String eTag = String.valueOf(Response.status(200).hashCode());
        return Response.status(Response.Status.OK).tag(eTag).entity(retVal).build();
    }



}
