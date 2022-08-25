package com.lucaslucena.APIosSystemTecLine.util.validation;
import br.com.caelum.stella.validation.CPFValidator;

import java.util.*;

public class CpfValidator implements Validator<String> {
//    @Override
//    public Boolean isValid(String value) {
//
//        if (value.length() != 11) {
//            return false;
//        }
//
//        List<String> invalidCpfs = new ArrayList<>(List.of("12345678912", "98765432198", "12312312312"));
//        for (String i : invalidCpfs) {
//            if (value.equals(i)) {
//                return false;
//            }
//        }
//
//        // The HashSet is used here to verify if all chars are identical, ex:. 11111111111, 22222222222 ...
//        Set<String> set = new HashSet<>(Arrays.asList(value.split("")));
//        return set.size() != 1;
//    }

    @Override
    public Boolean isValid(String value) {
        CPFValidator validator = new CPFValidator();
        validator.assertValid(value);
        return null;
    }
}
