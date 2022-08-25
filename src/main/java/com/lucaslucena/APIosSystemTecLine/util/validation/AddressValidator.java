package com.lucaslucena.APIosSystemTecLine.util.validation;

import com.lucaslucena.APIosSystemTecLine.models.AddressModel;
import org.springframework.stereotype.Component;

@Component
public class AddressValidator implements Validator<AddressModel> {
    @Override
    public Boolean isValid(AddressModel addressModel) {
        return addressModel.getCep().length() == 8;
    }
}
