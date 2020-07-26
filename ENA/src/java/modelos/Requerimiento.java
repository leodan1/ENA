/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author leo
 */
public class Requerimiento {
    int id;
    private int gerencia;
    private int departamento;
    private int asigna;
    private int encargado;
    private String requerimientoo;
    
    public Requerimiento(){}
    
    public Requerimiento(int id, int gerencia, int departamento, int asigna, int encargado, String requerimientoo) {
        this.id = id;
        this.gerencia = gerencia;
        this.departamento = departamento;
        this.asigna = asigna;
        this.encargado = encargado;
        this.requerimientoo = requerimientoo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGerencia() {
        return gerencia;
    }

    public void setGerencia(int gerencia) {
        this.gerencia = gerencia;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public int getAsigna() {
        return asigna;
    }

    public void setAsigna(int asigna) {
        this.asigna = asigna;
    }

    public int getEncargado() {
        return encargado;
    }

    public void setEncargado(int encargado) {
        this.encargado = encargado;
    }

    public String getRequerimientoo() {
        return requerimientoo;
    }

    public void setRequerimientoo(String requerimientoo) {
        this.requerimientoo = requerimientoo;
    }

    
    
}
