package co.com.freelance.products.loadmessage;

import co.com.freelance.products.model.exception.ValidationMessageEnum;
import co.com.freelance.products.model.product.gateways.message.MessageException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LoadMessageImpl implements MessageException {
    private final MessageSource messageValidationSource;

    public LoadMessageImpl(MessageSource messageValidationSource) {
        this.messageValidationSource = messageValidationSource;
    }

    @Override
    public String resolveMessage(ValidationMessageEnum messageEnum) {
        return messageValidationSource.getMessage(messageEnum.getMessage(), null, LocaleContextHolder.getLocale());
    }
}
