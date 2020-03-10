package br.com.icts.uqms.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.icts.uqms.domain.Workstation;

public class WorkstationFormDTO {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
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

    public Workstation convert(Long id) {
        return new Workstation(id, this.name, this.critic);
    }

}