/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.model;

import brain.controller.IAction;

/**
 *
 * @author Brain
 */
public class ClsGamme implements IAction{
    private int _id;
    private String _gamme;

    public ClsGamme() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getGamme() {
        return _gamme;
    }

    public void setGamme(String _gamme) {
        this._gamme = _gamme;
    }

    @Override
    public boolean saveData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
