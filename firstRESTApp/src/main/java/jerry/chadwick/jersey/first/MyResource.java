
package jerry.chadwick.jersey.first;

// import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.util.List;
import javax.ws.rs.Path;
import java.nio.*;


/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {

    public static List<String> myList;


    private static MyResource instance;
    private static final int iStringSize = 80;

    private static List<MyResourceObject> myResourceObjectList = null;


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
//                String  current = new java.io.File( "." ).getCanonicalPath();
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
        return Response.status(Response.Status.OK).entity(retVal).build();
    }


    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET
    @Path("{id}")
    @Produces("text/plain")
    public Response getQueryParam(@PathParam("id") String id) {
        if (id != null) {
            Integer iIndex = new Integer(0);
            try {
                iIndex = Integer.parseInt(id);
                if (iIndex >= getInstance().myList.size()) {
                    String sErrText = "Query parameter: " + iIndex + " must be less than the length of the list of items, which is " + ((Integer) (getInstance().myList.size()-1)).toString();
                    return Response.status(Response.Status.NOT_FOUND).entity(sErrText).build();
                }
            }

            catch (NumberFormatException exc) {
                String sErrText = "Query parameter must be must be an integer number.";
                return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

            }
            catch (IndexOutOfBoundsException exc) {
                String sErrText = "Index must be between 0 and " + ((Integer) getInstance().myList.size()).toString();
                return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

            }
            String retVal = "Item number " + iIndex.toString() + " : " + getInstance().myList.get(iIndex.intValue()).toString();
            return Response.status(Response.Status.OK).entity(retVal).build();
        }
        else {
            return Response.status(Response.Status.OK).entity("Okay").build();
        }
    }

    // This method is called if XML is request and a param is passed
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_XML)
    public Response getXMLItem(@PathParam("id") String id) {
//    public Response getXMLItem(@QueryParam("indVar")String strParam) {

        Integer iIndex = new Integer(0);

        try {
            iIndex = Integer.parseInt(id);
            if (iIndex >= getInstance().myList.size()) {
                String sErrText = "Query parameter: " + iIndex + " must be less than the length of the list of items, which is " + ((Integer) (getInstance().myList.size()-1)).toString();
                return Response.status(Response.Status.NOT_FOUND).entity(sErrText).build();
            }
        }

        catch (NumberFormatException exc) {
            String sErrText = "Query parameter must be must be an integer number.";
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        catch (IndexOutOfBoundsException exc) {
            String sErrText = "Index must be between 0 and " + ((Integer) getInstance().myList.size()).toString();
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }

        String retVal = "<hello>" +
                "<title>Jerry's First REST Application</title>" +
                "<list>" +
                "<itemID>" +
                ((Integer)getInstance().myResourceObjectList.get(iIndex.intValue()).itemID).toString() +
                "</itemID>" +
                "<itemName>" +
                getInstance().myResourceObjectList.get(iIndex.intValue()).itemName.toString() +
                "</itemName>" +
                "<school>" +
                getInstance().myResourceObjectList.get(iIndex.intValue()).schoolName.toString() +
                "</school>" +
                "<numwins>" +
                ((Integer)getInstance().myResourceObjectList.get(iIndex.intValue()).numWins).toString() +
                "</numwins>" +
                "<winlist>";

                String sWins = "";
                int i = 0;
                for (Object s : (getInstance().myResourceObjectList.get(iIndex.intValue())).winYears) {
                    sWins += "<winyear>" + s.toString() + "</winyear>";
                }
        retVal += sWins +
                "</winlist>" +
                "</list>" +
                "</hello>";
        return Response.status(Response.Status.OK).entity(retVal).build();
        //return Response.ok(retVal, MediaType.TEXT_XML).build();
    }

    // This method is called if XML is request and a param is NOT passed
    @GET
    @Produces(MediaType.TEXT_XML)
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

/*
        for (int i = 0; i < getInstance().myResourceObjectList.size(); i++) {
            retVal += "<item>" + getInstance().myResourceObjectList.get(i).itemFullString + "</item>";
        }
*/
        retVal += "</list>" +
                "</hello>";

        return Response.status(Response.Status.OK).entity(retVal).build();
        //return Response.ok(retVal, MediaType.TEXT_XML).build();
    }

    // This method is called if HTML is request
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public Response getHTMLItem(@PathParam("id")String id) {
        Integer iIndex = new Integer(0);
        try {
            iIndex = Integer.parseInt(id);
            if (iIndex >= getInstance().myList.size()) {
                String sErrText = "Query parameter: " + iIndex + " must be less than the length of the list of items, which is " + ((Integer) (getInstance().myList.size()-1)).toString();
                return Response.status(Response.Status.NOT_FOUND).entity(sErrText).build();
            }
        }

        catch (NumberFormatException exc) {
            String sErrText = "Query parameter must be must be an integer number.";
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        catch (IndexOutOfBoundsException exc) {
            String sErrText = "Index must be between 0 and " + ((Integer) getInstance().myList.size()).toString();
            return Response.status(Response.Status.BAD_REQUEST).entity(sErrText).build();

        }
        String retVal =  "<html> " + "<title>" + "Jerry's First REST Application" + "</title>"
                + "<body><h1>" + getInstance().myList.get(iIndex.intValue()).toString() + "</h1></body>" + "</html> ";
        return Response.status(Response.Status.OK).entity(retVal).build();
    }

}
