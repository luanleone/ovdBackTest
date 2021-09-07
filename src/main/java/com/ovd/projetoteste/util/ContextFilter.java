package com.ovd.projetoteste.util;

import javax.servlet.*;
import java.io.IOException;


/**
 * Classe responsável por interceptar o inicio da aplicação e disponibilizar o
 * ServletContext para a Aplicação.
 *
 * @author Luan
 */
public class ContextFilter implements Filter {

    private static String empresa;
    private static FilterConfig config;
    private static ServletContext servletContext;


    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            config = filterConfig;
            servletContext = filterConfig.getServletContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Retorna o Contexto da aplicação.
     *
     * @return ServletContext
     */
    public static ServletContext getServletContext() {
        return servletContext;
    }

}
