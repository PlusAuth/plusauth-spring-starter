package com.plusauth.starter.web.home;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("user", principal.getUserInfo());
        }
        return "index";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(Model model, @AuthenticationPrincipal OidcUser principal) {
        OidcUserInfo user = principal.getUserInfo();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode userJson = mapper.convertValue(user, JsonNode.class);

        model.addAttribute("user", user);
        model.addAttribute("userPrettified", userJson.toPrettyString());
        return "profile";
    }
}