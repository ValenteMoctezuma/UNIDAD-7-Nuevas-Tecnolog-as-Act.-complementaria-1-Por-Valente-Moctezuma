package fca.unam.mx.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class ClientDto {
    private Long id;
    private String firstName;
    private String lastNamePaternal;
    private String lastNameMaternal;
    private String rfc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ColumnName("nombre")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @ColumnName("apellido_paterno")
    public String getLastNamePaternal() {
        return lastNamePaternal;
    }

    public void setLastNamePaternal(String lastNamePaternal) {
        this.lastNamePaternal = lastNamePaternal;
    }

    @ColumnName("apellido_materno")
    public String getLastNameMaternal() {
        return lastNameMaternal;
    }

    public void setLastNameMaternal(String lastNameMaternal) {
        this.lastNameMaternal = lastNameMaternal;
    }

    @ColumnName("rfc")
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
