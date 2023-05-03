package co.com.freelance.interceptor;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component
public class LocaleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String localeHeader = request.getHeader("Accept-Language");
        Locale locale = Locale.forLanguageTag(localeHeader);
        Locale local = new Locale(localeHeader.split("_")[0],localeHeader.split("_")[1]);
        LocaleContextHolder.setLocale(local);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LocaleContextHolder.resetLocaleContext();
    }
}