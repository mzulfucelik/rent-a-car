package com.mzulfucelik.rentacar.aop;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@NoArgsConstructor
@Component
public class RestHandlerInterceptor implements HandlerInterceptor {
  private static final String ORIGIN = "Origin";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    fillResponseAccessControlAllowOrigin(request, response);
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  private void fillResponseAccessControlAllowOrigin(
      HttpServletRequest request, HttpServletResponse response) {
    if (request.getHeader(ORIGIN) != null) {
      String origin = request.getHeader(ORIGIN);
      response.setHeader("Access-Control-Allow-Origin", origin);
      response.setHeader("Access-Control-Allow-Credentials", "true");
      response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT,DELETE");
      response.setHeader("Access-Control-Allow-Headers", "*");
    }
  }
}
