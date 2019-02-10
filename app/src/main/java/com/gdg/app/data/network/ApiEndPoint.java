package com.gdg.app.data.network;

public final class ApiEndPoint {

    public final static String LOGIN = "users/login";
    public final static String SENSOR = "sensors";
    public final static String NOTIFICATION = "notifications";
    public final static String USERS = "users";
    public final static String PERSONS = "persons";

    public final static String MEASUREMENT_DELETE = "sensors/{sensor_id}/measurements/{measurement_id}";
    public final static String MEASUREMENT_LIST = "sensors/{sensor_id}/measurements";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
