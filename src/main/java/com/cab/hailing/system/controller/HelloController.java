package com.cab.hailing.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

  /**
   * Home action.
   *
   * @return Swagger page.
   */
  @RequestMapping("/")
  public String home() {
    return "redirect:swagger-ui.html";
  }

  /** Health check. */
  @RequestMapping("/health")
  public String health() {
    return "redirect:actuator/health";
  }

  }