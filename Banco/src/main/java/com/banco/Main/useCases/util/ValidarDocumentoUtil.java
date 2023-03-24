package com.banco.Main.useCases.util;


import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import org.springframework.stereotype.Component;

import javax.swing.*;

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

    public Boolean validarCNPJ(String cnpj) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        try {
            cnpjValidator.assertValid(cnpj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
