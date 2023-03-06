package com.banco.Main.useCases.util;


import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.stereotype.Component;

@Component
public class ValidarDocumentoUtil {

    public Boolean validarCPF(String documento) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(documento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
