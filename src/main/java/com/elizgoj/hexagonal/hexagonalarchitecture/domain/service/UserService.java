package com.elizgoj.hexagonal.hexagonalarchitecture.domain.service;

import com.elizgoj.hexagonal.hexagonalarchitecture.domain.entity.User;

public class UserService {

    public static String validarUsuario(User user) {
        StringBuilder erros = new StringBuilder();

        if (user == null) {
            return "Usuário inválido: corpo da requisição está vazio.";
        }

        if (!validaNome(user.getNome())) {
            erros.append("Nome inválido. Informe nome e sobrenome com pelo menos 2 caracteres cada.\n");
        }

        if (!validCPF(user.getCpf())) {
            erros.append("CPF inválido.\n");
        }

        if (!validaTelefone(user.getTelefone())) {
            erros.append("Telefone inválido.\n");
        }

        if (!isValidEmail(user.getEmail())) {
            erros.append("E-mail inválido.\n");
        }

        return erros.toString().trim();
    }

    private static boolean validCPF(String cpf) {
        if (cpf == null) {
            return false;
        }
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * (10 - i);
            }
            int firstDigit = 11 - (sum % 11);
            firstDigit = (firstDigit > 9) ? 0 : firstDigit;

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * (11 - i);
            }
            int secondDigit = 11 - (sum % 11);
            secondDigit = (secondDigit > 9) ? 0 : secondDigit;

            return cpf.charAt(9) - '0' == firstDigit && cpf.charAt(10) - '0' == secondDigit;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean validaNome(String name) {
        if (name == null) {
            return false;
        }

        name = name.trim();

        if (name.isEmpty()) {
            return false;
        }

        if (!name.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
            return false;
        }

        String[] parts = name.split(" +");

        if (parts.length < 2) {
            return false;
        }

        for (String part : parts) {
            if (part.length() < 2) {
                return false;
            }
        }

        return true;
    }

    private static boolean validaTelefone(String phone) {
        if (phone == null) {
            return false;
        }

        String digits = phone.replaceAll("\\D", "");

        if (digits.length() != 10 && digits.length() != 11) {
            return false;
        }

        int ddd = Integer.parseInt(digits.substring(0, 2));
        if (ddd < 11 || ddd > 99) {
            return false;
        }

        if (digits.length() == 11 && digits.charAt(2) != '9') {
            return false;
        }

        if (digits.length() == 10) {
            char third = digits.charAt(2);
            if (third < '2' || third > '8') {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        email = email.trim();

        if (email.isEmpty()) {
            return false;
        }

        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        return email.matches(emailRegex);
    }
}
