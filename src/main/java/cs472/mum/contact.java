package cs472.mum;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class contact extends HttpServlet {
    private int hitcounter;

    public void init() {
        // Reset hit counter
        hitcounter = 0;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String errorMessge = null;
        String name = request.getParameter("name");
        String gender = request.getParameter("sex");
        String category = request.getParameter("category");
        String message = request.getParameter("message");
        if (name.equals(""))
            errorMessge = "<p style= 'color: red;'>Name: Your Name is missing!!</p>";
        if (gender.equals(""))
            errorMessge += "<p style= 'color: red;'>Gender: Please Check your Gender!!</p>";
        if (category == null)
            errorMessge += "<p style= 'color: red;'>Category: Please Select your Category!!</p>";

        if (message.equals(""))
            errorMessge += "<p style= 'color: red;'>Message: Your Message is missing!!</p>";

        if (errorMessge != null) {
            PrintWriter out = response.getWriter();
            hitcounter++;
            out.print(generateContactForm(errorMessge, hitcounter));

        }
        else {
            WelcomeServlet welcome = new WelcomeServlet();
            welcome.doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hitcounter++;
        PrintWriter out = response.getWriter();
        out.print(generateContactForm("", hitcounter));
    }

    protected String generateContactForm(String error, int hitcounter) {

        return "<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>\n" +
                "    <script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>\n" +
                "    <script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>\n" +
                "    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<nav class='navbar navbar-expand-lg navbar-dark bg-primary'>\n" +
                "    <a class='navbar-brand' href='#'>CS472-WAP:::Lab11</a>\n" +
                "    <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>\n" +
                "        <span class='navbar-toggler-icon'></span>\n" +
                "    </button>\n" +
                "\n" +
                "    <div class='collapse navbar-collapse' id='navbarSupportedContent'>\n" +
                "        <ul class='navbar-nav mr-auto'>\n" +
                "            <li class='nav-item '>\n" +
                "                <a class='nav-link' href='index.jsp'>Home </a>\n" +
                "            </li>\n" +
                "            <li class='nav-item'>\n" +
                "                <a class='nav-link' href='#'>About</span></a>\n" +
                "            </li>\n" +
                "            <li class='nav-item active'>\n" +
                "                <a class='nav-link' href='#'>Contact Us <span class='sr-only'>(current)</span></a>\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "        <form class='form-inline my-2 my-lg-0'>\n" +
                "            <input class='form-control mr-sm-2' type='search' placeholder='Search' aria-label='Search'>\n" +
                "            <button class='btn btn-outline-success my-2 my-sm-0' type='submit'>Search</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</nav>\n" +
                "<div class='container' style='margin-top: 50px'>\n" +
                "    <h1> Customer Contact Form</h1>\n" +
                "<p>"+error +"<p>\n" +
                "    <form id= 'add' action='contact' method='post'>\n" +
                "        <div class='form-group'>\n" +
                "            <label for='exampleFormControlInput1'>*Name:</label>\n" +
                "            <input type='text' class='form-control' name='name' id='exampleFormControlInput1' placeholder='e.g. John Smith'>\n" +
                "            <span style='font-size: 8pt'>Enter your full name</span>\n" +
                "        </div>\n" +
                "        <label> *Gender: </label><br>\n" +
                "        <div class='form-check form-check-inline'>\n" +
                "            <input class='form-check-input' type='radio'   name='sex' id='inlineCheckbox1' value='Male'>\n" +
                "            <label class='form-check-label' for='inlineCheckbox1'>Male</label>\n" +
                "        </div>\n" +
                "        <div class='form-check form-check-inline'>\n" +
                "            <input class='form-check-input' type='radio' id='inlineCheckbox2' name='sex' value='Female'>\n" +
                "            <label class='form-check-label' for='inlineCheckbox2' >Female</label>\n" +
                "        </div>\n" +

                "        <div class='form-group'>\n" +
                "            <label for='exampleFormControlSelect1'>*Category:</label>\n" +
                "            <select class='form-control' name='category' id='exampleFormControlSelect1'>\n" +
                "                <option value='' disabled selected hidden>Select..</option>\n" +
                "                <option>FeedBack</option>\n" +
                "                <option>Inquiry</option>\n" +
                "                <option>Complaint</option>\n" +
                "\n" +
                "            </select>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='form-group'>\n" +
                "            <label for='exampleFormControlTextarea1'>*Message</label>\n" +
                "            <textarea class='form-control' id='exampleFormControlTextarea1' rows='3' name='message'></textarea>\n" +
                "        </div>\n" +
                "        <div class='form-group'>\n" +
                "            <button style='width: 100%' type='submit' class='btn btn-primary'>Submit</button>\n" +
                "        </div>\n" +
                "\n" +
                "    </form>\n" +
                "<p> Hit Count for this page: " + hitcounter + "<p>\n" +
                "<p s> Total Hit Count for the entire WebApp: "+ hitcounter + "<p>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }
}
