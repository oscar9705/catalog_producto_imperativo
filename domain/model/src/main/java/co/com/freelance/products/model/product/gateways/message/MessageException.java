package co.com.freelance.products.model.product.gateways.message;

import co.com.freelance.products.model.exception.ValidationMessageEnum;

import java.util.Locale;

public interface MessageException {
    String resolveMessage(ValidationMessageEnum messageEnum);
}
