package by.mall;

public class LoginMessage {
    public static final String ERROR_NO_CREDENTIALS = "Поле \"Номер телефона\" обязательно для заполнения.\n" +
            "Поле \"Пароль\" обязательно для заполнения.";
    public static final String ERROR_NO_PASSWORD = "Поле \"Пароль\" обязательно для заполнения.";
    public static final String ERROR_NO_PHONE_NUMBER = "Значение поля \"Номер телефона\" должно начинаться" +
            " с +375 затем код (25|29|33|44) и далее 7 цифр (первая из которых не 0)";
}
