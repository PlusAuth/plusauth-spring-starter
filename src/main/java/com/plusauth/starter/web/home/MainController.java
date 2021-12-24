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
    if (principal != null) { // If user logged in
      model.addAttribute("user", principal.getUserInfo()); // Add logged in user info to model
    }

    // serve index.html
    return "index";
  }

  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  public String getProfile(Model model, @AuthenticationPrincipal OidcUser principal) {
    OidcUserInfo user = principal.getUserInfo();

    ObjectMapper mapper = new ObjectMapper();
    JsonNode userJson = mapper.convertValue(user, JsonNode.class);

    model.addAttribute("user", user); // Add logged in user info to model
    model.addAttribute("userPrettified", userJson.toPrettyString());

    // serve profile.html
    return "profile";
  }
}