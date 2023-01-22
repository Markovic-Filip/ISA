package isa.isa.user.domain.enumeration;

public enum Roles {
    CenterAdministator(Values.CenterAdministrator), SystemAdministrator(Values.SystemAdministrator), Donator(Values.Donator), MedicalStaff(Values.MedicalStaff);

    Roles(String value) {
        if (!this.name().equals(value))
            throw new IllegalArgumentException("Incorrect use of Role!");
    }

    public static class Values {
        public static final String CenterAdministrator = "CenterAdministrator";
        public static final String SystemAdministrator = "SystemAdministrator";
        public static final String Donator = "Donator";
        public static final String MedicalStaff = "MedicalStaff";
    }
}


