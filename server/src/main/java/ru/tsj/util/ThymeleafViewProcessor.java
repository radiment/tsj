package ru.tsj.util;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.template.ViewProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@Provider
@Produces({"text/html", "application/xml", "text/plain"})
@Component
public class ThymeleafViewProcessor implements ViewProcessor<String> {

    @Autowired
    TemplateEngine templateEngine;

    @Context
    ServletContext servletContext;

    @Context
    ThreadLocal<HttpServletRequest> requestInvoker;

    @Context
    ThreadLocal<HttpServletResponse> responseInvoker;



    @Override
    public String resolve(String path) {
        return path;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void writeTo(String path, Viewable viewable, OutputStream out) throws IOException {
        out.flush();
        WebContext context = new WebContext(requestInvoker.get(), responseInvoker.get(), servletContext);
        Map<String, Object> model = (Map<String, Object>) viewable.getModel();
        context.setVariables(model);
        templateEngine.process(viewable.getTemplateName(), context, responseInvoker.get().getWriter());
    }
}
