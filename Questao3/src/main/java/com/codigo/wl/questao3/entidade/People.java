package com.codigo.wl.questao3.entidade;

/**
 * @Date 06/10/2017 @Time 21:25:13
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class People {

    private int id;
    private String name;
    private boolean statusAttendance = false;

    public People() {
    }

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatusAttendance() {
        return statusAttendance;
    }

    public void setStatusAttendance(boolean statusAttendance) {
        this.statusAttendance = statusAttendance;
    }


    @Override
    public String toString() {
        return "{ id=" + id + ", name=" + name + ", statusAttendance=" + statusAttendance+ "}\n";
    }
    

    
    

}
