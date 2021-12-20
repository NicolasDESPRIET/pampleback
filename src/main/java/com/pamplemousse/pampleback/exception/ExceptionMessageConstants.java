package com.pamplemousse.pampleback.exception;

public final class ExceptionMessageConstants {
    private ExceptionMessageConstants() {
    }

    // User message exception
    public static final String USER_NOT_FOUND_IN_DB = "no user with this name persisted in the db";
    public static final String USER_ID_NOT_FOUND_IN_DB = "no user with this id persisted in the db";
    public static final String USER_TYPE_NOT_FOUND_IN_DB = "no type with this id persisted in the db";
    public static final String USER_NAME_USED_IN_DB = "Username Already used in db";


    //Type Message Exception
    public static final String TYPE_NOT_FOUND_IN_DB = "no type with this id persisted in the db";
    public static final String TYPE_NAME_ALREADY_USED_IN_DB = "this type names is already used in db";
}
