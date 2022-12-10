package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.User;
import com.onlinestorewepr.util.CommonUtil;
import com.onlinestorewepr.util.MessageUtil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;

public class UserService {
    private UserDAO userDAO;
    private ServiceResult serviceResult;
    private MessageUtil message;

    HttpServletResponse resp;
    HttpServletRequest req;

    public UserService(HttpServletRequest req, HttpServletResponse resp)
    {
        this.req = req;
        this.resp = resp;
        this.message = new MessageUtil();
        userDAO = new UserDAO();
    }

    public User authenticate(String username, String password) {
        User user = userDAO.get(username);
        if (user != null && !user.isAdmin()) {
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    public boolean checkEmail(String email) {
        User user = userDAO.findUserByEmail(email);
        if (user != null) {
           return true;
        }
        return false;
    }

    public void userRegister() throws IOException,ServletException{
        String name = req.getParameter("fullName");
        String username = req.getParameter("usernameNew");
        String password = req.getParameter("passwordNew");
        String phone =req.getParameter("phone");
        String email =req.getParameter("email");
        String gender = req.getParameter("gender");
        String message = "";

        //Check user is in database?
        User userCreated = userDAO.findUserCreated(username);

        //Check enter
        if(name==null || phone == null ||username == null ||password == null || email == null || gender == null){
            if (Objects.equals(name, ""))
            {
                message ="Please enter full name!";
            }
            else if (Objects.equals(username, ""))
            {
                message ="Please enter username!";
            }
            else if (Objects.equals(phone, ""))
            {
                message ="Please enter phone number!";
            }
            else if (Objects.equals(email, ""))
            {
                message ="Please enter email!";
            }
            else if (Objects.equals(password, ""))
            {
                message ="Please enter password!";
            }
            else if (gender == null)
            {
                message = "Please choose gender!";
            }
            req.setAttribute("messageRegisterFail",message);
            req.setAttribute("action","signup");
            req.setAttribute("action", "signup");

            req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
        }

        // Check phone value
        boolean check = true;
        for (int i = 0; i < phone.length(); i++)
        {
            if ( !(phone.charAt(i) <= '9' && phone.charAt(i) >= '0' ) )
            {
                check = false;
                message = "Phone number is not valid! Please re-enter!";
                req.setAttribute("action","signup");
                req.setAttribute("messageRegisterFail",message);
                req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
            }
        }
        //Check Phone length
        if (check)
        {
            if (phone.length() != 10)
            {
                message = "Phone number length must be 10 numbers! Please re-enter!";
                req.setAttribute("action","signup");
                req.setAttribute("messageRegisterFail",message);
                req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
            }
        }
        //Check Email Valid?
        if(checkEmail(email)){
            message= "Email has been used to register! Please enter other email!";
            req.setAttribute("action","signup");
            req.setAttribute("messageRegisterFail",message);
            req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
        }
        // Check Password length
        if (password.length() < 8)
        {
            message = "Password must be at least 8 characters! Please re-enter!";
            req.setAttribute("action","signup");
            req.setAttribute("messageRegisterFail",message);
            req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
        }
        if (password.contains(name))
        {
            message = "Passwords cannot contain personal names! Please re-enter!";
            req.setAttribute("action","signup");
            req.setAttribute("messageRegisterFail",message);
            req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
        }

        //Check Password type
        boolean number = false, lowercase = false, uppercase = false, special = false;
        for (int i = 0; i < password.length(); i++)
        {
            char x = password.charAt(i);
            if (x <= '9' && x >= '0') number = true;
            else if (x <= 'z' && x >= 'a') lowercase = true;
            else if (x <= 'Z' && x >= 'A') uppercase = true;
            else special = true;
        }

        //Inform error on Form
        if (number == false || lowercase == false || uppercase == false || special == false)
        {
            if (number == false)
            {
                message = "Password must include numbers! Please re-enter!";
            }
            else if (lowercase == false)
            {
                message = "Password must include lowercase characters! Please re-enter!";
            }
            else if (uppercase == false)
            {
                message = "Password must include uppercase characters! Please re-enter!";
            }
            else if (special == false)
            {
                message = "Password must include special characters! Please re-enter!";
            }
            req.setAttribute("action","signup");
            req.setAttribute("messageRegisterFail",message);
            req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
        }
        //Check user is in database?
        else if(userCreated!=null){
            message= "This account has already existed!";
            req.setAttribute("action","signup");
            req.setAttribute("messageRegisterFail",message);
            req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
        }
        else {
            //Created User
            User userNew = new User();
            if(username != null){
                userNew.setUsername(username);
            }
            if(!password.equals("")){
                userNew.setPassword(password);
            }
            userNew.setName(name);
            userNew.setGender(gender);
            userNew.setPhone(phone);
            userNew.setEmail(email);
            userDAO.insert(userNew);

            //Inform success in form
            message= "Create success! Sign in to get started";
            req.setAttribute("action","signup");
            req.setAttribute("messageRegisterSuccess", message);
            req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
        }
    }

    protected  void saveRememberMe(HttpServletResponse response, String userName, String password){
        Cookie username = new Cookie("username",userName);
        Cookie pass = new Cookie("password",password);
        username.setMaxAge(60 * 60 * 24 * 365 * 3);
        pass.setMaxAge(60 * 60 * 24 * 365 * 3);
        response.addCookie(username);
        response.addCookie(pass);
        response.setContentType("text/html");
    }

    public void login() throws IOException, ServletException {
        //Get param from form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        String errMessage = "";
        boolean hasErr = false;

        //Check account in database
        User user = authenticate(username, password);
        boolean isRememberMe = "on".equals(remember);

        //Check enter
        if(username == null ||password==null || username.length()==0 || password.length()==0){
            hasErr= true;
            errMessage ="Username & Password cannot be empty!";
        }
        else {
            try{
                //Enter Wrong username/password
                if (user == null)
                {
                    hasErr = true;
                    errMessage ="Username & Password is not correct!";
                }
            }
            catch (Exception e){
                e.printStackTrace();
                hasErr = true;
                errMessage = e.getMessage();
            }
        }

        //Display status on web
        if(hasErr)
        {
            req.setAttribute("message",errMessage);
            req.getRequestDispatcher("/web/authentication.jsp").forward(req,resp);
        }
        else {
            //Create session when login is successful
            HttpSession session = req.getSession();
            session.setAttribute("userLogged",user);
            //Check Remember me to create Cookie
            if(isRememberMe)
            {
                saveRememberMe(resp,username,password);
            }
//            Object objRedirectURL = session.getAttribute("redirectURL");
            session.setMaxInactiveInterval(1000);
//            if (objRedirectURL != null) {
//                String redirectURL = (String) objRedirectURL;
//                session.removeAttribute("redirectURL");
//                resp.sendRedirect(redirectURL);
//            } else {
//                showProfile();
//            }
            resp.sendRedirect("/web");
        }
    }

    public void showProfile() throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/web/profile.jsp").forward(req,resp);
    }

    public void showEditUserProfile() throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/web/edit-profile.jsp").forward(req,resp);
    }

