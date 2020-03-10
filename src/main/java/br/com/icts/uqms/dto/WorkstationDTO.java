package br.com.icts.uqms.dto;

import org.springframework.data.domain.Page;

import br.com.icts.uqms.domain.Workstation;

public class WorkstationDTO {

    private Long id;
    private String name;
    private Boolean critic;

    public WorkstationDTO(Workstation workstation) {
        this.id = workstation.getId();
        this.name = workstation.getName();
        this.critic = workstation.getCritic();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

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

	public static Page<WorkstationDTO> convert(Page<Workstation> workstations) {
        return workstations.map(WorkstationDTO::new);
	}

}