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
public class ClsQuantification implements  IAction{
    private int _id;
    private String _quantification;

    public ClsQuantification() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getQuantification() {
        return _quantification;
    }

    public void setQuantification(String _quantification) {
        this._quantification = _quantification;
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