    public void editUserProfile(User user) throws ServletException, IOException {
        String fullName = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String gender = req.getParameter("sex");
        String address = req.getParameter("address");
        Part part = req.getPart("image");
        String messageBody, messageType = "";

//        String imageName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
//        String now = CommonUtil.getImgDir();
//        String realPath = req.getServletContext().getRealPath("/imagesAvt" + now);
//        Path path = Paths.get(realPath);
//        if (!Files.exists(path)) {
//            Files.createDirectories(path);
//        }
//        part.write(realPath + "/" + imageName);
//
//        String image = String.format("imagesAvt%s/%s", now, imageName);
//        user.setImage(image);
        user.setName(fullName);
       if(checkEmail(email)){
           messageBody = "Email has been used!";
           messageType = "danger";
           message.setBody(messageBody);
           message.setType(messageType);
           req.setAttribute("message", message);
           req.getRequestDispatcher("/web/edit_profile.jsp").forward(req, resp);
       }
       else {
           user.setEmail(email);
       }
        user.setPhone(phone);
        user.setGender(gender);
        user.setAddress(address);
    }
    public void updateUserProfile() throws ServletException, IOException{
        resp.setContentType("text/html;charset=UTF-8");
        User user = (User) req.getSession().getAttribute("userLogged");
        editUserProfile(user);
        userDAO.update(user);
        showProfile();
    }
    public void ShowEditUser()throws ServletException, IOException{
        String username = req.getParameter("username");
        if (username != null) {
            User account = userDAO.get(username);
            req.setAttribute("account", account);
            req.setAttribute("action", "edit");
            req.getRequestDispatcher("/admin/update-account.jsp").forward(req, resp);

        }
    }
//    public void EditUser()throws ServletException, IOException{
//        String username = req.getParameter("username") ;
//        User user = userDAO.get(username);
//        DiskFileItemFactory diskFileItemFactory = new
//                DiskFileItemFactory();
//        ServletFileUpload servletFileUpload = new
//                ServletFileUpload(diskFileItemFactory);
//        servletFileUpload.setHeaderEncoding("UTF-8");
//        try {
//            resp.setContentType("text/html");
//            req.setCharacterEncoding("UTF-8");
//            List<FileItem> items = servletFileUpload.parseRequest(req);
//            for (FileItem item : items) {
//                if (item.getFieldName().equals("account-phone")) {
//                    user.setPhone(item.getString("UTF-8"));
//                }
//                if (item.getFieldName().equals("account-fullname")) {
//                    user.setName(item.getString("UTF-8"));
//                }
//                if (item.getFieldName().equals("account-address")) {
//                    user.setAddress(item.getString("UTF-8"));
//                }
//                if (item.getFieldName().equals("account-gender")) {
//                    user.setGender(item.getString("UTF-8"));
//                }
//            }
//            userDAO.update(user );
//            resp.sendRedirect(req.getContextPath() + "/admin/accounts");
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void changeUserPassword() throws ServletException,IOException{
        String username = req.getParameter("username");
        String oldPass = req.getParameter("password-old");
        String newPass = req.getParameter("password-new");
        String passRetype = req.getParameter("password-retype");
        int len = newPass.length();

        User user = authenticate(username,oldPass);
        String messageBody = "", messageType = "";

        if(oldPass == null || newPass == null || passRetype == null)
        {
            messageBody = "Please enter information!";
            messageType = "danger";
        }
        else if(user == null){
            messageBody = "Old password is incorrect, please re-enter!";
            messageType = "danger";
        }
        else if(!newPass.equals("")){
            boolean number = false, lowercase = false, uppercase = false, special = false;
            for (int i = 0; i < newPass.length(); i++)
            {
                char x = newPass.charAt(i);
                if (x <= '9' && x >= '0') number = true;
                else if (x <= 'z' && x >= 'a') lowercase = true;
                else if (x <= 'Z' && x >= 'A') uppercase = true;
                else special = true;
            }
            //Inform error on Form
            if (!number || !lowercase|| !uppercase || !special)
            {
                if (!number)
                {
                    messageBody = "Password must include numbers! Please re-enter!";
                    messageType = "danger";

                }
                else if (!lowercase)
                {
                    messageBody = "Password must include lowercase characters! Please re-enter!";
                    messageType = "danger";
                }
                else if (!uppercase)
                {
                    messageBody = "Password must include uppercase characters! Please re-enter!";
                    messageType = "danger";
                }
                else
                {
                    messageBody = "Password must include special characters! Please re-enter!";
                    messageType = "danger";
                }
            }
            else {
                if(Objects.equals(oldPass, newPass)){
                    messageBody = "The new password cannot be the same as the old password!";
                    messageType = "danger";
                } else if (len < 8) {
                    messageBody = "The new password must be more than 8 characters!";
                    messageType = "danger";
                } else if (!Objects.equals(newPass, passRetype)){
                    messageBody = "Password re-entered is incorrect!";
                    messageType = "danger";
                }
                else {
                    resp.setContentType("text/html;charset=UTF-8");
                    User usernew = (User) req.getSession().getAttribute("userLogged");
                    usernew.setPassword(newPass);
                    userDAO.update(usernew);
                    messageBody = "Successful change!";
                    messageType = "success";
                    req.getRequestDispatcher("/web/authentication.jsp").forward(req, resp);
                }
            }
        }
        message.setBody(messageBody);
        message.setType(messageType);
        req.setAttribute("message", message);
        req.getRequestDispatcher("/web/change_pass.jsp").forward(req, resp);
    }

