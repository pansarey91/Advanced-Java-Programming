<%@ page language="java" import="java.io.*" %>
<html>
<body>
    <center>
        <h3>
            <!-- Form to Accept File Extension -->
            <form method="get" action="">
                Enter File Extension: <input type="text" name="txt1" />
                <input type="submit" value="Search" />
            </form>
            
            <%
                String extension = request.getParameter("txt1");
                if (extension != null && !extension.isEmpty()) {
                    out.println("Entered File Extension = " + extension);

                    // Absolute path to the 'aaa' directory within Tomcat's webapps/examples
                    File dirs = new File(application.getRealPath("/") + "aaa");

                    if (dirs.exists() && dirs.isDirectory()) {
                        String[] files = dirs.list();
                        boolean fileFound = false;

                        // If no files are found in the directory
                        if (files == null || files.length == 0) {
                            out.println("<br>No files found in the 'aaa' directory.");
                        } else {
                            for (String file : files) {
                                if (file.endsWith("." + extension)) {
                                    fileFound = true;
                                    // Use relative path for links if serving through Tomcat
                                    out.println("<br><a href='examples/aaa/" + file + "'>" + file + "</a>");
                                }
                            }
                            // If no file with specified extension was found
                            if (!fileFound) {
                                out.println("<br>No files found with the extension: ." + extension);
                            }
                        }
                    } else {
                        out.println("<br>Directory 'aaa' does not exist.");
                    }
                } else if (extension != null) { // If the form was submitted but extension was empty
                    out.println("<br>Please enter a file extension.");
                }
            %>
        </h3>
    </center>
</body>
</html>
