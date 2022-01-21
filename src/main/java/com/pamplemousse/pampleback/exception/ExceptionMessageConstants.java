package com.pamplemousse.pampleback.exception;

public final class ExceptionMessageConstants {
    private ExceptionMessageConstants() {
    }

    // User message exception
    public static final String USER_NOT_FOUND_IN_DB = "no user with this name persisted in the db";
    public static final String USER_ID_NOT_FOUND_IN_DB = "no user with this id persisted in the db";
    public static final String USER_TYPE_NOT_FOUND_IN_DB = "no type with this id persisted in the db";
    public static final String USER_NAME_USED_IN_DB = "Username Already used in db";


    // Type Message Exception
    public static final String TYPE_NOT_FOUND_IN_DB = "no type with this id persisted in the db";
    public static final String TYPE_NAME_ALREADY_USED_IN_DB = "this type names is already used in db";

    // Question Message Exception
    public static final String QUESTION_ID_NOT_FOUND_IN_DB = "no question with this id found in db";
    public static final String QUESTION_NOT_FOUND_IN_DB = "no question with this ennonce found in db";
    public static final String QUESTION_ENNONCE_USED_IN_DB = "Ennonce Question Already used in db";
    public static final String QUESTION_ID_ERROR = "id with question update and question in db are different";

    // QCM Message Exception
    public static final String QCM_ID_NOT_FOUND_IN_DB = "no qcm with this id found in db";
    public static final String QCM_NOT_FOUND_IN_DB = "no qcm with this name found in db";
    public static final String QCM_NAME_USED_IN_DB = "QCM name Already used in db";
    public static final String QCM_ID_ERROR = "id with qcm update and qcm in db are different";
    public static final String QUESTION_WITH_THIS_ENNONCE_ALREADY_IN_QCM = "question with this ennonce already in the qcm";
}
