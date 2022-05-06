package edu.utfpr.data.validators;

public class Validators {

    public static Boolean validateString(String string) {
        return !(string.isEmpty() || string.isBlank());
    }

    public static Boolean validateCPF(String cpf) {
        if (cpf != null && !cpf.isEmpty()) {
            if (!cpf.equals("00000000000") && cpf.length() == 11) {
                int[] foundDv = new int[]{0, 0};
                int dv1 = Integer.parseInt(String.valueOf(cpf.charAt(cpf.length() - 2)));
                int dv2 = Integer.parseInt(String.valueOf(cpf.charAt(cpf.length() - 1)));

                for(int j = 0; j < 2; ++j) {
                    int sum = 0;
                    int coeficient = 2;

                    for(int i = cpf.length() - 3 + j; i >= 0; --i) {
                        int digit = Integer.parseInt(String.valueOf(cpf.charAt(i)));
                        sum += digit * coeficient;
                        ++coeficient;
                    }

                    foundDv[j] = 11 - sum % 11;
                    if (foundDv[j] >= 10) {
                        foundDv[j] = 0;
                    }
                }

                return dv1 == foundDv[0] && dv2 == foundDv[1];
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
