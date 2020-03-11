package br.com.icts.uqms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workstation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "critic")
    private Boolean critic;

    public Workstation() {

    }

    public Workstation(Long id, String name, Boolean critic) {
        this.id = id;
        this.name = name;
        this.critic = critic;
    }

    public Workstation(String name, Boolean critic) {
        this.name = name;
        this.critic = critic;
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


}