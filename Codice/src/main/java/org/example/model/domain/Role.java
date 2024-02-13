package org.example.model.domain;

public enum Role {
    MANAGER(1),
    CAMERIERE(2), PIZZAIOLO(3), BARISTA(4);



    private final int id;

    private Role(int id) {
        this.id = id;
    }

    public static Role fromInt(int id) {
        for (Role type : values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
