package com.dreamteam.avengor.controller;


import com.dreamteam.avengor.database.Db;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginPost (HttpServletRequest request) {

        //POST QUERY & DB CALL
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");

        if(mail == null || password == null) {
            return "redirect:login?error=empty";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String successLogin = Db.login(mail);



        if(!encoder.matches(password, successLogin)) {
            return "redirect:login?error=accountnotfound";
        }

        //WEB SECURITY
        List<GrantedAuthority> privilege = new ArrayList<GrantedAuthority>();
        privilege.add(new SimpleGrantedAuthority("USER"));

        UserDetails user = new User(mail, successLogin, privilege);

        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, privilege);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return "redirect:civil";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }

}
