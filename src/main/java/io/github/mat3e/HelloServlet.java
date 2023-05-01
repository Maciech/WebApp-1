package io.github.mat3e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class HelloServlet extends HttpServlet {
    private static final String NAME_PARAM = "name";
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private final HelloService service;

    /**
     * Servlet container needs it
     */
    @SuppressWarnings("unused")
    public HelloServlet(){
        this(new HelloService());
    }
    HelloServlet(HelloService service){
        this.service = service;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Request with parameters "+ req.getParameterMap()+ " got");
        resp.getWriter().write(service.prepareGreeting(req.getParameter(NAME_PARAM)));

    }
}