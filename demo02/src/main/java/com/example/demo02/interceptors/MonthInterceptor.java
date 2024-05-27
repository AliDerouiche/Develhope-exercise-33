package com.example.demo02.interceptors;

import com.example.demo02.entities.MonthEntity;
import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MonthInterceptor.class);
    private static final Map<Integer, MonthEntity> months = Map.of(
            1, new MonthEntity(1, "January", "Gennaio", "Januar"),
            2, new MonthEntity(2, "February", "Febbraio", "Februar"),
            3, new MonthEntity(3, "March", "Marzo", "Marz"),
            4, new MonthEntity(4, "April", "Aprile", "April"),
            5, new MonthEntity(5, "May", "Maggio", "Mai"),
            6, new MonthEntity(6, "June", "Giugno", "Juni")
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberStr = request.getHeader("monthNumber");
        if (monthNumberStr == null || monthNumberStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'header monthNumber è obbligatorio");
            return false;
        }
        try {
            int monthNumber = Integer.parseInt(monthNumberStr);
            MonthEntity month = months.get(monthNumber);
            if (month != null) {
                request.setAttribute("month", month);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Numero di mese non valido");
                return false;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato del numero di mese non valido");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
