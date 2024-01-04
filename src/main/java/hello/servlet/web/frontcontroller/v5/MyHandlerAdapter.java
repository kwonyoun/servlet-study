package hello.servlet.web.frontcontroller.v5;

import java.io.IOException;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {
    boolean supports(Object heandler);

    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object heandler) throws ServletException, IOException;
    
}
