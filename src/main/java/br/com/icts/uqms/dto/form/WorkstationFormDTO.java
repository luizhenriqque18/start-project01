package br.com.icts.uqms.dto.form;

import java.lang.reflect.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.icts.uqms.domain.Workstation;
import br.com.icts.uqms.validations.handler.Existing;

public class WorkstationFormDTO {

    @NotNull(groups = Existing.class)
    @NotEmpty(groups = Existing.class)
    private String name;

    @NotNull(groups = Existing.class)
    private Boolean critic;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the critic
     */
    public Boolean getCritic() {
        return critic;
    }

    /**
     * @param critic the critic to set
     */
    public void setCritic(Boolean critic) {
        this.critic = critic;
    }

    public Workstation convert() {
        return new Workstation(this.name, this.critic);
    }

    public Workstation convert(Workstation workstation) {
        for (Field f : this.getClass().getDeclaredFields()) {
            try {
                if (f.get(this) == null) {
                    try {
                        Field new_field = workstation.getClass().getDeclaredField(f.getName());
                        new_field.setAccessible(true);
                        f.set(this, new_field.get(workstation));
                    } catch(NoSuchFieldException e) {
                        System.out.println(e);
                    }
                }
            } catch (IllegalAccessException e){
                System.out.println(e);
            }
        }

        return new Workstation(workstation.getId(), this.name, this.critic);
    }

}