/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.models;

import brain.controller.ClsUpdateModel;
import brain.controller.IAction;

/**
 *
 * @author Brain
 */
public class ClsAccessSetup implements  IAction{
    private int _id;
    private String _accessLevel;

    public ClsAccessSetup() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getAccessLevel() {
        return _accessLevel;
    }

    public void setAccessLevel(String _accessLevel) {
        this._accessLevel = _accessLevel;
    }

    @Override
    public boolean saveData() throws Exception {       
        return ClsUpdateModel.updateData(this);
    }

    @Override
    public boolean deleteData() throws Exception {
        return ClsUpdateModel.deleteData("t_access_setup", getId());
    }
    
}
