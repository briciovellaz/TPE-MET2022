package com.company;

public abstract class Profesional {
    private String nombre,contrasenia; //DNI se usara como idenficador de usuario
    private int DNI;
    private String domicilio;
    private String curriculum;
    private String descripcionPersonal;
    private String email;
    private int nroTelefono;
    private Institucion institucion;
    //consulta DNI si es igual devuelve true
    public boolean validarDNI(int DNI){
        return (DNI == this.DNI);
    }
    //consulta pass si es igual devuelve true
    public boolean validarContrasenia(int DNI,String contrasenia){
        return contrasenia.equals(this.contrasenia)&& this.DNI == DNI;
    }

    public Profesional(String nombre, String contrasenia, int dni, String domicilio, String especialidad, String des, String mail, int nro,Institucion inst){
        this.nombre=nombre;
        this.contrasenia=contrasenia;
        this.DNI=dni;
        this.domicilio = domicilio;
        this.curriculum = especialidad;
        this.descripcionPersonal = des;
        this.email = mail;
        this.nroTelefono = nro;
        this.institucion = inst;
    }

    public Institucion getInstitucion(){ return this.institucion;}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){ this.nombre = nombre;}

    public int getDNI() {return DNI;}

    public String getDomicilio() { return domicilio;}

    public void setDomicilio(String domicilio){ this.domicilio=domicilio;}

    public String getCurriculum() { return curriculum;}

    public void setCurriculum(String Curriculum){ this.curriculum=Curriculum;}

    public String getDescripcionPersonal(){ return descripcionPersonal;}

    public void setDescripcionPersonal(String descripcion){ this.descripcionPersonal=descripcion;}

    public String getEmail(){ return email;}

    public void setEmail(String email){ this.email= email; }

    public int getNroTelefono() { return nroTelefono;}

    public void setNroTelefono(int nroTelefono){ this.nroTelefono=nroTelefono; }

    public void modificarContrasenia(String nueva){
            this.contrasenia = nueva;
    }



}