    public void sendEmail() throws ServletException,IOException{
        String email = req.getParameter("email");
        String messageBody,messageType;
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = req.getSession();
        User user = userDAO.findUserByEmail(email);
        if(email!=null && user!=null) {
            // sending otp
            Random rand = new Random();
            otpvalue = rand.nextInt(1255650);

            String to = email;// change accordingly
            // Get the session object
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("phand613@gmail.com", "hrlzgsmcfrormdbb");
                }
            });
            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Forgot password");
                message.setText("Your OTP is: " + otpvalue);
                // send message
                Transport.send(message);
            }

            catch (MessagingException e) {
                e.printStackTrace();
            }
            dispatcher = req.getRequestDispatcher("EnterOtp.jsp");
            req.setAttribute("message","OTP is sent to your email.Please check!");
            //request.setAttribute("connection", con);
            mySession.setAttribute("otp",otpvalue);
            mySession.setAttribute("email",email);
            dispatcher.forward(req, resp);
            //request.setAttribute("status", "success");
        }
        else {
            messageBody = "Email does not register before!";
            messageType = "danger";
            message.setBody(messageBody);
            message.setType(messageType);
            req.setAttribute("message", message);
            req.getRequestDispatcher("/web/forgetpass.jsp").forward(req, resp);
        }
    }

    public void changePassForgot() throws ServletException,IOException{
        HttpSession session = req.getSession();
        String newPassword = req.getParameter("password");
        String confPassword = req.getParameter("confPassword");
        RequestDispatcher dispatcher = null;
        String userEmail = (String) session.getAttribute("email");
        String message;

        User user = userDAO.findUserByEmail(userEmail);

        if (newPassword == null || confPassword == null){
            message = "Please enter password!";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/web/newPassword.jsp").forward(req, resp);
        }
        else {
            boolean number = false, lowercase = false, uppercase = false, special = false;
            for (int i = 0; i < newPassword.length(); i++)
            {
                char x = newPassword.charAt(i);
                if (x <= '9' && x >= '0') number = true;
                else if (x <= 'z' && x >= 'a') lowercase = true;
                else if (x <= 'Z' && x >= 'A') uppercase = true;
                else special = true;
            }
            //Inform error on Form
            if (!number || !lowercase|| !uppercase || !special)
            {
                if (!number)
                {
                    message = "Password must include numbers! Please re-enter!";
                }
                else if (!lowercase)
                {
                    message = "Password must include lowercase characters! Please re-enter!";
                }
                else if (!uppercase)
                {
                    message = "Password must include uppercase characters! Please re-enter!";
                }
                else
                {
                    message = "Password must include special characters! Please re-enter!";
                }
                req.setAttribute("message", message);
                req.getRequestDispatcher("/web/newPassword.jsp").forward(req, resp);
            }
            else {
                int len = newPassword.length();
                if (len < 8) {
                    message = "The new password must be more than 8 characters!";
                } else if (!Objects.equals(newPassword, confPassword)){
                    message = "Password re-entered is incorrect!";
                }
                else {
                    resp.setContentType("text/html;charset=UTF-8");
                    user.setPassword(newPassword);
                    userDAO.update(user);
                    message = "Successful change";
                }
                req.setAttribute("message", message);
                req.getRequestDispatcher("/web/newPassword.jsp").forward(req, resp);
            }
        }
    }

    public void validateOTP() throws ServletException, IOException {
        RequestDispatcher dispatcher=null;
        String optGet = req.getParameter("otp");
        for (int i = 0; i < optGet.length(); i++)
        {
            if ( !(optGet.charAt(i) <= '9' && optGet.charAt(i) >= '0' ) )
            {
                req.setAttribute("message","Please enter number!");
                req.getRequestDispatcher("EnterOtp.jsp").forward(req, resp);
            }
        }
        int value = Integer.parseInt(req.getParameter("otp"));
        HttpSession session = req.getSession();
        int otp =(int)session.getAttribute("otp");

        if (value == otp)
        {
            req.setAttribute("email", req.getParameter("email"));
            req.setAttribute("status", "success");
            dispatcher=req.getRequestDispatcher("newPassword.jsp");
            dispatcher.forward(req, resp);
        }
        else
        {
            req.setAttribute("message","Wrong OTP. Please enter again!");
            dispatcher=req.getRequestDispatcher("EnterOtp.jsp");
            dispatcher.forward(req, resp);
        }
    }
    public void updateService() throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        User user = userDAO.get(username);
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        userDAO.update(user);
        //
    }
    public void listAll() throws ServletException, IOException {
        List<User> userList = userDAO.getAll();
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }
    public void getUser(String username) throws ServletException, IOException {
        User user = userDAO.get(username);
        req.setAttribute("user", user);
        req.getRequestDispatcher("update-account.jsp").forward(req, resp);
    }
}
